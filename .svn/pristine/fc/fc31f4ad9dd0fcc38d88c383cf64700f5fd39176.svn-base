package com.umpaytester.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** ******************  类说�?  *********************
 * class       :  SQLUtil 
 * @version    :  1.0  
 * description :  SQL工具�?
 * @see        :                        
 * ************************************************/   
public class SQLUtil {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static ResultSetMetaData rsmd =null;
	
	static String jdbcDriver = "com.ibm.db2.jcc.DB2Driver";//驱动
	static String jdbcUrl = "jdbc:db2://10.10.73.95:60000/upontest";//jdbc 连接
	static String jdbcUsername = "upaybusa";//数据库用户名
	static String jdbcPassword = "upaybusa";//数据库密�?
	static String sql = null;//sql操作语句
	
	public static void setJdbcDriver(String jdbcDriver) {
		SQLUtil.jdbcDriver = jdbcDriver;
	}
	public static void setJdbcUrl(String jdbcUrl) {
		SQLUtil.jdbcUrl = jdbcUrl;
	}
	public static void setJdbcUsername(String jdbcUsername) {
		SQLUtil.jdbcUsername = jdbcUsername;
	}
	public static void setJdbcPassword(String jdbcPassword) {
		SQLUtil.jdbcPassword = jdbcPassword;
	}
	public static void setSql(String sql) {
		SQLUtil.sql = sql;
	}
	
	public static String getJdbcDriver() {
		return SQLUtil.jdbcDriver ;
	}
	public static String getJdbcUrl() {
		return SQLUtil.jdbcUrl ;
	}
	public static String getJdbcUsername() {
		return SQLUtil.jdbcUsername ;
	}
	public static String getJdbcPassword() {
		return SQLUtil.jdbcPassword ;
	}
	public static String getSql() {
		return SQLUtil.sql ;
	}
	/**
	 * ******************************************** 
	 * method name : excuteQuery
	 * description : 执行查询操作 (select)
	 * @return : List<Map<String, String>>
	 * @param : @param sqlStr
	 * ********************************************/
	public static List<Map<String, String>> excuteQuery(String sqlStr) {
		List< Map<String, String> > result = new ArrayList<Map<String, String>>();
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
			ps = conn.prepareStatement(sqlStr);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			int count = 0;
			while (rs.next()) {
				count++ ;
				if(count > 100){
//					System.out.println("数据库查出数据量过多，只返回�?100�?");
					return result;
				}
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i)==null?"":rs.getObject(i).toString());
				}
				result.add(map);
			}
//			System.out.println("查询�?" +count+ "条数�?");
		} catch (SQLException e) {
//			System.out.println("测试出现SQL异常，异常信息如下：" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;

	}

	/** ********************************************
	 * method name   : excuteUpdate 
	 * description   : 执行更新操作（update,delete,insert�?
	 * @return       : int 返回操作�?修改的行�?
	 * @param        : @param sqlStr
	 * ********************************************/      
	public static int excuteUpdate(String sqlStr) {
		int count = 0;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//			conn = ConnectionFactory.getConnection(true);
			ps = conn.prepareStatement(sqlStr);
			count = ps.executeUpdate();
			System.out.println("更新成功" +count+ "条数");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
///*
	public static void main(String args[]){
//		示例�?
		String sql = null;
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		int count=0;
		ConfigUtil.loadConfig("/config/jdbc.properties","UTF-8");//加载jdbc配置文件
//		SQLUtil.setJdbcUrl(ConfigUtil.getConfig("jdbc.url.wjon"));//获取jdbc连接url.ft95on
		SQLUtil.setJdbcUrl(ConfigUtil.getConfig("url.ft95on"));
		SQLUtil.setJdbcUsername(ConfigUtil.getConfig("usr.uwtdusrb"));//获取数据库用户名
		SQLUtil.setJdbcPassword(ConfigUtil.getConfig("pwd.uwtdusrb"));//获取数据库密�?
		
//		SQLUtil.setJdbcUrl("jdbc:db2://10.10.73.25:50000/upontest");//获取jdbc连接
//		SQLUtil.setJdbcUsername("ubusiyhk");//获取数据库用户名
//		SQLUtil.setJdbcPassword("ubusiyhk");//获取数据库密�?
		
		//select 查询
		sql ="select * from umpay.T_WTD_B2BDTL where wtdid =1400001519 ";//+"'" + "1312261012464445" + "'";
		System.out.println("sql="+sql);
		result=SQLUtil.excuteQuery(sql);
		System.out.println("DB="+ result.get(0));//获取第一条数�?
		for (Map<String, String> map:result){//遍历�?有数�?
			System.out.println("WTDID="+ map.get("WTDID").toString());
			System.out.println("TRACE="+ map.get("TRACE").toString());
			System.out.println("WTDSEQ="+ map.get("WTDSEQ").toString());
		}

/*
		//update 更新
		String sql2 = null;
		sql2= "update umpay.T_WTD_B2BDTL set undostatus=0 where wtdid="+ "1400001519";
		System.out.println("sql="+sql2);
		count=excuteUpdate(sql2);
*/	
/*
		//insert 插入
		String sql3 = null;
		sql3= "update umpay.T_WTD_B2BDTL set undostatus=6 where wtdid=1400001519";
		System.out.println("sql="+sql3);
		count=excuteUpdate(sql3);
*/
/*		
		//delete 删除
		String sql4 = null;
		sql4= "update umpay.T_WTD_B2BDTL set undostatus=1 where wtdid=1400001519";
		System.out.println("sql="+sql4);
		count=excuteUpdate(sql4);
*/
	}
//*/
}
