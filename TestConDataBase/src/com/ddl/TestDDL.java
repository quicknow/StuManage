package com.ddl;


import java.sql.*;

public class TestDDL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement  ps = null;
		
		try {
			//加载数据源驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			
			//连接数据源对象
			ct =DriverManager.getConnection("jdbc:microsoft:sqlserver://192.168.0.100:1433;databaseName=QiaoDongSchool","sa","flyvideo");
			
			//PreparedStatement 执行sql语句的对象 
			//ps=ct.prepareStatement("select * from student where (StudentName=?  and sex=?)");
			//创建数据库
//			ps=ct.prepareStatement("create database vvv");
//			Boolean b= ps.execute();
//			System.out.println(b);
			
			//删除数据库
//			ps=ct.prepareStatement("drop database vvv");
//			Boolean b= ps.execute();
//			System.out.println(b);
			
			//备份数据库
			ps=ct.prepareStatement("backup database QiaoDongSchool to disk='c:/bak/cc.bak'");
			boolean b= ps.execute();
			System.out.println(b);
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(ct!=null){
					ct.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}