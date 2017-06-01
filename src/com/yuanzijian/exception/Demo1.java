package com.yuanzijian.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.management.RuntimeErrorException;

/*
 IO异常 的处理

 */
public class Demo1 {

	public static void main(String[] args) {
	//	readTest();
		
		copyImage();
	}

	// 拷贝图片
	public static void copyImage() {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			// 找到目标文件
			File inFile = new File("F:\\美女\\1.jpg");
			File outFile = new File("E:\\1.jpg");
			// 建立输入输出通道
			fileInputStream = new FileInputStream(inFile);
			fileOutputStream = new FileOutputStream(outFile);
			// 建立缓冲数组，边读边写
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = fileInputStream.read(buf)) != -1) {
				fileOutputStream.write(buf, 0, length);
			}
		} catch (IOException e) {
			System.out.println("拷贝图片出错...");
			throw new RuntimeException(e);
		} finally {
			// 关闭资源
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
					System.out.println("关闭输出流对象成功...");
				}
			} catch (IOException e) {
				System.out.println("关闭输出流资源失败...");
				throw new RuntimeException(e);
			} finally {
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
						System.out.println("关闭输入流对象成功...");
					} catch (IOException e) {
						System.out.println("关闭输入流对象失败...");
						throw new RuntimeException(e);
					}
				}

			}
		}
	}

	public static void readTest() {
		FileInputStream fileInputStream = null;
		try {
			// 找到目标文件
			File file = new File("F:\\aaaaa.txt");
			// 建立数据输入通道
			fileInputStream = new FileInputStream(file);
			// 建立缓冲数组读取数据
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = fileInputStream.read(buf)) != -1) {
				System.out.print(new String(buf, 0, length));
			}
		} catch (IOException e) {
			/*
			 * //处理的代码... 首先你要阻止后面的代码执行,而且要需要通知调用者这里出错了... throw new
			 * RuntimeException(e);
			 * //把IOException传递给RuntimeException包装一层，然后再抛出，这样子做的目的是
			 * 为了让调用者使用变得更加灵活。
			 */
			System.out.println("读取文件资源出错....");
			throw new RuntimeException(e);
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
					System.out.println("关闭资源成功...");
				}
			} catch (IOException e) {
				System.out.println("关闭资源失败...");
				throw new RuntimeException(e);
			}
		}
	}

}
