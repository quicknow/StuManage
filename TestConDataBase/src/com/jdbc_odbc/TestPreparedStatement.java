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
			//加载数据源驱动
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//连接数据源对象
			ct =DriverManager.getConnection("jdbc:odbc:test","sa","flyvideo");
			
			//PreparedStatement 执行sql语句的对象 ,使用？ 进行复制
			ps=ct.prepareStatement("select * from student where (StudentName=?  and sex=?)");
			
			ps.setString(1, "朱文兵 ");
			ps.setString(2, "男");
			
		/*	插入
			int i=st.executeUpdate("insert into student values(4,'小李','男',26)");
			
			if(i==1){
				System.out.println("insert sucess");
			} else {
				System.out.println("insert fall");
			}*/
			
			//查询
			//ResultSet rs=st.executeQuery("select * from student where (StudentName='朱文兵' or 1='1' and sex='朱文')");
			ResultSet rs=ps.executeQuery();
			//使用游标向下探
			while(rs.next()){
				
				int id= rs.getInt(1);
				String studentname=rs.getString(2);
				String sex=rs.getString(3);
				int age= rs.getInt(4);
				
				System.out.println("查询结果："+id+" "+studentname+" "+sex+" "+age);
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
