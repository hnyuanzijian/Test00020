package com.yuanzijian.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 ���������ȡ�ļ�����ʹ�û��������ȡЧ�ʸ��ߣ�sunҲ֪��ʹ�û��������ȡЧ�ʸ��ߣ���ô
 ��ʱ��sun�������ṩ��һ��------���������ֽ�������,�����ǿ��Ը���Ч�ʶ�ȡ�ļ���
 
 
�����ֽ�����ϵ�� 
----| InputStream  �����ֽ����Ļ��ࡣ ����
----------| FileInputStream ��ȡ�ļ����ݵ������ֽ���
----------| BufferedInputStream ���������ֽ���    ���������ֽ����ĳ�����Ҫ��Ϊ����߶�ȡ�ļ����ݵ�Ч�ʡ�    
��ʵ�����ڲ�ֻ������ά����һ��8kb���ֽ�������ѡ� 

ע�⣺ ���ǻ����������߱���д�ļ���������

ʹ��BufferedInputStream�Ĳ���	:
	1. �ҵ�Ŀ���ļ���
	2. �������� ������ͨ��
	3. �������� �����ֽ�����
	4. �ر���Դ
 
 
 */


public class Demo1 {
	
	public static void main(String[] args) throws IOException {
		readTest2();
	}
	
	public static void readTest2() throws IOException{
		//�ҵ�Ŀ���ļ�
		File file = new File("F:\\a.txt");
		
		FileInputStream fileInputStream= new FileInputStream(file);
		BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);
		bufferedInputStream.read();
		
		
		
		FileOutputStream fileOutputStream= new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(fileOutputStream);
		fileOutputStream.write(null);
		
		//��ȡ�ļ�����
		int content = 0 ;
		//���ʶ���BufferedInputStream���� ��Ŀ��������߶�ȡ�ļ���Ч�ʣ�����BufferedInputStream��read����ÿ�ζ�ȡһ���ֽڵ�����
		//��FileInputStreramÿ��Ҳ�Ƕ�ȡһ���ֽڵ����ݣ���ôBufferedInputStreamЧ�ʸߴӺζ�����
		while((content = fileInputStream.read())!=-1){
			System.out.print((char)content);
		}
		
		//�ر���Դ
		bufferedInputStream.close();//����BufferedInputStream��close����ʵ���Ϲرյ���FileinputStream.
	}

	
	
	//��ȡ�ļ���ʱ�����Ƕ���ʹ�û��������ȡ��Ч�ʻ���Ӹ�
	public static void readTest() throws IOException{
		File file = new File("F:\\a.txt");
		//��������ͨ��
		FileInputStream fileInputStream = new FileInputStream(file);
		//�������������ȡ����
		byte[] buf = new byte[1024*8];
		int length = 0; 
		while((length = fileInputStream.read(buf))!=-1){
			System.out.print(new String(buf,0,length));
		}
		//�ر���Դ
		fileInputStream.close();
	}
	
	
}
