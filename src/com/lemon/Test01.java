package com.lemon;


import org.junit.jupiter.api.Test;

/**
 * @author 软柠柠吖
 * @date 2022/2/6
 */
public class Test01 {
	public static void main(String[] args) {
		// 读取文件
		CustomBufferedReader customBufferedReader1 = new CustomBufferedReader(new CustomFileReader());
		customBufferedReader1.reads(3);

		// 读取字符串
		CustomBufferedReader customBufferedReader2 = new CustomBufferedReader(new CustomStringReader());
		customBufferedReader2.reads(5);
	}

	@Test
	public void m1() {
		int count = 1;

		while (count < 5) {
			if (count == 3) {
				System.out.println("jjjj");
				continue;
			}
			System.out.println(count);
			count++;

			System.out.println("lemon");
		}
	}

	@Test
	public void m2() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			if (i == 3) {
				continue;
			}
			System.out.println("lemon");
		}
	}
}
