package com.lemon.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 软柠柠吖
 * @date 2022/2/2
 * 演示创建文件 3种方式
 */
public class FileCreate {
    // 方式1：new File(String pathName) // 根据路径构建一个File对象
    @Test
    public void fileCreate01() {
        String filePath = "D:\\lemon.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 方式2：new File(File parent, String child) // 根据父目录文件+子路径创建
    // D:\\lemon2.txt
    @Test
    public void fileCreate02() {
        File parentFile = new File("D:\\");
        String childName = "lemon2.txt";
        // 这里的file对象，在java程序中，只是一个对象，只是在内存中创建了文件对象 (内存)
        // 只有执行了 createNewFile 方法，才会真正的，在磁盘创建该文件 (磁盘)
        File file = new File(parentFile, childName);
        try {
            // 真正在磁盘中创建一个文件
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方式3：new File(String parent, String child) // 根据父目录+子路径创建
    @Test
    public void fileCreate03() {
        // String parentPath = "D:/";
        String parentPath = "D:\\";// 推荐
        String childPath = "lemon3.txt";
        File file = new File(parentPath, childPath);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
