package chap08.queryTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.*;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberCountBean { // 자동 의존 주입
	
	@Autowired
	private DataSource ds;  //의존 관계에 있는 녀석
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public MemberCountBean() {
		
	}
	
	public int getMemberCount() {
		int rowCount = 0;
		String sql = "select count(*) count from member";
		
		try {
			this.conn = this.ds.getConnection();
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(sql);
			
			if(this.rs.next()) {
				rowCount = this.rs.getInt("count");
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		finally {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
		
		return rowCount;
	}
	

}
