package com.lemon.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/4
 */
public class FileOutputStream_ {

	/**
	 * 演示使用FileOutputStream 将数据写到文件中，
	 * 如果该文件不存在，则创建文件
	 */
	@Test
	public void writeFile() {

		String filePath = "D:\\a.txt";
		// 创建FileOutputStream 对象
		FileOutputStream fos = null;

		try {
			// 得到 FileOutputStream对象
			// 说明🏆
			// 1.new FileOutputStream(filePath) 创建方式，当写入内容时，会覆盖原来的内容
			// 2.new FileOutputStream(filePath, true) 创建方式，当写入内容时，是追加到文件的末尾，而非覆盖
			// append: 追加(true为追加，false为覆盖)
			fos = new FileOutputStream(filePath, true);
			// 写入一个字节
			// fos.write('H');

			// 写入字符串
			String str = "Hello,World";
			// "韩顺平".getBytes() 把 字符串->字节数组
			// fos.write(str.getBytes());
			fos.write(str.getBytes(), 0, str.length());// 等价于 fos.write(str.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
