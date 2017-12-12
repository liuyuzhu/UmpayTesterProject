package com.umpaytester.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.umpaytester.utils.log.Logger;

/*作者：刘玉柱
 *日期：2017年11月10日
 *时间：上午11:33:08
 *该类的功能:
**/

public class PropsUtil {
    static Logger log=Logger.getLogger(PropsUtil.class); 
    public static String envFilePath=null;
    public static String env=null;
    public static String getEnv() {
    	PropsUtil pu = new PropsUtil();
    	 return pu.getPropsValue("env.properties","env");
    }
    
    
	/**
     * 构造函数
     * 找到数据源，并用这个数据源创建连接
     */
    public PropsUtil() {

    }
    
    
    public static void updateToken(String filename,String token) throws IOException {
        PropsUtil pu = new PropsUtil();
//        Properties props = pu.getENVProperties(filename);
//        props.setProperty("token", token);
        
        
        Properties props=pu.getENVProperties(filename);
        String path = pu.envFilePath.replaceAll("build/classes", "src")+filename;
        props.load(new FileInputStream(path));
        OutputStream fos = new FileOutputStream(path);  
        System.out.println(path);
        props.store(fos, "Update value");
        props.setProperty("token", token);
        fos.close();
      

   }
   
    
    /**  
     * 更新（或插入）一对properties信息(主键及其键值)  
     * 如果该主键已经存在，更新该主键的值；  
     * 如果该主键不存在，则插件一对键值。  
     * @param keyname 键名  
     * @param keyvalue 键值  
     */   
     public static void writeProps(String fileName ,String keyname,String keyvalue) {          
         try {   
        	 PropsUtil pu =new PropsUtil();
        	 Properties props = pu.getENVProperties(fileName);

             // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
             // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        	 log.info(envFilePath+fileName);
             OutputStream fos = new FileOutputStream(envFilePath+fileName);   
             props.setProperty(keyname, keyvalue);   
             // 以适合使用 load 方法加载到 Properties 表中的格式，   
             // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
             props.store(fos, "Update '" + keyname + "' value");   
             log.info("token:"+pu.getPropsValue(fileName,"token"));
         } catch (IOException e) {   
             log.info("属性文件更新错误");   
         }   
     }   
    
    
    
