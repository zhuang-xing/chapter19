package com.lemon.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
public class PrintWriter01 {
	public static void main(String[] args) throws IOException {
		//PrintWriter printWriter = new PrintWriter(System.out);// 标准输出，显示器显示
		PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\t1.txt"));
		printWriter.println("hi, 北京你好~~~~~");

		// flush + 关闭流，才会将数据写入到文件..
		printWriter.close();
	}
}
