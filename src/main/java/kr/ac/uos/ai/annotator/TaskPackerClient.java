package kr.ac.uos.ai.annotator;

import kr.ac.uos.ai.annotator.taskarchiver.TaskPacker;
import kr.ac.uos.ai.annotator.taskpacker.TaskPackerCore;

/**
 * Created by HentaiMaster on 2015-09-16.
 */
public class TaskPackerClient {


    private TaskPacker tPacker;

    public TaskPackerClient() {
        startApplication();
    }

    public static void main(String[] args) {
        new TaskPackerClient();
    }

    /*
         *  ActiveMQManager
         *  FileMaker
         *  Compressor
     */
    private void startApplication() {
        TaskPackerCore tpc = new TaskPackerCore();
        tPacker = tpc.getPacker();
    }

}