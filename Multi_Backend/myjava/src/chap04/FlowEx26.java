package chap04;

class FlowEx26 {
	public static void main(String[] args) { 
		int sum = 0;
		int i   = 0;

		while(sum <= 1000) { // i�� 1�� �������Ѽ� sum�� ��� ���س�����.
			i++;
			sum+=i;
			
		}
		System.out.printf("1���� %d������ ���� %d �Դϴ�",i,sum);
	} // main�� ��
}
