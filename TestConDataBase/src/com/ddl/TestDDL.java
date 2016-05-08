package com.ddl;


import java.sql.*;

public class TestDDL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement  ps = null;
		
		try {
			//��������Դ����
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			
			//��������Դ����
			ct =DriverManager.getConnection("jdbc:microsoft:sqlserver://192.168.0.100:1433;databaseName=QiaoDongSchool","sa","flyvideo");
			
			//PreparedStatement ִ��sql���Ķ��� 
			//ps=ct.prepareStatement("select * from student where (StudentName=?  and sex=?)");
			//�������ݿ�
//			ps=ct.prepareStatement("create database vvv");
//			Boolean b= ps.execute();
//			System.out.println(b);
			
			//ɾ�����ݿ�
//			ps=ct.prepareStatement("drop database vvv");
//			Boolean b= ps.execute();
//			System.out.println(b);
			
			//�������ݿ�
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