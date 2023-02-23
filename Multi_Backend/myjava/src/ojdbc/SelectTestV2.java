package ojdbc;

import java.sql.*;

public class SelectTestV2 {
	
	//예제 스크린샷 staticSelect arraylist버전으로 바꾸는 문제
	//arraylist를 이용하여 모든 행 정보를 반환한후 그 결과를 출력하는 코드를 작성
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public SelectTestV2() {
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
	
	public jdbcTest dynamicSelect(String username) {
		this.sql = "select * from jdbc_test where username = ?";
		jdbcTest jdbcTest = null;
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			
			this.rs = this.pstmt.executeQuery();
			
			// 사용자 이름이 고유하다고 가정!
			if(this.rs.next()) {
				jdbcTest = new jdbcTest(this.rs.getString("username"), this.rs.getString("email"));
			}
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
		
		return jdbcTest;
	}

	public void staticSelect() {
		//linkedlist는 기족위치에 삽입을 빠르게 하기위한거라서 그건 딱히 필요는 업는..
		
		this.sql = "select * from jdbc_test";
		
		try {
			this.stmt = conn.createStatement();			
			this.rs = this.stmt.executeQuery(sql);
			
			while(this.rs.next()) {
				System.out.println(this.rs.getString("username") + "\t" + this.rs.getString("email"));
			}
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
	}
	
	public void closeConnection() { //connection 닫는거
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
		SelectTestV2 st = new SelectTestV2();
		
		jdbcTest jdbcTest = st.dynamicSelect("박찬호");
		System.out.println(jdbcTest.getUsername() + "\t" + jdbcTest.getEmail());
		
		
		// st.staticSelect();
		
		st.closeConnection();
	}	
}










