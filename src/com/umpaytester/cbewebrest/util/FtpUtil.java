package com.umpaytester.cbewebrest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.umpaytester.utils.log.Logger;

public class FtpUtil {
	static Logger log=Logger.getLogger(FtpUtil.class);  
 private static FTPClient ftpClient = new FTPClient();
 private static String encoding = System.getProperty("file.encoding");
 /**
  * Description: 向FTP服务器上传文件
  * 
  * @Version1.0
  * @param url
  *   FTP服务器hostname
  * @param portO
  *   FTP服务器端口
  * @param username
  *   FTP登录账号
  * @param password
  *   FTP登录密码
  * @param path
  *   FTP服务器保存目录,如果是根目录则为“/”
  * @param filename
  *   上传到FTP服务器上的文件名
  * @param input
  *   本地文件输入流
  * @return 成功返回true，否则返回false
  */
 public static boolean uploadFile(String ip,  String path, String filename, InputStream input) {
	 log.info("执行uploadFile方法，请求ip:"+ip+",上传至"+path+",文件名为:"+filename);
	 
  boolean result = false;
 
  try {
   int reply;
   // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
   ftpClient.connect(ip);
   // ftp.connect(url, port);// 连接FTP服务器
   // 登录
   ftpClient.login("mpsp", "mpsp4321");
   ftpClient.setControlEncoding(encoding);
   // 检验是否连接成功
   reply = ftpClient.getReplyCode();
   if (!FTPReply.isPositiveCompletion(reply)) {
	   log.info("连接失败");
    ftpClient.disconnect();
    return result;
   }
 
   // 转移工作目录至指定目录下
   boolean change = ftpClient.changeWorkingDirectory(path);
   ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
   if (change) {
    result = ftpClient.storeFile(new String(filename.getBytes(encoding),"utf-8"), input);
    if (result) {
    	log.info("上传成功!");
    }
   }
   input.close();
   ftpClient.logout();
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   if (ftpClient.isConnected()) {
    try {
     ftpClient.disconnect();
    } catch (IOException ioe) {
    }
   }
  }
  return result;
 }
 
 /**
  * 将本地文件上传到FTP服务器上
  * 
  */
 public void testUpLoadFromDisk() {
  try {
   FileInputStream in = new FileInputStream(new File("D:\\cbeweb_resttest\\RESTTEST\\src\\com\\ump\\test\\utils\\test.txt"));
   boolean flag = uploadFile("10.10.178.36",  "/usr/mpsp/", "test.txt", in);
  
   log.info(""+flag);
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
 }
 
 
 /**
  * Description: 从FTP服务器下载文件
  * 
  * @Version1.0
  * @param url
  *   FTP服务器hostname
  * @param port
  *   FTP服务器端口
  * @param username
  *   FTP登录账号
  * @param password
  *   FTP登录密码
  * @param remotePath
  *   FTP服务器上的相对路径
  * @param fileName
  *   要下载的文件名
  * @param localPath
  *   下载后保存到本地的路径
  * @return
  */
 public static boolean downFile(String url,  String remotePath, String fileName,
   String localPath) {
  boolean result = false;
  try {
   int reply;
   ftpClient.setControlEncoding(encoding);
    
   /*
    * 为了上传和下载中文文件，有些地方建议使用以下两句代替
    * new String(remotePath.getBytes(encoding),"iso-8859-1")转码。
    * 经过测试，通不过。
    */
//   FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
//   conf.setServerLanguageCode("zh");
 
   ftpClient.connect(url, 21);
   // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
   ftpClient.login("mpsp", "mpsp4321");// 登录
   // 设置文件传输类型为二进制
   ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
   // 获取ftp登录应答代码
   reply = ftpClient.getReplyCode();
   // 验证是否登陆成功
   if (!FTPReply.isPositiveCompletion(reply)) {
    ftpClient.disconnect();
    log.info("FTP server refused connection.");
    return result;
   }
   // 转移到FTP服务器目录至指定的目录下
   ftpClient.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
   // 获取文件列表
   FTPFile[] fs = ftpClient.listFiles();
   for (FTPFile ff : fs) {
    if (ff.getName().equals(fileName)) {
     File localFile = new File(localPath + "/" + ff.getName());
     OutputStream is = new FileOutputStream(localFile);
     ftpClient.retrieveFile(ff.getName(), is);
     is.close();
    }
   }
 
   ftpClient.logout();
   result = true;
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   if (ftpClient.isConnected()) {
    try {
     ftpClient.disconnect();
    } catch (IOException ioe) {
    }
   }
  }
  return result;
 }
 
 /**
  * 将FTP服务器上文件下载到本地
  * 
  */
 public void testDownFile() {
  try {
   boolean flag = downFile("127.0.0.1",  "/", "哈哈.txt", "D:/");
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
  
 public static void main(String[] args) {
	 FtpUtil fa = new FtpUtil();
  fa.testUpLoadFromDisk();
 }
}
 