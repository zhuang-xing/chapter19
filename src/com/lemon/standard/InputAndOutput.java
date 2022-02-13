package com.lemon.standard;

import java.util.Scanner;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
public class InputAndOutput {
	public static void main(String[] args) {
		// 说明
		// System.in 标准输入 键盘
		// System类 的 public final static InputStream in = null;
		// System.in 编译类型 InputStream
		// System.in 运行类型 BufferedInputStream
		System.out.println(System.in.getClass());

		// 说明
		// System.out 标准输出 显示器
		// System类 的 public final static PrintStream out = null;
		// System.out 编译类型 PrintStream
		// System.out 运行类型 PrintStream
		System.out.println(System.out.getClass());

		// 传统方法 System.out.println("");// 是使用 out对象 将数据输出到 显示器
		System.out.println("hello, 软柠柠吖~");

		// 传统方法 Scanner 是从 标准输入 键盘接收数据
		Scanner myScanner = new Scanner(System.in);
		System.out.println("输入内容");
		String str = myScanner.next();
		System.out.println("str=" + str);
	}
}
