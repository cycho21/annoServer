package kr.ac.uos.ai.annotator.taskpacker;

import org.junit.Test;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 14.
 */

public class TaskPackerCore {
	
	private static TaskPacker taskPacker;
	
	public TaskPackerCore() {
		init();
	}

	public void init() {
		taskPacker = new TaskPacker();
	}

	public TaskPacker getCompressor() {
		return taskPacker;
	}
	
	@Test
	public void Test() {
		TaskPacker taskPacker = new TaskPacker();
		taskPacker.setTempJarFilePath("F:/jartest/newJar.jar");
		taskPacker.init();
	}
	
}
