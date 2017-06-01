package com.yuanzijian.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
4.使用FileOutputStream的write方法写数据的时候，虽然接收的是一个int类型的数据，但是真正写出的只是一个字节的数据，只是
把低八位的二进制数据写出，其他二十四位数据全部丢弃。
 
 00000000-000000000-00000001-11111111   511
 

*/
public class Demo2 {
	
	
	public static void main(String[] args) throws IOException {
		readTest();
	}
	
	public static void readTest() throws IOException{
		//找到目标文件
		File file = new File("F:\\c.txt");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲输入读取文件数据
		byte[] buf = new byte[4];
		//读取文件数据
		int length = fileInputStream.read(buf);
		System.out.println("字节数组的内容："+ Arrays.toString(buf));
		//关闭资源
		fileInputStream.close();
		
	}
	
	
	
	

	public static void writeTest() throws FileNotFoundException, IOException {
		//找到目标文件
		File file = new File("F:\\c.txt");
		//建立数据的输出通道
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		//把数据写出
		fileOutputStream.write(511);
		//关闭资源
		fileOutputStream.close();
	}

}
