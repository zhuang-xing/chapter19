package com.lemon.writer_;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/5
 */
public class FileWriter01 {
	public static void main(String[] args) {

	}

	@Test
	public void writeFile() {
		String filePath = "D:\\note.txt";
		FileWriter fileWriter = null;
		char[] chars = {'a', 'b', 'c'};
		try {
			// 1.fileWriter = new FileWriter(filePath);
			//   此时 fileWriter 的append为默认值false, 新数据覆盖原文件的内容(旧数据被新数据覆盖)
			//   但是同一个fileWriter对象 调用write方法，则是内容追加写入
			// 2.fileWriter = new FileWriter(filePath, true);
			//   此时 fileWriter 的append为true, 追加，在原文件结尾追加新数据(保留旧数据)
			//   同样，同一个fileWriter对象 调用 write方法，则是内容追加写入
			fileWriter = new FileWriter(filePath);// 默认是覆盖写入

			// 同一个 FileWriter对象，调用不同的write方法，依旧是内容追加写入
			// write(int): 写入单个字符
			fileWriter.write('H');
			// write(char[]): 写入指定数组
			fileWriter.write(chars);
			// write(char[],off,len):写入指定数组的指定部分
			fileWriter.write("软柠柠吖".toCharArray(), 0, 3);
			// write(string):写入整个字符串
			fileWriter.write(" 你好，北京~");
			// write(string,off,len):写入字符串的指定部分
			fileWriter.write("上海天津", 0, 2);

			// 总结🏆🏆
			// 1.在数据量大的情况下，可以使用循环操作.
			// 2.如果需要新数据 追加写入 到文件中，则创建对象时 显示指定append 为true(保留旧数据)
			// 3.同一个输出流对象 调用write方法，不论append 为true还是false，都是内容追加写入文件(先到先得)
			// 4.如果不关闭流，那么无法真正的往文件中写入数据

			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 对于FileWriter，一定要关闭流，或者flush 才能真正的把数据写入到文件
			if (fileWriter != null) {
				try {
					// 关闭文件流，等价 flush() + 关闭
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
