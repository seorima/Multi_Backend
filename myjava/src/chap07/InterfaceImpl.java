package chap07;

import chap07.pacA.InterfaceA;

public class InterfaceImpl implements InterfaceB {
	
	public void methodA() {
		System.out.println("InterfaceA.methodA() ������");
	}
	
	public void methodB() {
		System.out.println("InterfaceB.methodB() ������");
	}

}
