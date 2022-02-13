package com.lemon.homework;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/12
 */
public class HomeWork01 {
	public static void main(String[] args) {

	}

	@Test
	public void makeFile() {
		// 创建目录
		String directoryPath = "D:\\mytemp";
		File dir = new File(directoryPath);
		if (!(dir.exists() && dir.isDirectory())) {
			if (dir.mkdirs()) {
				System.out.println(directoryPath + " 目录创建OK~~");
			} else {
				System.out.println("目录创建失败！");
			}
		} else {
			System.out.println(directoryPath + " 目录已经存在");
		}

		// 创建文件 D:\mytemp\hello.txt
		String filePath = directoryPath + "\\hello.txt";
		File file = new File(filePath);
		if (!(file.exists() && file.isFile())) {
			try {
				if (file.createNewFile()) {
					System.out.println(file.getName() + " 文件创建成功~~");
				} else {
					System.out.println("文件创建失败！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(file.getName() + " 文件已经存在");
		}

		// 向文件中写入hello，world
		// 使用BufferedWriter 字符输出流 写入信息
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("hello,world~");
			bufferedWriter.flush();

			System.out.println("写入OK~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
