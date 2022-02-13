package com.lemon.transformation;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
// 1.把 FileOutputStream 字节流，转成字符流 OutputStreamWriter
// 2.指定处理的编码 gbk/utf-8(utf8)
public class OutputStreamWriter01 {

	@Test
	public void writeFile() {
		String destFilePath = "D:\\lemon.txt";
		// utf-8(utf8)、gbk
		String charSet = "gbk";
		OutputStreamWriter outputStreamWriter = null;
		try {
			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(destFilePath), charSet);
			outputStreamWriter.write("你好，软柠柠吖");

			System.out.println("按照" + charSet + "保存文件成功~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStreamWriter != null) {
				try {
					outputStreamWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
