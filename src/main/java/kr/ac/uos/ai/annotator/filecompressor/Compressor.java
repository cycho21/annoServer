package kr.ac.uos.ai.annotator.filecompressor;

import kr.ac.uos.ai.annotator.filemover.FileMaker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

/*
 * This class is written by Chan Yeon, Cho
 * AI-Laboratory, Seoul, Korea
 * 2015. 9. 14. 오후 1:25:25
 */

public class Compressor {

	private String tempJarPath;
	private FileOutputStream fout;
	private JarOutputStream jarOut;
	private byte[] data;

	public Compressor() {
		
	}

	public void setTempJarFilePath(String tempJarFilePath) {
		this.tempJarPath = tempJarFilePath;
	}
	

	public void init() {
		try {
			fout = new FileOutputStream(tempJarPath);
			jarOut = new JarOutputStream(fout);
		} catch (FileNotFoundException e) {
			System.out.println("Make FileOutputStream Failed");
		} catch (IOException e) {
			System.out.println("Make JarOutputStream Failed");
		}
	}
	
	public void addEntry(String classPath) {
			try {
				jarOut.putNextEntry(new ZipEntry(classPath));
				jarOut.write(classPath.getBytes());
			} catch (IOException e) {
				System.out.println("Package Path Added Failed");
			} finally {
				try {
					jarOut.closeEntry();
				} catch (IOException e) {
					System.out.println("Jar Out Close Failed");
				}
			}
	}

	@After
	public void test() {
		setTempJarFilePath("F:/jartest/newJar2.jar");
		init();
		addEntry("kr/ac/uos/ai/annotator/activemq/Sender.class");
		addEntry("kr/ac/uos/ai/annotator/activemq/ActiveMQManager.class");
		try {
			jarOut.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void makeTempJar(String outputFilePath) {
		setTempJarFilePath(outputFilePath);
		init();
		addEntry("kr/ac/uos/ai/annotator/activemq/Sender.class");
		addEntry("kr/ac/uos/ai/annotator/activemq/ActiveMQManager.class");
		try {
			jarOut.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void test2() {
		Path path = Paths.get("F:/jartest/newJar2.jar");
		try {
			data = Files.readAllBytes(path);
			System.out.println(data.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] file2Byte(String jarPath) {
		Path path = Paths.get(jarPath);
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void byte2File(String outputFilePath) {
		byte[] byteAraay = data;
		FileMaker fm = new FileMaker();
		fm.init();
		fm.makeFileFromByteArray(outputFilePath, byteAraay);
	}

	@Test
	public void test3() {
		byte[] byteArray = data;
		FileMaker fM = new FileMaker();
		fM.init();
		fM.makeFileFromByteArray("F:/jartest/ClientTest/asdf.jar", byteArray);
	}
}
