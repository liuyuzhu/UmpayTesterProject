package com.umpaytester.spayrest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;

/**
 * @author yuzhuliu:
 * @version ����ʱ�䣺2017��9��12�� ����9:16:00 ��˵��
 */
public class GetProperties {

	public static String getPath()
			throws IOException {
		String envPath= GetProperties.class.getResource("/").getPath().substring(0, GetProperties.class.getResource("/").getPath().indexOf("WEB-INF"))+File.separator +"config"+File.separator;

		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		String key = "";
		fileInputStream = new FileInputStream(envPath+"env.properties");
		properties.load(fileInputStream);
		key = properties.getProperty("env");
		// System.out.println(name+":"+key);
		return GetProperties.class.getResource("/").getPath().substring(0, GetProperties.class.getResource("/").getPath().indexOf("WEB-INF"))+File.separator +key+File.separator;

	}

	public static String getParameters(String propertiesName, String name)
			throws IOException {

		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		String key = "";
		fileInputStream = new FileInputStream(GetProperties.getPath()+propertiesName);
		properties.load(fileInputStream);
		key = properties.getProperty(name);
		// System.out.println(name+":"+key);
		return key;
	}
	
	public static Long getTimer(String propertiesName, String name)
			throws IOException {

		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		String key ;
		fileInputStream = new FileInputStream(GetProperties.getPath()+propertiesName);
		properties.load(fileInputStream);
		key = properties.getProperty(name);
		// System.out.println(name+":"+key);
		long l = Long.parseLong(key);
		return l;
	}

	public static void main(String[] args) throws MessagingException,
			IOException {
		String propertiesName = "smail.properties";
		String myEmailSmtpHost = GetProperties.getParameters(propertiesName,
				"myEmailSmtpHost");
		System.out.println(myEmailSmtpHost);
	}
}
