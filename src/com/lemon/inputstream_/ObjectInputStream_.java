package com.lemon.inputstream_;

import com.lemon.outputstream_.Dog;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 软柠柠吖
 * @date 2022/2/9
 */
public class ObjectInputStream_ {

	@Test
	public void m2() {
		// 指定反序列化文件
		String filePath = "D:\\data.dat";
		ObjectInputStream objectInputStream = null;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
			// 读取
			// 1.读取(反序列化)的顺序 需要和你 保存数据(序列化)的顺序一致
			// 否则会出现异常
			System.out.println(objectInputStream.readInt());
			System.out.println(objectInputStream.readBoolean());
			System.out.println(objectInputStream.readChar());
			System.out.println(objectInputStream.readDouble());
			System.out.println(objectInputStream.readUTF());
			Object dog = objectInputStream.readObject();
			System.out.println("运行类型=" + dog.getClass());
			System.out.println("dog信息=" + dog);// 底层 Object -> Dog

			// 这里是特别重要的细节
			// 1.如果我们希望调用Dog的方法，需要向下转型
			// 2.需要我们将 Dog类的定义，放到能够引用的位置
			Dog dog2 = (Dog) dog;
			System.out.println(dog2.getName());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 关闭流，关闭外层流即可，底层会自动关闭 FileInputStream 流
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
