package kr.ac.uos.ai.annotator.taskdistributor;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 10.
 */

import kr.ac.uos.ai.annotator.activemq.Sender;
import kr.ac.uos.ai.annotator.bean.Task;
import kr.ac.uos.ai.annotator.bean.TaskInterface;
import kr.ac.uos.ai.annotator.bean.type.MsgType;

public class TaskDistributor implements TaskInterface {

    private Sender sdr;

    public TaskDistributor() {
    }

    public void init() {
    }

    public Task newTask(String author, MsgType type, String time) {
        Task task = new Task(author, type, time);
        return task;
    }

    private void makeSender(String queueName) {
        sdr = new Sender();
        sdr.init();
        sdr.createQueue(queueName);
    }

}
