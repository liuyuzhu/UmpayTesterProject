package com.umpaytester.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午11:06:12
 *该类的功能:数据库连接工具
**/

public class DBUtil {

	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	

	//使用静态代码块的特性进行配置文件的读取，并复制给上面的静态变量
	static {
	//读取配置文件
		PropsUtil pu = new PropsUtil();
	
//	driver =pu.getPropsValue("jdbc.properties", "oracle_driver");
	url =pu.getPropsValue("jdbc.properties", "oracle_url");
	username =pu.getPropsValue("jdbc.properties", "oracle_username");
	password =pu.getPropsValue("jdbc.properties", "oracle_password");


	//加载驱动类
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

	//获得连接
	public static Connection getConnection(){
	try {
	return DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
	throw new RuntimeException(e);
	}
	}

	//关闭连接
	public static void close(Connection connection,PreparedStatement pstamt,ResultSet rs){
	if (rs!=null) {
	try {
	rs.close();
	} catch (SQLException e) {
	throw new RuntimeException(e);
	}
	}

	if (pstamt!=null) {
	try {
	pstamt.close();
	} catch (SQLException e) {
	throw new RuntimeException(e);
	}
	}

	if (connection!=null) {
	try {
	connection.close();
	} catch (SQLException e) {
	throw new RuntimeException(e);
	}
	}
	}


	
	//增
	public void sqlExecute(String sql){
		Connection con=DBUtil.getConnection();
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
//		 sql="{call insert_exp_user(?,?)}";
		cs=con.prepareCall(sql);
		cs.execute();
		} catch (Exception e) {
		throw new RuntimeException(e);
		}finally{
		DBUtil.close(con, cs, rs);
		}
		}
	//刪
	
	
	
	//改
	//查
	
	
	public static void main(String[] args) {
		DBUtil db = new DBUtil();
		String sql="select * from cbe_batchtask where BATCHNO='SKJ2017111332118'";
		db.sqlExecute(sql);
	}
	
	}
