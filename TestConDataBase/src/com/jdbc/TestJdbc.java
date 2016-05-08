package com.jdbc;




import java.sql.*;

import javax.sql.rowset.JdbcRowSet;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement  ps = null;
		
		try {
			//��������Դ����
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			
			//��������Դ����
			ct =DriverManager.getConnection("jdbc:microsoft:sqlserver://192.168.0.100:1433;databaseName=QiaoDongSchool","sa","flyvideo");
			
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
