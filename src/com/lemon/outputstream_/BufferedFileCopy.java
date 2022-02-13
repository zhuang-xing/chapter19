package com.lemon.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 软柠柠吖
 * @date 2022/2/7
 */
public class BufferedFileCopy {

	@Test
	public void bufferedFileCopy() {
		String srcFilePath = "D:\\ok.txt";
		String destFilePath = "D:\\ok2.txt";

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// 创建BufferedInputStream对象 和 BufferedOutputStream对象
			// 因为 FileInputStream 是 InputStream 子类
			bis = new BufferedInputStream(new FileInputStream(srcFilePath));
			bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
			// 创建字节缓冲数组
			byte[] buff = new byte[1024];
			int readLen = 0;
			// 循环的读取文件，并写入到 destFilePath
			// 当返回 -1 时，就表示文件读取完毕
			while ((readLen = bis.read(buff)) != -1) {
				bos.write(buff, 0, readLen);
			}
			System.out.println("拷贝Ok~");
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流，关闭外层的处理流即可，底层会去关闭节点流
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
