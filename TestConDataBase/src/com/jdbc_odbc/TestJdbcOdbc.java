package com.jdbc_odbc;

import java.sql.*;

public class TestJdbcOdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		Statement  st = null;
		
		try {
			//��������Դ����
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//��������Դ����
			ct =DriverManager.getConnection("jdbc:odbc:test","sa","flyvideo");
			
			//Statement ִ��sql���Ķ���
			st=ct.createStatement();
			
		/*	����
			int i=st.executeUpdate("insert into student values(4,'С��','��',26)");
			
			if(i==1){
				System.out.println("insert sucess");
			} else {
				System.out.println("insert fall");
			}*/
			
			//��ѯ
			ResultSet rs=st.executeQuery("select * from student where (StudentName='���ı�' or 1='1' and sex='����')");
			
			//ʹ���α�����̽
			while(rs.next()){
				
				int id= rs.getInt(1);
				String studentname=rs.getString(2);
				String sex=rs.getString(3);
				int age= rs.getInt(4);
				
				System.out.println("��ѯ�����"+id+" "+studentname+" "+sex+" "+age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			try {
				if(st!=null){
					st.close();
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
