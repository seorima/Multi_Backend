package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	public SelectTest() {
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


public void dynamicSelect(String username) { 
	
	this.sql = "select * from jdbc_test where username=?";
	String email;
	
	try {
		
		this.pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		
		this.rs = this.pstmt.executeQuery(); // 사용자 이름이 고유하다고 가정!
		
		if(this.rs.next()) {
			System.out.println(this.rs.getString("username")+"\t" + this.rs.getString("email"));
		}
		
	}catch(SQLException e){
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
} // 이 함수만 적어놓고 다른거를 못건들여서 수정할게 생길수도있음

public void staticSelect() { 
	
	this.sql = "select * from jdbc_test";
	
	try {
		
		this.stmt = conn.createStatement();
		this.rs = this.stmt.executeQuery(sql); // 사용자 이름이 고유하다고 가정!
		
		if(this.rs.next()) {
			System.out.println(this.rs.getString("username")+"\t" + this.rs.getString("email"));
		}
		
	}catch(SQLException e){
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
	
	SelectTest st = new SelectTest();
	st.dynamicSelect("홍길동");
	//st.staticSelect();
	
	st.closeConnection();
		
	
}

}
