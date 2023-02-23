package ojdbc;

import java.sql.*;

public class InsertTest2 { //객체지향적으로
	
	Connection conn = null;
	Statement stmt = null;
	String sql = "";
	
	public InsertTest2() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
			
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int staticInsert(String username, String email) {
		int rowCount=0;
		
		try {
			
			this.stmt = conn.createStatement();
			this.sql = "insert into jdbc_test values (' " + username + "','" + email + "')";
			rowCount = stmt.executeUpdate(this.sql);
			
		}catch(SQLException e) {
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
		
		InsertTest2 it = new InsertTest2();
		int rowCount=0;
		
		rowCount = it.staticInsert("홍길동","hong@naver.com");
		System.out.println(rowCount + "개의 행이 입력되었습니다.");
		
		it.closeConnection();
			
		
	}
}

















