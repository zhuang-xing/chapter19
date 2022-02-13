package com.lemon.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/4
 * 演示FileInputStream 的使用(字节输入流  文件--> 程序)
 */
public class FileInputStream_ {

	/**
	 * 演示读取文件...
	 * 单个字节读取，效率低
	 * 优化-> 使用read(byte[] b)
	 */
	@Test
	public void readFile01() {
		FileInputStream fileInputStream = null;
		String filePath = "D:\\hello.txt";
		int readData = 0;
		try {
			// 创建 FileInputStream 对象，用于读取 文件
			fileInputStream = new FileInputStream(filePath);
			// 从该输入流只读取一个字节的数据。 如果没有输入可用，此方法将阻止。
			// 如果返回-1, 表示读取完毕。
			// 在UTF-8中，一个汉字由3个字节表示，用字节输入流读取汉字会出现乱码问题
			while ((readData = fileInputStream.read()) != -1) {
				System.out.print((char) readData);// 转成char 显示
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭文件流，释放资源
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 优化
	 * 使用read(byte[] b) 读取文件，提高效率
	 */
	@Test
	public void readFile02() {
		FileInputStream fileInputStream = null;
		String filePath = "D:\\hello.txt";
		// 字节数组
		byte[] buff = new byte[8];// 一次读取8个字节
		int readLen = 0;
		try {
			// 创建 FileInputStream 对象，用于读取 文件
			fileInputStream = new FileInputStream(filePath);
			// 从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
			// 如果返回-1，表示读取完毕
			// 如果读取正常，返回实际读取的字节数
			while ((readLen = fileInputStream.read(buff)) != -1) {
				System.out.print(new String(buff, 0, readLen));// 转成String 显示
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭文件流，释放资源
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
