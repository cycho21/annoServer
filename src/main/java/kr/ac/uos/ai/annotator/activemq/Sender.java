package kr.ac.uos.ai.annotator.activemq;

import kr.ac.uos.ai.annotator.bean.Task;
import kr.ac.uos.ai.annotator.bean.type.MsgType;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.HashMap;

public class Sender {
	private ActiveMQConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Queue queue;
	private MessageProducer producer;

	public Sender() {
	
	}

	public void createQueue(String queueName) {
		try {
			queue = session.createQueue(queueName);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		set();
	}

	private void set() {
		try {
			producer = session.createProducer(queue);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

    public void sendMessage(String msg) {
        try {
            Message message = session.createMessage();
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
	public void sendMessage(byte[] msg) {
		BytesMessage message;
		try {
			message = session.createBytesMessage();
			message.writeBytes(msg);
			Task task = new Task("chan8", MsgType.INFO, "test_time");
            HashMap inTask = task.getMetaInfo().getPropertyMap();
			message.setObjectProperty("objectPropertyTest", inTask);
            System.out.println(inTask.get("AUTHOR"));
            producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}