package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	
	//���� selectTEstV2
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	public SelectTest2() {
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


public jdbcTest dynamicSelect(String username) { //jdbc��ü�� ��ȯ�Ѵ�.
	
	this.sql = "select * from jdbc_test where username=?";
	jdbcTest jdbctest = null;
	
	try {
		
		this.pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		
		this.rs = this.pstmt.executeQuery(); // ����� �̸��� �����ϴٰ� ����!
		
		if(this.rs.next()) { //�ϳ��� ���� ��������� �ߴٸ�,
			jdbctest = new jdbcTest(this.rs.getString("username"), this.rs.getString("email")); //���� username�� email�� �о�´�?
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
	
	return jdbctest;
} 

public void staticSelect() { 
	
	this.sql = "select * from jdbc_test";
	
	try {
		
		this.stmt = conn.createStatement();
		this.rs = this.stmt.executeQuery(sql); // ����� �̸��� �����ϴٰ� ����!
		
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
	
	SelectTest2 st = new SelectTest2();
	jdbcTest jdbctest = st.dynamicSelect("ȫ�浿");
	System.out.println(jdbctest.getUsername()+"\t" + jdbctest.getEmail());
	
	//st.staticSelect();
	
	st.closeConnection();
		
	
}
	
}
