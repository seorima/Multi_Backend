package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, user, pwd);
			stmt = conn.createStatement();
			sql = "insert into jdbc_test values ('�̼���', 'longlee@daum.net')";
			
			int rowCount = stmt.executeUpdate(sql);
			
			System.out.println(rowCount + "���� ���� �ԷµǾ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub
/*
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,user,pwd);  //��ü�� �����԰�
			stmt = conn.createStatement();
			sql = "insert into jdbc_test() values ('�缭��','seorima@naver.com')"; // ���� ������ ���Ť��԰�
			int rowCount = stmt.executeUpdate(sql); // ����� ���� ����
			
			
			System.out.println(rowCount + "���� ���� �ԷµǾ����ϴ�");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		} */
	}

}
