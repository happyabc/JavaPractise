package com.happyabc.base.genericity;

import java.io.*;

/**
 * Java追加文件内容的三种方法
 */
public class FileTest {
    /**
     * 描述：追加内容到文件末尾
     *
     * @author Roger Federer
     */
    public static void main(String[] args) throws IOException {
        File fileOrFilename = new File("d://text.txt");
        // 方法 一
        //追加文件：使用FileOutputStream，在构造FileOutputStream时，把第二个参数设为true
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOrFilename, true)));
        out.write("first 第一种方式 \r\n");
        out.close();
        // 方法 二
        //追加文件：使用FileWriter
        // 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
        // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
        FileWriter fw = new FileWriter(fileOrFilename, true);
        fw.write("second第二种方式\r\n");
        fw.close();
        //BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
        //方法 三
        //追加文件：使用RandomAccessFile
        // 打开一个随机访问文件流，按读写方式
        RandomAccessFile randomFile = new RandomAccessFile(fileOrFilename, "rw");
        // 文件长度，字节数
        long fileLength = randomFile.length();
        // 将文件指针移到文件尾
        randomFile.seek(fileLength);
        randomFile.writeBytes("third 追加的内容\r\n");
        randomFile.close();
    }

    /**
     * 在文件前面追加文件内容
     *
     * @return
     */
    public static void fileAppender(String fileName, String contents)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        // 一行一行的读
        StringBuilder sb = new StringBuilder();
        sb.append(contents);
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append("\r\n");
        }
        reader.close();
        //写回去
        RandomAccessFile write = new RandomAccessFile(fileName, "rw");
        write.writeBytes(sb.toString()); //<---会产生中文乱码
        write.close();
    }

}
