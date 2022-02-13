package com.lemon.homework;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 软柠柠吖
 * @date 2022/2/12
 */
public class HomeWork02 {
	public static void main(String[] args) {

	}

	@Test
	public void readFile() {
		// 文件路径
		String filePath = "D:\\data.txt";
		BufferedReader bufferedReader = null;
		try {
			// 创建 BufferedReader对象
			// 默认编码方式 utf-8 读取文件
			// bufferedReader = new BufferedReader(new FileReader(filePath));

			// 按照指定编码方式 读取文件
			String charSet = "gbk";
			// (转换流) FileInputStream->InputStreamReader[可以指定编码]->BufferedReader
			bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), charSet));
			// 行号
			int lineNum = 1;
			// 按行读取
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(lineNum++ + " " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
