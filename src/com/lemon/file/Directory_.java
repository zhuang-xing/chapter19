package com.lemon.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 软柠柠吖
 * @date 2022/2/3
 */
public class Directory_ {
    public static void main(String[] args) {

    }

    // 判断 D:\\lemon.txt 是否存在，存在就删除，否则提示不存在
    @Test
    public void m1() {
        // 创建file对象
        File file = new File("D:\\lemon.txt");
        // 判断file对象是否在磁盘中存在, 而非判断是否在java程序(内存)中存在。
        // 如果判断是否在java程序(内存)中存在，则结果一定为true，
        // 因为一开始就在内存中创建了一个file对象，毫无意义，所以是判断是否在磁盘中存在
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            System.out.println(file.getName() + " 该文件不存在");
        }
    }

    // 判断 D:\\demo02 是否存在，存在就删除，否则提示不存在
    // 这里我们需要体会到，在java编程中，目录(文件夹)也被当做文件
    @Test
    public void m2() {
        // 创建file对象
        File file = new File("D:\\demo02");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            System.out.println(file.getName() + " 该文件夹(目录)不存在");
            file.mkdirs();

        }
    }

    // 判断 D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {
        // 创建file对象
        File file = new File("D:\\demo\\a\\b\\c");
        if (file.exists()) {
            System.out.println(file.getName() + " 该目录已存在");
            if (file.delete()) {
                System.out.println("删除Ok");
            } else {
                System.out.println("删除失败");
            }
        } else {
            // 创建一级目录使用: mkdir()
            // 创建多级目录使用: mkdirs()
            if (file.mkdirs()) {
                System.out.println("目录创建成功");
            } else {
                System.out.println("目录创建失败");
            }
        }
    }
}
