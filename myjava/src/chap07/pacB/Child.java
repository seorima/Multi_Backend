package chap07.pacB;

import chap07.pacA.Parent; //Parent Ŭ������ default�� ����Ǿ��־(�տ� �ƹ��͵����� ��Ȳ) public ���� �ٲپ� �־����

public class Child extends Parent {
	
	int methodC() {
		return methodA(); //protected�� methodA�� ��ӵ� �ڽ��� ���ؼ� ��Ӿƴ� Ŭ������ ���̱� ���� ���.
	}

}
