package com.umpaytester.utils;

import java.util.List;
import java.util.Map;




public class AccountConst  {
	

//	protected static String confPath = ConfigUtil.class.getResource("/config/").getPath();
	
	public static List<Map<String, String>> dbquerySpecified(int index,String sql) {
		List<Map<String, String>> result = null;
		if(index==1 || index==2){
			result = dbquery95(sql);
		}
		else if(index==3 || index==4){
			result = dbquery96(sql);
		}
		else if(index==0){
			result = dbquery25(sql);
		}
		return result;
	}
	
	public static int dbupdateSpecifiedCRM(int index,String sql) {
		int result = 0;
		if(index==1 || index==2){
			result = dbupdateCRM95(sql);
		}
		else if(index==3 || index==4){
			result = dbupdateCRM96(sql);
		}
		else if(index==0){
			result = dbupdateCRM25(sql);
		}
		return result;
	}
	
	public static List<Map<String, String>> dbquerySpecifiedCRM(int index,String sql) {
		List<Map<String, String>> result = null;
		if(index==1 || index==2){
			System.out.println("db 95 select....");
			result = dbquery95CRM(sql);
		}
		else if(index==3 || index==4){
			System.out.println("db 96 select....");
			result = dbquery96CRM(sql);
		}
		else if(index==0){
			System.out.println("db 25 select....");
			result = dbquery25CRM(sql);
		}
		return result;
	}
	
	// 数据库查�?
	public static List<Map<String, String>> dbquery(String sql) {
//		System.out.println(confPath);
//		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();
		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusb"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusb"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusb"));
		return SQLUtil.excuteQuery(sql);

	}
	
	// 数据库查�?
	public static List<Map<String, String>> dbquery2(String sql) {
//		System.out.println(confPath);
		//  ConfigUtil.loadConfig("config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?
	public static List<Map<String, String>> dbquery3(String sql) {
//		System.out.println(confPath);
		// // ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upbgusra"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upbgusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upbgusra"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	

	// 数据库查�?
	public static List<Map<String, String>> dbquery1(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.usettlea"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.usettlea"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.usettlea"));
		return SQLUtil.excuteQuery(sql);

	}
	
	// 数据库查�?-使用upaybusa用户查询95在线数据�?
	public static List<Map<String, String>> dbquery95(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa95"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?-使用upaybusa用户查询95在线数据�?
	public static List<Map<String, String>> dbqueryUpaybusa(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?-使用upaybusa用户查询95在线数据�?
	public static List<Map<String, String>> dbqueryUpaybusb(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusb"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusb"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusb"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	
	// 数据库查�?-使用upaybusa用户查询95在线数据�?
	public static List<Map<String, String>> dbqueryPbg(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upbgusra"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upbgusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upbgusra"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?-使用upaybusa用户查询95在线数据�?
	public static List<Map<String, String>> dbquery96(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?-使用upaybusa用户查询25在线数据�?
	public static List<Map<String, String>> dbquery25(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteQuery(sql);
		
	}

	// 数据库更�?
	public static int dbupdate(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteUpdate(sql);
	}

	// 数据库更�?
	public static int dbupdate1(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.usettlea"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.usettlea"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.usettlea"));
		return SQLUtil.excuteUpdate(sql);
	}
	
	// 数据库更新CRM
	public static int dbupdateCRM25(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.ucrmusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.ucrmusra"));
		return SQLUtil.excuteUpdate(sql);
	}

	
	// 数据库更新CRM
	public static int dbupdateCRM95(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.ucrmusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.ucrmusra"));
		return SQLUtil.excuteUpdate(sql);
	}
	
	// 数据库更�?
	public static int dbupdateP2P95(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.upaybusa"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.upaybusa"));
		return SQLUtil.excuteUpdate(sql);
	}
	

	public static int dbupdateCRM96(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.ucrmusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.ucrmusra"));
		return SQLUtil.excuteUpdate(sql);
	}
	
	// 数据库查�?-使用ucrmusra用户查询96在线数据�?
	public static List<Map<String, String>> dbquery96CRM(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.ucrmusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.ucrmusra"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?-使用ucrmusra用户查询95在线数据�?
	public static List<Map<String, String>> dbquery95CRM(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.ucrmusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.ucrmusra"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
	// 数据库查�?-使用ucrmusra用户查询25在线数据�?
	public static List<Map<String, String>> dbquery25CRM(String sql) {
//		System.out.println(confPath);
		// ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");// 加载配置文件
		System.out.println("sql=" + sql);
		PropsUtil props = new PropsUtil();

		SQLUtil.setJdbcUrl(props.getPropsValue("jdbc.properties","url.upaybusa"));
		SQLUtil.setJdbcUsername(props.getPropsValue("jdbc.properties","usr.ucrmusra"));
		SQLUtil.setJdbcPassword(props.getPropsValue("jdbc.properties","pwd.ucrmusra"));
		return SQLUtil.excuteQuery(sql);
		
	}
	
//	public static void main(String[] args) {
//		String sql= "update umpay.t_busi_agreement_user set state=4 where userid='02000000014496' and mbagreementid like'%B200200H%'";
//		AccountConst.dbupdateCRM95(sql);
//	}
}
