package kr.ac.uos.ai.annotator.taskpacker;

import kr.ac.uos.ai.annotator.taskarchiver.TaskPacker;
import org.junit.Test;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 14.
 */

public class TaskPackerCore {
	

	public TaskPackerCore() {
	}

	public void init() {
	}

	public TaskPacker getPacker() {
		TaskPacker taskPacker = new TaskPacker();
		return taskPacker;
	}
	
	@Test
	public void Test() {
		TaskPacker taskPacker = new TaskPacker();
		taskPacker.setTempJarFilePath("F:/jartest/newJar.jar");
		taskPacker.init();
	}
	
}
