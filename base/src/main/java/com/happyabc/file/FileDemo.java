package com.happyabc.file;

import org.junit.Test;

import java.io.File;

public class FileDemo {
    @Test
    public void file() {
        File file = new File("");
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //获取
        System.out.println(file.getAbsoluteFile());
    }
}
