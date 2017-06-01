package com.yuanzijian.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
练习： 使用缓冲输入输出字节流拷贝一个图片。

*/
public class CopyImage {

	public static void main(String[] args) throws IOException {
		//找到目标文件
		File  inFile = new File("F:\\美女\\1.jpg");
		File outFile = new File("E:\\1.jpg");
		//建立数据输入输出通道
		FileInputStream fileInputStream = new FileInputStream(inFile);
		FileOutputStream fileOutputStream = new FileOutputStream(outFile);
		//建立缓冲输入输出流
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		//边读边写
		int content = 0; 
		// int length = bufferedInputStream.read(buf);   如果传入了缓冲数组，内容是存储到缓冲数组中，返回值是存储到缓冲数组中的字节个数。
		while((content = bufferedInputStream.read())!=-1){ // 如果使用read方法没有传入缓冲数组，那么返回值是读取到的内容。
			bufferedOutputStream.write(content);
//			bufferedOutputStream.flush();
		}
		//关闭资源
		bufferedInputStream.close();
		bufferedOutputStream.close();
		
		
		
	}
	
}
