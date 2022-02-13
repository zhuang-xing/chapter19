package com.lemon;

/**
 * @author 软柠柠吖
 * @date 2022/2/6
 */
// 节点流, 因为CustomStringReader 与具体的数据源相关, 只能读取字符串，功能较弱
public class CustomStringReader extends AbstractReader {

	@Override
	public void read() {
		System.out.println("读取字符串~~");
	}
}
