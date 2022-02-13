package com.lemon.writer_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.Buffer;

/**
 * @author 软柠柠吖
 * @date 2022/2/7
 */
public class BufferedCopyFile {
	@Test
	public void bufferedCopyFile() {
		// 说明
		// 1.BufferedReader 和 BufferedWriter 是按照 字符 操作
		// 2.不要去操作 二进制文件[声音、视频、doc、word、pdf]，可能造成文件损坏
		String srcFilePath = "D:\\ok.txt";
		String destFilePath = "D:\\ok2.txt";
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		String line = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(srcFilePath));
			bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
			// 边读边写
			// 说明：readLine 读取一行的内容，但是没有换行,
			//      因此我们通常 配合使用newLine 添加系统换行.
			while ((line = bufferedReader.readLine()) != null) {
				// 每读取一行，就写入
				bufferedWriter.write(line);
				// 插入一个系统换行符
				bufferedWriter.newLine();
			}
			System.out.println("拷贝Ok~");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
