package chap07;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1,s2,s3;
		//s1 = new SingletonTest(); Singleton �����ڰ� private�� ����Ǿ� �־ �ܺο��� ����������
		
		s1 = Singleton.getInstance();
		s2 = Singleton.getInstance();
		s3 = Singleton.getInstance();
		
		if(s1 == s2) { //�ϳ��� ���۷����� �ΰ��� �ν��Ͻ��� ����ų��
			System.out.println("s1�� s2�� �ϳ��� �ν��Ͻ��� ����Ű�� �ֽ��ϴ�");
			
		}
		if(s2 == s3) { //�ϳ��� ���۷����� �ΰ��� �ν��Ͻ��� ����ų��
			System.out.println("s3�� s2�� �ϳ��� �ν��Ͻ��� ����Ű�� �ֽ��ϴ�");
			
		}
		
		
	}

}

//�ν��Ͻ��� �ϳ��� ����� �ʿ��� ������ �ּҰ��� �� �ش�. �׷��� ��������� �ʿ��Ҷ� �ּҰ��� �������شٳ׿�
//�����ʹ� �����Ǿ� �ְ� 