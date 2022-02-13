package com.lemon.print;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
public class PrintStream1 {
	@Test
	public void printStream() throws IOException {
		// PrintStream 字节打印流/输出流
		PrintStream out = System.out;
		// 在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
		/*
			public void print(String s) {
		        if (s == null) {
		            s = "null";
		        }
		        write(s);
		    }
		 */
		out.print("软柠柠吖");
		// 因为 print底层使用的是 write，所以我们可以 直接调用write 进行打印/输出
		out.write(" 你好，软柠柠吖".getBytes());

		// 我们可以去修改 打印流 输出的位置/设备
		// 1.输出修改成到 D:\t2.txt
		// 2."你好，软柠柠吖" 就会输出到 D:\t2.txt
		// 3.源码
		/*
			public static void setOut(PrintStream out) {
		        checkIO();
		        setOut0(out);// native 方法，修改了out
		    }
		 */
		System.setOut(new PrintStream("D:\\t2.txt"));
		System.out.println("你好，软柠柠吖");

		out.close();
	}
}
