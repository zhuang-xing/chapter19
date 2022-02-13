package com.lemon.reader_;


import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author 软柠柠吖
 * @date 2022/2/5
 */
public class FileReader01 {
	/**
	 * 使用单个字符读取文件
	 */
	@Test
	public void readFile() {
		String filePath = "D:\\story.txt";
		// 1.创建FileReader 对象
		FileReader reader = null;
		int c = 0;
		try {
			reader = new FileReader(filePath);
			// 循环读取 使用read, 单个字符读取,效率低
			// read方法 返回的是文件中的字符或者到达文件末尾的-1, 所以用char 无法接收
			// 但是字符的本质就是一个数字，所以用 int来接收这两种情况
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 使用 字符数组 读取文件
	 */
	@Test
	public void readFile2() {
		String filePath = "D:\\story.txt";
		// 1.创建FileReader 对象
		FileReader reader = null;
		// 字符数组
		char[] buff = new char[1024];
		int readLen = 0;
		try {
			reader = new FileReader(filePath);
			// 循环读取, 使用read(buff), 返回的是实际读取到的字符数, 效率高
			// 如果返回-1，说明到文件末尾
			while ((readLen = reader.read(buff)) != -1) {
				System.out.print(new String(buff, 0, readLen));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
