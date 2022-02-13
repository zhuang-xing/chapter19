package com.lemon;


/**
 * @author 软柠柠吖
 * @date 2022/2/6
 */
// 处理流/包装流
public class CustomBufferedReader extends AbstractReader {

	// 属性是AbstractReader 类型
	private AbstractReader in;

	// 接收AbstractReader 子类对象
	public CustomBufferedReader(AbstractReader in) {
		this.in = in;
	}

	@Override
	public void read() {
		// 动态绑定，绑定运行类型(由构造器传入的)
		in.read();
	}
	// 让方法更加灵活，多次读取文件，或者加缓冲char[]...
	public void reads(int num) {
		for (int i = 0; i < num; i++) {
			// 动态绑定，绑定运行类型(由构造器传入的)
			in.read();
		}
	}
}