    /**
     * 根据不同环境配置文件名称，获取该文件Properties
     * @param propsEnvName
     * @return
     */
    public static Properties getENVProperties(String propsENVFileName) {
    	
    	Properties props = new Properties();

    	if(envFilePath == null) {
    		PropsUtil pu = new PropsUtil();
        	FileInputStream in = null;

        	String paht=pu.getPropsFilePath("env.properties").replaceAll("env.properties", "");
        	 env=pu.getPropsValue("env.properties","env");
        	
        	log.info("查询"+env+"环境配置文件："+propsENVFileName);
        	envFilePath = paht+"/"+env+"/";
//        	FileInputStream in = new FileInputStream(envFilePath+propsENVFileName);
			try {
				in = new FileInputStream(envFilePath+propsENVFileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("加载文件"+envFilePath+propsENVFileName+"异常...");
				 try {
					in = new FileInputStream(envFilePath.replaceAll("build/classes", "src")+propsENVFileName);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	try {
				props.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("流导入异常...");

			}
        	try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("流关闭异常...");
			}
        	
    	}
    	return props;

    }
    
    
    
    
    /**
     * 获取配置文件名称，获取该文件Properties
     * @param propsEnvName
     * @return
     */
    public static Properties getProperties(String propsName) {
		log.info("获取config路径下的Properties配置文件："+propsName);

    	Properties props = new Properties();

    	if(envFilePath == null) {
    		PropsUtil pu = new PropsUtil();
        	FileInputStream in = null;

        	String filePath=pu.getPropsFilePath(propsName);
        	
			try {
				in = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("加载文件"+propsName+"异常...");
			}
        	try {
				props.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("流导入异常...");

			}
        	try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("流关闭异常...");
			}
        	
    	}
    	return props;

    }
    
    /**
     * 获取config目录下的配置文件
     * @param propsName
     * @return
     */
    public    String getPropsFilePath(String propsName) {
        log.info("调用 getPropsFilePath()查询文件"+propsName);
      //按着main执行方式寻找config下的配置文件
        String filePath = this.getClass().getResource("/").getPath().toString()+"config/"+propsName;
        File file=new File(filePath);    
        if(!file.exists()) {    
           log.info(filePath+"改路径下不存在文件"+propsName);
           log.info("更换路径，重新检查1");
           //按着main执行方式寻找config/env下的配置文件
           filePath = this.getClass().getResource("/").getPath().toString()+"config/"+getEnv()+"/"+propsName;
           File file1=new File(filePath);    
               if(!file1.exists()) {   
                  log.info(filePath+"该路径下不存在文件"+propsName);
                  log.info("更换路径，重新检查2");
                  //按着tomcat执行方式寻找config下的配置文件
                   filePath= PropsUtil.class.getResource("/").getPath().substring(0, PropsUtil.class.getResource("/").getPath().indexOf("WEB-INF"))+File.separator +"config"+File.separator;
     		       log.info("该方法是web读取出的路径config/："+filePath);
  		              File file2=new File(filePath);    
  	                  if(!file2.exists())  {   
  	                    log.info(filePath+"该路径下不存在文件"+propsName);
  	                    log.info("更换路径，重新检查3");
  	                    filePath= PropsUtil.class.getResource("/").getPath().substring(0, PropsUtil.class.getResource("/").getPath().indexOf("WEB-INF"))+File.separator +"config/"+getEnv()+File.separator;
                        log.info("该方法是web读取出的路径config/"+env+"/:"+filePath);
  		                 File file3=new File(filePath);    
                            if(!file3.exists()) {    
        	                   log.info(filePath+"该路径下也不存在文件"+propsName);
                              }
  	                  }
               }
               
               
        

        }
        log.info("路径结果为:"+filePath);
        return filePath;
    }
    
    
    
    /**
     * 读取属性文件中的属性值
     * @param attr
     * @return
     */
    public String getPropsValue(String propsName,String key){
    	log.info("待查詢字段為："+key);
        String retValue = "";
        Properties props = new Properties();
        try {
           /* if (!FileUtil.isFileExist(getPropsFilePath(propsName))) {
                return "";
            }
            FileInputStream fi = new FileInputStream(getPropsFilePath());*/
            InputStream fi =new FileInputStream(getPropsFilePath(propsName));
            props.load(fi);
            fi.close();

            retValue = props.getProperty(key);
        } catch (Exception e) {
            return "";
        }
        return retValue;
    }
    
   
    
    

//    private InputStream getPropsIS(String propsName) {
//        InputStream ins = this.getClass().getResourceAsStream(getPropsFilePath(propsName));
//        return ins;
//	}

	public static void main(String[] args) {
    	PropsUtil pu = new PropsUtil();
    	Properties props = new Properties();
    	//读取getENVProperties;
//    	props=pu.getENVProperties("result.properties");
//    	log.info(props.toString());
    	
    	//读取config下的配置文件
    	props=pu.getProperties("log4j.properties");
    	log.info(props.toString());
    	
    	//根据文件名获取文件 路径
    	
    	log.info(pu.getPropsFilePath("log4j.properties"));
    	
    	
    	log.info(pu.getPropsValue("log4j.properties", "log4j.logger.org.springside.examples.miniweb"));
    	log.info(pu.getPropsValue("mail.properties", "myEmailSmtpHost"));
//    	String filePaht=pu.getPropsFilePath("env.properties");
//    	String env=pu.getPropsValue("env.properties","env");
//    	String path = filePaht+"/"+env;
//    	log.info(path);
//    	
//    	log.info(getENVProperties("result.properties").toString());
    	
	}
	
	
	
}

    
