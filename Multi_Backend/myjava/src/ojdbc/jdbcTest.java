package ojdbc;

public class jdbcTest {

	private String username;
	private String email; //�ܺο��� ������ �� ����� , �����ڸ� ���ؼ� �ʱ�ȭ ���� ������ �ʱ�ȭ�� username�� emiail�� ������ �մ� ����� ����
	
	public jdbcTest(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public String getUsername() {
		return this.username; //username�� ���� getter �̰����ؼ� ���� �д´�
	}
	
	public String getEmail() {
		return this.email; //email�� ���� getter �̰����ؼ� ���� �д´�
		
		
	}
}//jdbc���� �޾Ƶ��� ���̺� ������ ��ü�� �������ϰ� ��ü�� ������ ���޿����� ����ϰڴ�.
//������ ������Ʈ, ������ ������Ʈ 


//�ϳ��� �� ������ ��ü��,,
