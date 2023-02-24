package ojdbc;

import java.sql.*;

/*
	EMP ���̺��� ��� ��ȣ 7698(BLAKE) ����� BLAKE ����� ��� ���� �������� �ϳ��� Ʈ����� �ȿ��� �Բ� �����ϴ� �ڵ带 �ۼ��ϼ���. //���������� �̷�����־ �������� �������ϴ� ��Ȳ,����� �����ϴ� �޼��� ���������� Ȯ���ϴ� �޼���,Ʈ����� �����ϴ�.. 
	
	1) EMP.MGR �÷��� FK ���� ���� �߰�
	alter table emp add constraint emp_empno_pk primary key (empno);
	alter table emp add constraint emp_mgr_fk foreign key (mgr) references emp (empno);
	
	2) ��� ��ȣ 7698(BLAKE) ��� ����
	select *
	from emp
	where mgr = 7698;
	
	delete from emp
	where mgr = 7698;
	
	delete from emp
	where empno = 7698;
*/

public class TransactionTest {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public TransactionTest() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
			conn.setAutoCommit(false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getWorkerCount(int mgr) {
		int workerCount = 0;
		this.sql = "select count(*) count from emp where mgr = ?";
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, mgr);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				workerCount = this.rs.getInt("count");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return workerCount;
	}
	
	public int deleteEmp(boolean deleteWorker, int empno) {
		int rowCount = 0;
		this.sql = "delete from emp where empno = ?";
		
		if(deleteWorker) {
			this.sql = "delete from emp where mgr = ?";
		}
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, empno);
			rowCount = this.pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowCount;
	}
	
	public boolean deleteManager(int empno) {
		boolean result = false;
		
		try {
			if(this.getWorkerCount(empno) > 0) {
				this.deleteEmp(true, empno);
			}
			
			if(this.deleteEmp(false, empno) == 1) {
				result = true;
			}
			
			this.conn.commit();
		}
		catch (SQLException e) {
			try {
				this.conn.rollback();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
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
		TransactionTest tt = new TransactionTest();
		int mgr = 7698;
		
		if(tt.deleteManager(mgr)) {
			System.out.println("������ " + mgr + "��� �� �� ���� ���� ��θ� �����Ͽ����ϴ�.");
		}
		
		tt.closeConnection();
	}
}












