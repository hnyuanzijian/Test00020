package com.yuanzijian.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 我们清楚读取文件数据使用缓冲数组读取效率更高，sun也知道使用缓冲数组读取效率更高，那么
 这时候sun给我们提供了一个------缓冲输入字节流对象,让我们可以更高效率读取文件。
 
 
输入字节流体系： 
----| InputStream  输入字节流的基类。 抽象
----------| FileInputStream 读取文件数据的输入字节流
----------| BufferedInputStream 缓冲输入字节流    缓冲输入字节流的出现主要是为了提高读取文件数据的效率。    
其实该类内部只不过是维护了一个8kb的字节数组而已。 

注意： 凡是缓冲流都不具备读写文件的能力。

使用BufferedInputStream的步骤	:
	1. 找到目标文件。
	2. 建立数据 的输入通道
	3. 建立缓冲 输入字节流流
	4. 关闭资源
 
 
 */


public class Demo1 {
	
	public static void main(String[] args) throws IOException {
		readTest2();
	}
	
	public static void readTest2() throws IOException{
		//找到目标文件
		File file = new File("F:\\a.txt");
		
		FileInputStream fileInputStream= new FileInputStream(file);
		BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);
		bufferedInputStream.read();
		
		
		
		FileOutputStream fileOutputStream= new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(fileOutputStream);
		fileOutputStream.write(null);
		
		//读取文件数据
		int content = 0 ;
		//疑问二：BufferedInputStream出现 的目的是了提高读取文件的效率，但是BufferedInputStream的read方法每次读取一个字节的数据
		//而FileInputStreram每次也是读取一个字节的数据，那么BufferedInputStream效率高从何而来？
		while((content = fileInputStream.read())!=-1){
			System.out.print((char)content);
		}
		
		//关闭资源
		bufferedInputStream.close();//调用BufferedInputStream的close方法实际上关闭的是FileinputStream.
	}

	
	
	//读取文件的时候我们都是使用缓冲数组读取。效率会更加高
	public static void readTest() throws IOException{
		File file = new File("F:\\a.txt");
		//建立数组通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲数组读取数据
		byte[] buf = new byte[1024*8];
		int length = 0; 
		while((length = fileInputStream.read(buf))!=-1){
			System.out.print(new String(buf,0,length));
		}
		//关闭资源
		fileInputStream.close();
	}
	
	
}
