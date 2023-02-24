package chap07.pacB;

import chap07.pacA.Parent; //Parent 클래스가 default로 선언되어있어서(앞에 아무것도없는 상황) public 으로 바꾸어 주어야함

public class Child extends Parent {
	
	int methodC() {
		return methodA(); //protected된 methodA를 상속된 자식을 통해서 상속아닌 클래스에 보이기 위한 방법.
	}

}
