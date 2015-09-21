package kr.ac.uos.ai.annotator.filecompressor;

import org.junit.Test;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 14.
 */

public class FileCompressorApplication {
	
	private static Compressor compressor;
	
	public FileCompressorApplication() {
		init();
	}

	public void init() {
		compressor = new Compressor();
	}

	public Compressor getCompressor() {

		return compressor;
	}
	
	@Test
	public void Test() {
		Compressor compressor = new Compressor();
		compressor.setTempJarFilePath("F:/jartest/newJar.jar");
		compressor.init();
	}
	
}
