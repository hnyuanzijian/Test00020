package com.yuanzijian.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 ����ֽ�����
 
 --------| OutputStream ����������ֽ��� �ĸ��ࡣ  ������
 -----------| FileOutStream ���ļ�������ݵ�����ֽ�����
 
FileOutputStream���ʹ���أ�
	1. �ҵ�Ŀ���ļ�
	2. �������ݵ����ͨ����
	3. ������ת�����ֽ�����д����
	4. �ر���Դ

FileOutputStreamҪע���ϸ�ڣ�
	1. ʹ��FileOutputStream ��ʱ�����Ŀ���ļ������ڣ���ô���Զ�����Ŀ���ļ����� 
	2. ʹ��FileOutputStreamд���ݵ�ʱ�����Ŀ���ļ��Ѿ����ڣ���ô�������Ŀ���ļ��е����ݣ�Ȼ����д�����ݡ�
	3.ʹ��FileOutputStreamд���ݵ�ʱ��, ���Ŀ���ļ��Ѿ����ڣ���Ҫ��ԭ�����ݻ�����׷�����ݵ�ʱ��Ӧ��ʹ��new FileOutputStream(file,true)���캯�����ڶ�����Ϊtrue��
	4.ʹ��FileOutputStream��write����д���ݵ�ʱ����Ȼ���յ���һ��int���͵����ݣ���������д����ֻ��һ���ֽڵ����ݣ�ֻ��
	�ѵͰ�λ�Ķ���������д����������ʮ��λ����ȫ��������
	 
	 00000000-000000000-00000001-11111111   511
	 
	 
	 11111111---> -1 


	 
 */


public class Demo1 {
	
	public static void main(String[] args) throws IOException {
		writeTest3();
	}
	
	
	//ʹ���ֽ����������д����
	public static void writeTest3() throws IOException{
		//�ҵ�Ŀ���ļ�
		File file = new File("F:\\b.txt");
		//�����������ͨ��
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		//������д����
		String data = "abc";
		byte[] buf = data.getBytes();
		fileOutputStream.write(buf, 0, 3); // 0 ���ֽ������ָ������ֵ��ʼд�� 2��д�������ֽڡ�

		//�ر���Դ
		fileOutputStream.close();
	}
		
	
	
	//ʹ���ֽ����������д����
	public static void writeTest2() throws IOException{
		//�ҵ�Ŀ���ļ�
		File file = new File("F:\\b.txt");
		//�����������ͨ��
		FileOutputStream fileOutputStream = new FileOutputStream(file,true);
		//������д����
		String data = "\r\nhello world";
		fileOutputStream.write(data.getBytes());
		//�ر���Դ
		fileOutputStream.close();
	}
	
	
	
	//ÿ��ֻ��дһ���ֽڵ����ݳ�ȥ��
	public static void writeTest1() throws IOException{
		//�ҵ�Ŀ���ļ�
		File file = new File("F:\\b.txt");
		//�������ݵ����ͨ��
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		//������д��
		fileOutputStream.write('h');
		fileOutputStream.write('e');
		fileOutputStream.write('l');
		fileOutputStream.write('l');
		fileOutputStream.write('o');
		//�ر���Դ
		fileOutputStream.close();
		
		
	}
	
	
}
