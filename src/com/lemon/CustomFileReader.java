package com.lemon;

/**
 * @author 软柠柠吖
 * @date 2022/2/6
 */
// 节点流, 因为CustomFileReader 与具体的数据源相关, 只能读取文件，功能较弱
public class CustomFileReader extends AbstractReader {// 节点流

	@Override
	public void read() {
		System.out.println("读取文件~");
	}
}
