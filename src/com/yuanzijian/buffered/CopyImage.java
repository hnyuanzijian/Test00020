package com.yuanzijian.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
��ϰ�� ʹ�û�����������ֽ�������һ��ͼƬ��

*/
public class CopyImage {

	public static void main(String[] args) throws IOException {
		//�ҵ�Ŀ���ļ�
		File  inFile = new File("F:\\��Ů\\1.jpg");
		File outFile = new File("E:\\1.jpg");
		//���������������ͨ��
		FileInputStream fileInputStream = new FileInputStream(inFile);
		FileOutputStream fileOutputStream = new FileOutputStream(outFile);
		//�����������������
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		//�߶���д
		int content = 0; 
		// int length = bufferedInputStream.read(buf);   ��������˻������飬�����Ǵ洢�����������У�����ֵ�Ǵ洢�����������е��ֽڸ�����
		while((content = bufferedInputStream.read())!=-1){ // ���ʹ��read����û�д��뻺�����飬��ô����ֵ�Ƕ�ȡ�������ݡ�
			bufferedOutputStream.write(content);
//			bufferedOutputStream.flush();
		}
		//�ر���Դ
		bufferedInputStream.close();
		bufferedOutputStream.close();
		
		
		
	}
	
}
