package com.lemon.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 软柠柠吖
 * @date 2022/2/9
 */
// 演示ObjectOutputStream 的使用，完成数据序列化
public class ObjectOutputStream_ {

	@Test
	public void m1() {
		// 序列化后，保存的文件格式，不是纯文本，而是按照它的格式来保存的
		String filePath = "D:\\data.dat";
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
			// 序列化数据到 D:\data.dat
			// objectOutputStream.write(100);// 只保存了值100，没有保存数据类型
			// int -> Integer (实现了 Serializable)
			objectOutputStream.writeInt(100);
			// boolean -> Boolean (实现了 Serializable)
			objectOutputStream.writeBoolean(true);
			// char -> Character (实现了 Serializable)
			objectOutputStream.writeChar('a');
			// double -> Double (实现了 Serializable)
			objectOutputStream.writeDouble(9.6);
			// String (实现了 Serializable)
			objectOutputStream.writeUTF("软柠柠吖");
			// 保存一个dog对象
			objectOutputStream.writeObject(new Dog("旺财", 5, "黑色", "中国"));
			// objectOutputStream.writeObject(dog2);

			System.out.println("数据保存完毕(序列化机制)~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
