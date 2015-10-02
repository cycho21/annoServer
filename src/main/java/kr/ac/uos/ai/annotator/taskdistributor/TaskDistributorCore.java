package kr.ac.uos.ai.annotator.taskdistributor;

import kr.ac.uos.ai.annotator.activemq.ActiveMQManager;

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
     * @return return object of ByteGenerator
     */
	public ByteGenerator getFileMaker() {
	    ByteGenerator byteGenerator = new ByteGenerator();
	    return byteGenerator;
	}

    /**
     * @return return object of TaskDistributor
     */
	public TaskDistributor getTaskDistributor() {
	    TaskDistributor taskDistributor = new TaskDistributor();
        return taskDistributor;
	}

}