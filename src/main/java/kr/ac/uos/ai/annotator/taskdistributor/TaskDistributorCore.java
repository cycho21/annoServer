package kr.ac.uos.ai.annotator.taskdistributor;

import kr.ac.uos.ai.annotator.activemq.ActiveMQManager;
import kr.ac.uos.ai.annotator.taskarchiver.TaskUnpacker;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 8.
 */

public class TaskDistributorCore {

	public TaskDistributorCore() {
	}
	
	public void init() {
	}

    /**
     * @return return object of ActiveMQManager
     */
    public ActiveMQManager getActiveMQManager() {
	    ActiveMQManager activemqManager = new ActiveMQManager();
	    return activemqManager;
		}

    /**
     * @return return object of TaskUnpacker
     */
	public TaskUnpacker getFileMaker() {
	    TaskUnpacker taskUnpacker = new TaskUnpacker();
	    return taskUnpacker;
	}

    /**
     * @return return object of TaskDistributor
     */
	public TaskDistributor getTaskDistributor() {
	    TaskDistributor taskDistributor = new TaskDistributor();
        return taskDistributor;
	}

}