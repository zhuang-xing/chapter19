package com.lemon.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/5
 */
public class FileCopy {
	public static void main(String[] args) {

	}

	/**
	 * 完成 文件拷贝，将D:\\wb.png 拷贝到 C:\\
	 * 思路分析
	 * 1.创建文件的输入流，将文件读入到 Java程序
	 * 2.创建文件的输出流，将读取到的文件数据，写入到指定文件(要指定文件名，不能只指定父类地址)
	 */
	@Test
	public void fileCopy() {
		// 图片所在地址
		String src = "D:\\wb.png";
		// 目的地址
		String dest = "d:\\wb2.png";
		// 输入流
		FileInputStream fileInputStream = null;
		// 输出流
		FileOutputStream fileOutputStream = null;

		int readLen = 0;
		// 定义一个字节数组，提高读取效率
		// 1k = 1024byte
		byte[] buff = new byte[1024];
		try {
			fileInputStream = new FileInputStream(src);
			// 这里不能加true，不是说加上true后，程序就不能运行
			// 而是加上true后，每次运行后，原来的文件都会变大，在文件的末尾追加数据
			// 总结：
			// 1.复制文件时，输出流不能使用追加，即不能加true
			// 2.当向文件添加数据时，需要追加，那就加上true
			fileOutputStream = new FileOutputStream(dest);
			while ((readLen = fileInputStream.read(buff)) != -1) {
				// 读取到后，就写入到文件，通过 fileOutputStream
				// 即 一边读一边写
				fileOutputStream.write(buff, 0, readLen);// 一定要使用这个方法

			}
			System.out.println("复制完成..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭输入流和输出流，释放资源
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
