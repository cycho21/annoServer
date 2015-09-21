package kr.ac.uos.ai.annotator;

import kr.ac.uos.ai.annotator.activemq.ActiveMQManager;
import kr.ac.uos.ai.annotator.activemq.Sender;
import kr.ac.uos.ai.annotator.filecompressor.Compressor;
import kr.ac.uos.ai.annotator.filecompressor.FileCompressorApplication;
import kr.ac.uos.ai.annotator.filemover.FileMaker;
import kr.ac.uos.ai.annotator.filemover.FileMoverApplication;

/**
 * Created by HentaiMaster on 2015-09-16.
 */
public class Application {

    private ActiveMQManager amqm;
    private FileMaker fmaker;
    private Sender sdr;
    private Compressor compressor;

    public Application() {
        makeSender();
        startApplication();
    }

    public static void main(String[] args) {
        new Application();
    }

    /*
         *  ActiveMQManager
         *  FileMaker
         *  Compressor
     */
    private void startApplication() {
        FileCompressorApplication fca = new FileCompressorApplication();
        FileMoverApplication fma = new FileMoverApplication();
        fca.init();
        fma.init();
        amqm = fma.getActiveMQManager();
        amqm.init("FileTest");
        fmaker = fma.getFileMaker();
        fmaker.init();
        compressor = fca.getCompressor();
        compressor.makeTempJar("F:/jartest/testJar.jar");

        byte[] tempByte = compressor.file2Byte("F:/jartest/testJar.jar");
        sdr.sendMessage(tempByte);
    }

    private void makeSender() {
        sdr = new Sender();
        sdr.init();
        sdr.createQueue("FileTest");
    }

}
