package com.yuanzijian.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
���� ����һ��ͼƬ��
*/
public class CopyImage {
	
	
	public static void main(String[] args) throws IOException {
		//�ҵ�Ŀ���ļ�
		File inFile = new File("F:\\��Ů\\1.jpg");
		File destFile = new File("E:\\1.jpg");
		//�������ݵ��������ͨ��
		FileInputStream fileInputStream = new  FileInputStream(inFile);
		FileOutputStream fileOutputStream = new FileOutputStream(destFile); //׷������....
		
		//ÿ�´���һ��FileOutputStream��ʱ��Ĭ�������FileOutputStream ��ָ����ָ�����ļ��Ŀ�ʼ��λ�á� ÿд��һ�Σ�ָ�򶼻������Ӧ�ƶ���
		//�����������ݣ��߶���д
		byte[] buf = new byte[1024]; 
		int length = 0 ; 
		while((length = fileInputStream.read(buf))!=-1){ //���һ��ֻʣ����824���ֽ�
			fileOutputStream.write(buf,0,length); //д���ܶ�����ݣ����Ծͱ���Ҫ׷�ӡ�
		}
		//�ر���Դ ԭ�� �ȿ���أ����ȹء�
		fileOutputStream.close();
		fileInputStream.close();
	}

}
