package com.yuanzijian.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 File类: 用于描述一个文件或者文件夹的。
 
 通过File对象我们可以读取文件或者文件夹的属性数据，如果我们需要读取文件的内容数据，那么我们需要使用IO流技术。
 
IO流（Input Output）

IO流解决问题： 解决设备与设备之间的数据传输问题。  内存--->硬盘   硬盘--->内存


IO流技术：


IO流分类：
	如果是按照数据的流向划分：
		
		输入流
		
		
		输出流
		
	如果按照处理的单位划分：
	
		字节流: 字节流读取得都是文件中二进制数据，读取到二进制数据不会经过任何的处理。
		
		
		字符流： 字符流读取的数据是以字符为单位的 。 字符流也是读取文件中的二进制数据，不过会把这些二进制数据转换成我们能 识别的字符。  
				字符流 = 字节流 + 解码
				
输入字节流：
--------| InputStream 所有输入字节流的基类  抽象类
------------| FileInputStream  读取文件数据的输入字节流 
			
使用FileInputStream读取文件数据的步骤：
	1. 找到目标文件
	2. 建立数据的输入通道。
	3. 读取文件中的数据。
	4. 关闭 资源.


				 
 */
public class Demo1 {
	
	public static void main(String[] args) throws IOException {
		readTest4();
	}
	
	//方式4：使用缓冲数组配合循环一起读取。28
	public static void readTest4() throws IOException{
		long startTime = System.currentTimeMillis();
		//找到目标文件
		File file = new File("F:\\美女\\1.jpg");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲数组配合循环读取文件的数据。
		int length = 0; //保存每次读取到的字节个数。
		byte[] buf = new byte[1024]; //存储读取到的数据    缓冲数组 的长度一般是1024的倍数，因为与计算机的处理单位。  理论上缓冲数组越大，效率越高
		
		while((length = fileInputStream.read(buf))!=-1){ // read方法如果读取到了文件的末尾，那么会返回-1表示。
			System.out.print(new String(buf,0,length));
		}
		
		//关闭资源
		fileInputStream.close();
		

		long endTime = System.currentTimeMillis();
		System.out.println("读取的时间是："+ (endTime-startTime)); //446
	}
	
	
	//方式3：使用缓冲 数组 读取。    缺点： 无法读取完整一个文件的数据。     12G
	public static void readTest3() throws IOException{
		//找到目标文件
		File file = new File("F:\\a.txt");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲字节数组，读取文件的数据。
		byte[] buf = new byte[1024];  //相当于超市里面的购物车。
		int length = fileInputStream.read(buf); // 如果使用read读取数据传入字节数组，那么数据是存储到字节数组中的，而这时候read方法的返回值是表示的是本次读取了几个字节数据到字节数组中。
		System.out.println("length:"+ length);
		
		//使用字节数组构建字符串
		String content = new String(buf,0,length);
		System.out.println("内容："+ content);
		//关闭资源
		fileInputStream.close();
	}
	
	
	
	
	
	//方式2 ： 使用循环读取文件的数据
	public static void readTest2() throws IOException{
		long startTime = System.currentTimeMillis();
		//找到目标文件
		File file = new File("F:\\美女\\1.jpg");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//读取文件的数据
		int content = 0; //声明该变量用于存储读取到的数据
		while((content = fileInputStream.read())!=-1){
			System.out.print((char)content);
		}
		//关闭资源
		fileInputStream.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("读取的时间是："+ (endTime-startTime)); //446
	}
	
	
	
	//读取的方式一缺陷： 无法读取完整一个文件 的数据.
	public static void readTest1() throws IOException{
		//1. 找到目标文件
		File file = new File("F:\\a.txt");
		//建立数据的输入通道。
		FileInputStream fileInputStream = new FileInputStream(file);
		//读取文件中的数据
		int content = fileInputStream.read(); // read() 读取一个字节的数据，把读取的数据返回。
		System.out.println("读到的内容是："+ (char)content);
		//关闭资源    实际上就是释放资源。 
		 fileInputStream.close();
	}
	
	
}
