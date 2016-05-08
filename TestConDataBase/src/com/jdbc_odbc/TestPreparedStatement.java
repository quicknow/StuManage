package com.jdbc_odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class TestPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement  ps = null;
		
		try {
			//��������Դ����
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//��������Դ����
			ct =DriverManager.getConnection("jdbc:odbc:test","sa","flyvideo");
			
			//PreparedStatement ִ��sql���Ķ��� ,ʹ�ã� ���и���
			ps=ct.prepareStatement("select * from student where (StudentName=?  and sex=?)");
			
			ps.setString(1, "���ı� ");
			ps.setString(2, "��");
			
		/*	����
			int i=st.executeUpdate("insert into student values(4,'С��','��',26)");
			
			if(i==1){
				System.out.println("insert sucess");
			} else {
				System.out.println("insert fall");
			}*/
			
			//��ѯ
			//ResultSet rs=st.executeQuery("select * from student where (StudentName='���ı�' or 1='1' and sex='����')");
			ResultSet rs=ps.executeQuery();
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
