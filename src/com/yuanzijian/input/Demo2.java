package com.yuanzijian.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
 ����1�� ��ȡ��һ���ļ������ݵ�ʱ���Ҳ��ر���Դ��ʲôӰ��?
 �𰸣� ��Դ�ļ�һ�� ʹ�����Ӧ�������ͷţ����������ĳ����޷��Ը���Դ�ļ��������� �Ĳ�����
 
 
 
 
 
 */
import java.util.Arrays;


public class Demo2 {

	public static void main(String[] args) throws IOException {
		//�ҵ�Ŀ���ļ�
		File file = new File("F:\\day18-day21.IO.doc");
		//�������ݵ�����ͨ��
		FileInputStream fileInputStream = new FileInputStream(file);
		//���������ֽ������ȡ�ļ�
		byte[] buf = new byte[8];
		int length = 0 ;
		
		while((length = fileInputStream.read(buf))!=-1){
			System.out.print(new String(buf));  // aaaa   bbba  bbb' '
//		System.out.println(Arrays.toString(buf));
		}
		//�ͷ��ļ���Դ
		fileInputStream.close();
		
	
	}
	
}
