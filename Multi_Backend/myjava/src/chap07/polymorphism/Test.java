package chap07.polymorphism;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	
		Parent p = new Child();  //�̹����� Ȯ���� ���� ����? 
		//p�� ParentŸ�� parent���� method b ����...
		//�ڽ��� child�ν��Ͻ��� ���������� methodB()�� ����ϵ��� �� �� ������? == �� �ȵ˴ϴ�.
		p.methodA();
		// p.methodB(); //->�� ����� �� ������?
		
		Child c = (Child)p; //����� ����ȯ

*/
		
		//======
	/*			
				 
		Parent p = new Parent();
		Child c = (Child)p;
		c.methodA();
		
		
		
		//�ڽ�Ÿ���� �ν��Ͻ��� �θ�Ÿ���� ���۷����� ����Ű�� ����?
		//�ڽĸ��� ����� ���� �θ��ν��Ͻ��� �ڽ��� ����Ű�ԵǸ�... �� ����?
		
		// -. �ڽ�Ŭ���� Ÿ���� ���۷����� �θ�Ŭ���� Ÿ���� �ν��Ͻ��� ����ų �� ����
		 */
		
		
		//======
		
		/*
		  
		  Parent p = (Parent)o; // ��� ���谡 �ƴ� �ٸ� Ŭ������ Ŭ���� ����ȯ�� ����� �ƴϴ�.
		 */
		
		//======
		/*
		  Parent p = new Parent();
		Child c = new Child();
		Other o = new Other();
		
		Object obj;
		obj = p;
		obj = c;
		obj = o;
		 */
		
		
		//ObjectŬ���� Ÿ���� ���۷����� ��� �ڹ� Ŭ������ �ν��Ͻ��� ����ų �� �ִ�
		// ������ ������ �ִ�? ����ų �� ������ ��������� ���ٳ׿�
		//��� ������ �ذ��� �� ������?
		/*
		 
		 */
		
		Object obj;
		obj = new Parent();
		((Parent)obj).methodA();
		
		obj = new Child();
		((Child)obj).methodB();
		
		obj = new Other();
		((Other)obj).methodC();
		
		
		

	}

}
