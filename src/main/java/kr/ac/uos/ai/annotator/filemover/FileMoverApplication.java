package kr.ac.uos.ai.annotator.filemover;

import kr.ac.uos.ai.annotator.activemq.ActiveMQManager;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 8.
 */

public class FileMoverApplication {

	public FileMoverApplication() {
	}
	
	public void init() {
	}
	
	public ActiveMQManager getActiveMQManager() {
		ActiveMQManager activemqManager = new ActiveMQManager();
		return activemqManager;
		}

	public FileMaker getFileMaker() {
		FileMaker fileMaker = new FileMaker();
		return fileMaker;
	}

	}


