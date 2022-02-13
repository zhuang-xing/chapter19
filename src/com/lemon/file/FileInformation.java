package com.lemon.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/2
 */
public class FileInformation {
    // 获取文件信息
    @Test
    public void fileInfo() {
        // 先在内存中创建文件对象
        File file = new File("D:\\lemon.txt");

        try {
            // 在磁盘中创建真正的文件
            file.createNewFile();
            System.out.println("文件创建🆗~");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取文件名称
        System.out.println("文件名=" + file.getName());// lemon.txt
        // 获取绝对路径
        System.out.println("绝对路径=" + file.getAbsolutePath());// D:\lemon.txt
        // 获取父级目录
        System.out.println("文件父级目录=" + file.getParent());// D:\\
        // 获取文件大小，单位: 字节
        System.out.println("文件大小(字节)=" + file.length());// 0
        // 文件是否存在
        System.out.println("文件是否存在=" + file.exists());// T
        // 是不是一个文件
        System.out.println("是不是一个文件=" + file.isFile());// T
        // 是不是一个目录
        System.out.println("是不是一个目录=" + file.isDirectory());// F
    }
}
