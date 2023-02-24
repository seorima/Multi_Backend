package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {

		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		Connection conn = null;
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,user,pwd);
			
			System.out.println(conn.isClosed() ? "���� ����" : "���� ����!");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(!conn.isClosed()) {
					conn.close();
					System.out.println(conn.isClosed() ? "���� ����" : " ");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
