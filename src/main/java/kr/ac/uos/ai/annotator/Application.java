package kr.ac.uos.ai.annotator;

import kr.ac.uos.ai.annotator.activemq.ActiveMQManager;
import kr.ac.uos.ai.annotator.activemq.Sender;
import kr.ac.uos.ai.annotator.taskdistributor.ByteGenerator;
import kr.ac.uos.ai.annotator.taskpacker.TaskPacker;
import kr.ac.uos.ai.annotator.taskpacker.TaskPackerCore;
import kr.ac.uos.ai.annotator.taskdistributor.TaskDistributorCore;

/**
 * Created by HentaiMaster on 2015-09-16.
 */
public class Application {

    private ActiveMQManager amqm;
    private ByteGenerator fmaker;
    private Sender sdr;
    private TaskPacker taskPacker;

    public Application() {
        makeSender();
        startApplication();
    }

    public static void main(String[] args) {
        new Application();
    }

    /*
         *  ActiveMQManager
         *  ByteGenerator
         *  TaskPacker
     */
    private void startApplication() {
        TaskPackerCore fca = new TaskPackerCore();
        TaskDistributorCore fma = new TaskDistributorCore();
        fca.init();
        fma.init();
        amqm = fma.getActiveMQManager();
        amqm.init("FileTest");
        fmaker = fma.getFileMaker();
        fmaker.init();
        taskPacker = fca.getCompressor();
        taskPacker.makeTempJar("F:/jartest/testJar.jar");

        byte[] tempByte = taskPacker.file2Byte("F:/jartest/testJar.jar");
        sdr.sendMessage(tempByte);
    }

    private void makeSender() {
        sdr = new Sender();
        sdr.init();
        sdr.createQueue("FileTest");
    }

}
