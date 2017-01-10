package com.juxinli.kuaip.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.seleniumhq.jetty7.util.log.Log;

public class FileDeal {
	public static void main(String[] args) {
		List<String> list = readFile("E:\1.txt");
		for (String a : list) {
			System.out.println(a);
		}
	}

	@SuppressWarnings("deprecation")
	public static List<String> readFile(String filePath) {
		List<String> list = new ArrayList<String>();
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println(lineTxt);
					list.add(lineTxt);
				}
				read.close();
			} else {
				//Log.info("��ȡ�ļ���" + filePath + "ʧ�ܣ�ԭ���Ҳ���ָ�����ļ���");
			}
		} catch (Exception e) {
			//Log.info("��ȡ�ļ���" + filePath + "���ݳ���" + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("deprecation")
	public static boolean writeFile(List<String> data, String fileName) {
		try {
			FileWriter writ = new FileWriter("logs\\"+fileName, true);
			for (String s : data) {
				writ.write(s+"\n");
			}
			writ.close();
			//Log.info("�ļ�" + fileName + "д��ɹ���");
			return true;
		} catch (Exception e) {
			//Log.info("�ļ���" + fileName + "д��ʧ�ܣ�" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
