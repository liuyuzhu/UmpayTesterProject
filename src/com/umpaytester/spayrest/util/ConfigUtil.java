package com.umpaytester.spayrest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import plat2_paybusi.util.ConfigUtil;




/** ******************  类说明  *********************
 * class       :  ConfigUtil
 * @author     :  LiuJiLong
 * @version    :  1.0  
 * description :  配置工具类
 * @see        :                        
 * ************************************************/   
public class ConfigUtil {
	final static Logger logger = LoggerFactory.getLogger("ConfigUtil.class");
	
	/**
	 * 测试用例的环境，取值：dev/A1/B1/C1/D1/E，这个变量在具体用例的DataProvider中提供
	 * <BR>用于切换不同环境
	 */
	public static final String CaseEnvironment="dev";
	
	static private String configPath;
	public static String getConfigPath() {
		return configPath;
	}
	public static void setConfigPath(String configPath) {
		ConfigUtil.configPath = configPath;
	}

	static Properties props = null;
	
	/**
	 * 初始化
	 */
	public ConfigUtil(){
//		ConfigUtil.configPath = configPath;
	}
	
	/**
	 * 初始化
	 * @param configPath="/config/jdbc.properties"
	 * @param configPath="/pbg/config/jdbc.properties"
	 * @param charSet = UTF-8|GBK
	 */
	public static void loadConfig(String configPath,String charSet){

		try {
			String basePath = new URI(ConfigUtil.class.getResource("/").toString()).getPath(); //支持路径有空格
//			String basePath = ConfigUtil.class.getResource("/").getPath();//不支持路径空格
//			System.out.println("读取配置文件："+basePath+configPath);
			ConfigUtil.configPath = basePath+configPath;
			
//			InputStreamReader in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir")+"/config/jdbc.properties"));
			
//			InputStreamReader in = new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/config/jdbc.properties"),"GBK");
			
//			InputStreamReader in = new InputStreamReader(new FileInputStream(ConfigUtil.class.getResource("/").getPath()+"/config/jdbc.properties"),"GBK");
			
			//方法1
			InputStreamReader in = new InputStreamReader(new FileInputStream(basePath+configPath),charSet);//当前类所在bin目录，configpath提供bin目录后面的相对路径
			//方法2
//			InputStreamReader in = new InputStreamReader(ConfigUtil.class.getResourceAsStream("/"+configPath), charSet);//当前类所在bin目录，configpath提供bin目录后面的相对路径
			//方法3
//			InputStream in = ConfigUtil.class.getResourceAsStream("/"+configPath);
			
			props = new Properties();
			props.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadConfig(String configPath){
		ConfigUtil.configPath = configPath;
		InputStream in = null;
//		InputStreamReader   in = null;

		try {
//			in = new BufferedInputStream(new FileInputStream(configPath+"testType.properties"));
//			in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir")+"/config/config.properties"));
//			in = new InputStreamReader (new FileInputStream(System.getProperty("user.dir")+"/config/mapping_rcode.properties"),"GBK");
//			in = new InputStreamReader (new FileInputStream(configPath),"GBK");
//			in = new InputStreamReader (new FileInputStream(System.getProperty("user.dir")+configPath),"GBK");
			in = ConfigUtil.class.getResourceAsStream(configPath);

//			InputStream in = ConfigUtil.class.getResourceAsStream("/TestAuto_xin1124/"+configPath);
//			logger.info("configPath="+System.getProperty("user.dir")+ConfigUtil.configPath);
			props = new Properties();
			props.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化
	 * @param configPath="/config/config.properties"
	 */
/*
	static{
//		if(configPath==null){
//			logger.error("没有设定CONFIG路径");
//			System.exit(0);
//		}
		InputStreamReader in = null;
		try {
//			得到工程的路径：System.getProperty("user.dir")//当前程序根目录
//			in = new BufferedInputStream(new FileInputStream("testType.properties"));
//			in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir")+"/config/config.properties"));
//			in = new InputStreamReader (new FileInputStream(System.getProperty("user.dir")+"/config/mapping_rcode.properties"),"GBK");
			in = new InputStreamReader (new FileInputStream(System.getProperty("user.dir")+ConfigUtil.configPath),"GBK");
			props = new Properties();
			props.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	/** ********************************************
	 * method name   : getConfig 
	 * description   : 获取配置的VALUE
	 * @return       : String
	 * @param        : @param key
	 * @param        : @return
	 * modified      : LiuJiLong ,  2011-12-20  上午11:15:23
	 * @see          : 
	 * ********************************************/      
	public static String getConfig(String key){
		return trim(props.getProperty(key));
	}
	
	/**
	 * 去掉字符串首尾的 <空格字符>（包括TAB），如果s为null则返回空字符串""。
	 */
	public static String trim(String s) {
		if (s == null)
			return "";
		else
			return s.trim();
	}
	
	/** ********************************************
	 * method name   : getKeys 
	 * description   : 获取配置的VALUES
	 * @return       : Enumeration<String>
	 * @param        : @return
	 * modified      : LiuJiLong ,  2011-12-20  上午11:15:43
	 * @see          : 
	 * ********************************************/      
	public static Enumeration<Object> getKeys(){
		return  (Enumeration<Object>)props.keys(); 
	}
	
	/** ********************************************
	 * method name   : getKeys 
	 * description   : 获取配置的VALUES
	 * @return       : Enumeration<String>
	 * @param        : @return
	 * modified      : LiuJiLong ,  2011-12-20  上午11:15:43
	 * @see          : 
	 * ********************************************/
	@SuppressWarnings("unchecked")
	public static Enumeration<String> getValuess(){
		return  (Enumeration<String>) props.propertyNames();
	}
	
	/** ********************************************
	 * method name   : getValuesByPre 
	 * description   : 返回一系列带有指定前缀的配置项
	 * @return       : Map<String,String>
	 * @param        : @param pre
	 * @param        : @return
	 * modified      : LiuJiLong ,  2012-8-6  下午03:04:13
	 * @see          : 
	 * ********************************************/      
	public static Map<String, String> getValuesByPre(String pre){
		Map<String, String> map = new HashMap<String, String>();
		for(Entry<Object, Object> ent:props.entrySet()){
			if(ent.getKey()!=null&&ent.getKey().toString().trim().startsWith(pre)){//如果配置的KEY值与传入的前缀一致，则返回其值
				map.put(ent.getKey().toString(), ent.getValue().toString());
			}
		}
		return map;
	}
	
	/**
	 * 含有前缀的属性中，取属性indexPre长度后的值作为key值，返回map
	 * 此方法等同于getValuesWithoutPre()方法。
	 * @param pre
	 * @param indexPre
	 * @return
	 * @author "ZouGuoPing"
	 * @date 2014-9-29 下午07:13:12
	 *
	 */
	public static Map<String, String> getValuesByPre(String pre,int indexPre){
		Map<String, String> map = new HashMap<String, String>();
		for(Entry<Object, Object> ent:props.entrySet()){
			if(ent.getKey()!=null&&ent.getKey().toString().trim().startsWith(pre)){//如果配置的KEY值与传入的前缀一致，则返回其值
				map.put(ent.getKey().toString().substring(indexPre), ent.getValue().toString().trim());
			}
		}
		return map;
	}
	
	/** ********************************************
	 * method name   : getValuesByPre 
	 * description   : 返回一系列带有指定前缀的配置项
	 * @return       : Map<String,String>
	 * @param        : @param pre
	 * @param        : @return
	 * modified      : LiuJiLong ,  2012-8-6  下午03:04:13
	 * @see          : 
	 * ********************************************/      
	public static Map<String, String> getValuesWithoutPre(String pre){
		Map<String, String> map = new HashMap<String, String>();
		for(Entry<Object, Object> ent:props.entrySet()){
			String entKey = null;
			if(ent.getKey()!=null){
				entKey = ent.getKey().toString();
			}else{
				continue;
			}
			if(entKey.trim().startsWith(pre)){//如果配置的KEY值与传入的前缀一致，则返回其值
				map.put(entKey.replaceFirst(pre+"\\.", ""), ent.getValue().toString().trim());
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @param pre
	 * @param indexPre
	 * @return
	 */
	public static Map<String, String> getValues(){
		Map<String, String> map = new HashMap<String, String>();
		for(Entry<Object, Object> ent:props.entrySet()){
			if(ent.getKey()!=null){//如果配置的KEY值与传入的前缀一致，则返回其值
				map.put(ent.getKey().toString().trim(), ent.getValue().toString().trim());
			}
		}
		return map;
	}
	
	/** ********************************************
	 * method name   : setConfig 
	 * description   : 设置配置
	 * @return       : boolean
	 * @param        : @param key
	 * @param        : @param value
	 * @param        : @return
	 * modified      : LiuJiLong ,  2011-12-20  上午11:15:56
	 * @see          : 
	 * ********************************************/      
	public static boolean setConfig(String key, String value) {
		try {
			OutputStream fos = new FileOutputStream(configPath);
			props.setProperty(key, value);
			props.store(fos, "Update '" + key + "' value");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		ConfigUtil.loadConfig("config/jdbc.properties","UTF-8");
		System.out.println(ConfigUtil.getConfig("jdbc.driver"));
	}
	
}



