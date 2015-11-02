package kr.ac.uos.ai.annotator;

import kr.ac.uos.ai.annotator.activemq.ActiveMQManager;
import kr.ac.uos.ai.annotator.activemq.Sender;
import kr.ac.uos.ai.annotator.taskarchiver.TaskUnpacker;
import kr.ac.uos.ai.annotator.taskdistributor.TaskDistributor;
import kr.ac.uos.ai.annotator.taskarchiver.TaskPacker;
import kr.ac.uos.ai.annotator.taskarchiver.TaskArchiverCore;
import kr.ac.uos.ai.annotator.taskdistributor.TaskDistributorCore;

/**
 * Created by HentaiMaster on 2015-09-16.
 */
public class Application {

    private ActiveMQManager amqm;
    private TaskUnpacker fmaker;
    private Sender sdr;
    private TaskPacker taskPacker;
    private TaskDistributor tdr;

    public Application() {
        makeSender();
        startApplication();
    }

    public static void main(String[] args) {
        new Application();
    }

    /*
         *  ActiveMQManager
         *  TaskUnpacker
         *  TaskPacker
     */
    private void startApplication() {
        TaskArchiverCore fca = new TaskArchiverCore();
        TaskDistributorCore fma = new TaskDistributorCore();
        TaskUnpacker unpacker = new TaskUnpacker();

        tdr = fma.getTaskDistributor();
        fca.init();
        fma.init();
        amqm = fma.getActiveMQManager();
        amqm.init("FileTest");
        fmaker = fma.getFileMaker();
        taskPacker = fca.getPacker();
        taskPacker.setPackedTaskPath("F:/jartest/testJar33.jar");
        taskPacker.init();
        taskPacker.addTaskElement("kr/ac/uos/ai/annotator/activemq/Sender.class");
        taskPacker.addTaskElement("kr/ac/uos/ai/annotator/activemq/Receiver.class");
        taskPacker.packTask("F:/jartest/testJar33.jar");

        byte[] tempByte = taskPacker.file2Byte("F:/jartest/testJar33.jar");
        sdr.sendMessage(tempByte);
    }

    private void makeSender() {
        sdr = new Sender();
        sdr.init();
        sdr.createQueue("FileTest");
    }

}
