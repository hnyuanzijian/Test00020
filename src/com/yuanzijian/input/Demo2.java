package com.yuanzijian.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
 问题1： 读取完一个文件的数据的时候，我不关闭资源有什么影响?
 答案： 资源文件一旦 使用完毕应该马上释放，否则其他的程序无法对该资源文件进行其他 的操作。
 
 
 
 
 
 */
import java.util.Arrays;


public class Demo2 {

	public static void main(String[] args) throws IOException {
		//找到目标文件
		File file = new File("F:\\day18-day21.IO.doc");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲字节数组读取文件
		byte[] buf = new byte[8];
		int length = 0 ;
		
		while((length = fileInputStream.read(buf))!=-1){
			System.out.print(new String(buf));  // aaaa   bbba  bbb' '
//		System.out.println(Arrays.toString(buf));
		}
		//释放文件资源
		fileInputStream.close();
		
	
	}
	
}
