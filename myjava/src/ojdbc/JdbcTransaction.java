package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JdbcTransaction {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public JdbcTransaction() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver); // �� �̷��̸��� ���̺��� ����� �̰ǰ�..
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
			conn.setAutoCommit(false); //�����ڿ��� false �س��⶧���� Ʈ����� ���� ���� �����ϰڴ�!! ��� �ǹ� , ������ close�ϸ� �ڵ� Ŀ�Ե�
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int dynamicInsert(String username, String email) { //�켱 �� insertTest3�� �ִ°� �����ؿ�
		int rowCount = 0;
		this.sql = "insert into jdbc_test values(?, ?)";
		
		try {
			this.pstmt = this.conn.prepareStatement(this.sql);
			this.pstmt.setString(1, username);
			this.pstmt.setString(2, email);
			
			rowCount = this.pstmt.executeUpdate();
			
		/*	if(rowCount==1) { //���������� �Է��� �Ǿ��ٸ�
				this.conn.commit();
			}*/
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

	public static void main(String[] args) { //�켱 �� insertTest3�� �ִ°� �����ؿ�,,,, �׸��� ������ �����ڵ�� �ٸ� savepoint�� �ȵŤ�
		JdbcTransaction jt = new JdbcTransaction();
		int rowCount = 0;
		Savepoint s3 = null;
		
		rowCount = jt.dynamicInsert("�迬��", "kim_yk@naver.com");
		System.out.println(rowCount + "���� ���� �ԷµǾ����ϴ�.");
		
	/*try {
			SavePoint s3 = jt.conn.setSavePoint("s3");
		}
		*/
		jt.closeConnection();
	}
}
