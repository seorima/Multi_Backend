package ojdbc;

import java.sql.*;

public class InsertTest3_2 {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	String sql;
	
	public InsertTest3_2() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int staticInsert(String username, String email) {
		int rowCount = 0;
		
		try {
			this.stmt = conn.createStatement();
			this.sql = "insert into jdbc_test values ('" + username + "', '" + email + "')";
			rowCount = stmt.executeUpdate(this.sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!this.stmt.isClosed()) {
					this.stmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowCount;
	}
	
	public int dynamicInsert(String username, String email) {
		int rowCount = 0;
		this.sql = "insert into jdbc_test values(?, ?)";
		
		try {
			this.pstmt = conn.prepareStatement(this.sql);
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			
			rowCount = pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowCount;
	}
	
	public void closeConnection() {
		try {
			if(!this.conn.isClosed()) {
				this.conn.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InsertTest3_2 it = new InsertTest3_2();
		int rowCount = 0;
		
		// rowCount = it.staticInsert("홍길동", "hong@naver.com");
		rowCount = it.dynamicInsert("박찬호", "park@nate.com");
		System.out.println(rowCount + "개의 행이 입력되었습니다.");
		
		it.closeConnection();
	}
}

















