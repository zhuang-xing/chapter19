package com.lemon.reader_;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/6
 */
public class BufferedReader01 {

	@Test
	public void readFile() {
		// 文件地址
		String filePath = "D:\\1.txt";
		BufferedReader bufferedReader = null;
		try {
			// 创建BufferedReader对象(java.io)
			bufferedReader = new BufferedReader(new FileReader(filePath));
			// 按行读取，效率高
			String line = null;
			// 说明
			// 1.bufferedReader.readLine() 是按行读取文件
			// 2.当返回null 时，表示文件读取完毕
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流，这里注意，只需要关闭 BufferedReader，因为底层会自动的去关闭 节点流
			/*  bufferedReader.close();源码
				public void close () throws IOException {
					synchronized (lock) {
						if (in == null)
							return;
						try {
							in.close();// in 就是我们传入的 new FileReader(filePath)对象，关闭了节点流
						} finally {
							in = null;
							cb = null;
						}
					}
				}
			*/
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
