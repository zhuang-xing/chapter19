package com.lemon.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author 软柠柠吖
 * @date 2022/2/12
 */
public class HomeWork03 {

	@Test
	public void useProperties() {
		// 创建 Properties 对象
		Properties properties = new Properties();
		// 设置信息
		properties.setProperty("name", "tom");
		properties.setProperty("age", "5");
		properties.setProperty("color", "red");
		// 创建配置文件
		String dogPropertiesPath = "src\\dog.properties";
		try {
			properties.store(new FileOutputStream(dogPropertiesPath), null);
			System.out.println("配置文件创建OK~");
		} catch (IOException e) {
			e.printStackTrace();
		}
//********************************************************************************
		// 加载配置文件
		properties = new Properties();
		try {
			properties.load(new FileReader(dogPropertiesPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建Dog对象
		Dog dog = new Dog(properties.getProperty("name")
				, Integer.parseInt(properties.getProperty("age"))
				, properties.getProperty("color"));
		System.out.println(dog);
//*******************************************************************************
		// 将dog对象 序列化输出到文件
		String filePath = "D:\\dog.dat";
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
			objectOutputStream.writeObject(dog);

			objectOutputStream.flush();
			System.out.println("序列化写入OK~");
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
//************************************************************************
		// 将文件中的dog对象 反序列化输入到控制台
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
			Object obj = objectInputStream.readObject();
			System.out.println(obj.getClass());
			System.out.println(obj);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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

class Dog implements Serializable {
	private String name;
	private int age;
	private String color;

	public Dog(String name, int age, String color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				", color='" + color + '\'' +
				'}';
	}
}
