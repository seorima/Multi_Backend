package ojdbc;

import java.sql.*;
import java.util.Calendar;

/*

update emp
set hiredate = to_date('1980/12/17 14:25:30', 'YYYY/MM/DD HH24:MI:SS')
where empno = 7369;

commit; //������Ʈ�ϰ� Ŀ�� �ʼ�

*/
public class JdbcEmp {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public JdbcEmp() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dynamicSelect() {
		/*
		this.sql = "select empno, ename, sal, to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS') as hiredate " + 
						"from emp where empno = ?";
		*/
		
		this.sql = "select empno, ename, sal, hiredate from emp where empno = ?";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setInt(1, 7369);
			
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				/*
				System.out.println(this.rs.getInt("empno") + "\t" + this.rs.getString("ename") + "\t" + 
						this.rs.getDouble("sal") + "\t" + this.rs.getString("hiredate"));
				*/
				
				/*
				Date hiredate = this.rs.getDate("hiredate");
				String newHiredate = hiredate.getYear() + "/" + hiredate.getMonth() + "/" + hiredate.getDate()
						+ " " + hiredate.getHours(); // + ":" + hiredate.getMinutes() + ":" + hiredate.getSeconds(); // 0. ��� ������ java.sql.Date�� ��¥�� ǥ�������ϰ� �ð��� ǥ���� �������� �ʱ⶧����
				*/
				
				// Timestamp timestamp = this.rs.getTimestamp("hiredate"); //���� ��������, timestamp��ü�� ��¥, �ð� ��� ǥ������
				// java.util.Date uDate = timestamp; //java.util.Date �� �ڽ� Ŭ�������� ����
				
				java.util.Date uDate = this.rs.getTimestamp("hiredate"); // �ΰ� ������ ���� �ڹٿ��� �ð��� ��¥ ǥ���ϴ� ǥ��Ŭ���� java.util.Date
				
				// System.out.printf("�Ի��Ͻ�: %1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��", uDate); // 1.���Ĺ��ڷ� ó���ϴ� ���
				
				/*
				String newHiredate = uDate.getYear() + "/" + uDate.getMonth() + "/" + uDate.getDate()
					+ " " + uDate.getHours() + ":" + uDate.getMinutes() + ":" + uDate.getSeconds();   // 2.java.util.Date ���ؼ� ���� �̾Ƽ� ���������� ǥ���ϴ� ���
				*/
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(uDate);
				
				String newHiredate = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + 
						calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.HOUR) + ":" + 
						calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				System.out.println(this.rs.getInt("empno") + "\t" + this.rs.getString("ename") + "\t" + 
						this.rs.getDouble("sal") + "\t" + newHiredate);  //��¥�� �ð��� ó�� ��� , ��¥�� �ð� ���� ����ϰԵȴٸ� �̷�������.
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
		JdbcEmp je = new JdbcEmp();
		je.dynamicSelect();  //
		
		je.closeConnection();
	}
}












