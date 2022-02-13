package com.lemon.outputstream_;

import java.io.Serializable;

/**
 * @author 软柠柠吖
 * @date 2022/2/11
 */
// 如果需要序列化某个类的对象，实现 Serializable 接口
public class Dog implements Serializable {
	String name;
	int age;
	transient String color;
	static String nation;
	Master master = new Master();

	public Dog(String name, int age, String color, String nation) {
		this.name = name;
		this.age = age;
		this.color = color;
		Dog.nation = nation;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				", color='" + color + '\'' +
				'}' + nation + " " + master;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
