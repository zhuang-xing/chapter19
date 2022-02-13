package com.lemon.transformation;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
// 看一个中文乱码问题
public class CodeQuestion {
	public static void main(String[] args) {

	}

	@Test
	public void readFile() {
		String filePath = "D:\\ok.txt";
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			byte[] buff = new byte[8];
			int readLen = 0;
			while ((readLen = fileInputStream.read(buff)) != -1) {
				System.out.println(new String(buff, 0, readLen));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void readFile2() {
		String filePath = "D:\\ok.txt";

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
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

	@Test
	public void readFile3() {
		String filePath = "D:\\ok.txt";
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try {
			// 1.把 FileInputStream 转成 InputStreamReader
			// 2.指定编码 gbk
			//inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
			// 3.把 InputStreamReader 传入 BufferedReader
			//bufferedReader = new BufferedReader(inputStreamReader);

			// 将2 和 3 合在一起写
			bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), "gbk"));
			// 4.读取
			String line = null;
			System.out.println("==读取内容==");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5.关闭外层流
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
