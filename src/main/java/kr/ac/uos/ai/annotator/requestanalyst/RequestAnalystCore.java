package kr.ac.uos.ai.annotator.requestanalyst;

import kr.ac.uos.ai.annotator.taskarchiver.TaskUnpacker;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 * on 2015-10-01
 */

public class RequestAnalystCore {

    private TaskUnpacker taskUnpacker;

    public RequestAnalystCore() {

    }

    public void init() {
    }

    public TaskUnpacker getTaskUnpacker() {
        return taskUnpacker;
    }

    public void setTaskUnpacker(TaskUnpacker taskUnpacker) {
        this.taskUnpacker = taskUnpacker;
    }
}
