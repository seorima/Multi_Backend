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
			sql = "insert into jdbc_test values ('이성구', 'longlee@daum.net')";
			
			int rowCount = stmt.executeUpdate(sql);
			
			System.out.println(rowCount + "개의 행이 입력되었습니다.");
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
			conn = DriverManager.getConnection(jdbc_url,user,pwd);  //객체를 가져왔고
			stmt = conn.createStatement();
			sql = "insert into jdbc_test() values ('양서림','seorima@naver.com')"; // 넣을 정보도 가ㅕㅈ왔고
			int rowCount = stmt.executeUpdate(sql); // 저장될 행의 개수
			
			
			System.out.println(rowCount + "개의 행이 입력되었습니다");
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
