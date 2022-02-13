package com.lemon.writer_;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/6
 */
public class BufferWriter01 {

	@Test
	public void writeFile() {
		String filePath = "D:\\ok.txt";
		BufferedWriter bufferedWriter = null;
		try {
			// 创建BufferedWriter对象(java.io)
			// 说明：
			// 1.new FileWriter(filePath, true): 表示以追加的方式写入
			// 2.new FileWriter(filePath): 表示以覆盖的方式写入
			bufferedWriter = new BufferedWriter(new FileWriter(filePath));// 覆盖的方式
			// bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));// 追加的方式
			bufferedWriter.write("软柠柠吖1~~");
			// 插入一个和系统相关的换行符
			bufferedWriter.newLine();
			bufferedWriter.write("软柠柠吖2~~");
			bufferedWriter.newLine();
			bufferedWriter.write("软柠柠吖3~~");
			bufferedWriter.newLine();

			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 说明：关闭外层流即可，传入的 new FileWriter(filePath), 会在底层关闭
			/*  bufferedWriter.close();源码
				public void close() throws IOException {
			        synchronized (lock) {
			            if (out == null) {
			                return;
			            }
			            // 注意区分 try 与 try()
			            // try (Writer w = out) try块退出时，会自动调用w.close(); 即out.close();
			            // 自动关闭资源
			            try (Writer w = out) {
			                flushBuffer();
			            } finally {
			                out = null;
			                cb = null;
			            }
			        }
			    }
			 */
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
