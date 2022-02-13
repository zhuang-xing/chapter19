package com.lemon.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
public class Properties01 {
	// 传统方案
	public static void main(String[] args) throws IOException {
		// 读取mysql.properties 文件，并得到 ip,user和pwd
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\mysql.properties"));
		String line = null;
		// 循环读取
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split("=");
			if ("ip ".equals(split[0])) {
				System.out.println(split[0] + "值为：" + split[1]);
			}
		}
		bufferedReader.close();
	}
}
