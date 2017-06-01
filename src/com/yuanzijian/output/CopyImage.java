package com.yuanzijian.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
需求： 拷贝一张图片。
*/
public class CopyImage {
	
	
	public static void main(String[] args) throws IOException {
		//找到目标文件
		File inFile = new File("F:\\美女\\1.jpg");
		File destFile = new File("E:\\1.jpg");
		//建立数据的输入输出通道
		FileInputStream fileInputStream = new  FileInputStream(inFile);
		FileOutputStream fileOutputStream = new FileOutputStream(destFile); //追加数据....
		
		//每新创建一个FileOutputStream的时候，默认情况下FileOutputStream 的指针是指向了文件的开始的位置。 每写出一次，指向都会出现相应移动。
		//建立缓冲数据，边读边写
		byte[] buf = new byte[1024]; 
		int length = 0 ; 
		while((length = fileInputStream.read(buf))!=-1){ //最后一次只剩下了824个字节
			fileOutputStream.write(buf,0,length); //写出很多次数据，所以就必须要追加。
		}
		//关闭资源 原则： 先开后关，后开先关。
		fileOutputStream.close();
		fileInputStream.close();
	}

}
