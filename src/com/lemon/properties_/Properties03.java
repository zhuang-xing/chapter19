package com.lemon.properties_;


import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
public class Properties03 {
	public static void main(String[] args) throws IOException {
		// 使用Properties 类来 创建配置文件，修改配置文件内容

		// 创建Properties 对象
		Properties properties = new Properties();
		// 创建
		// 1.如果该文件没有key 就是创建
		// 2.如果该文件有key, 就是修改
		properties.setProperty("charSet", "utf8");
		// 注意 保存时，是中文的Unicode码
		properties.setProperty("user", "汤姆");
		properties.setProperty("pwd", "55555");
		// 将k-v 存储到文件中即可 内存->文件
		properties.store(new FileOutputStream("src\\mysql2.properties"), null);
		System.out.println("保存配置文件成功~");
	}
}
