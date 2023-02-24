package chap07;

import chap07.pacA.InterfaceA;

public interface InterfaceB extends InterfaceA {

	public static final int num = 1234;
	
	void methodB();
	
	default void dafaultMethod() {
		System.out.println("InterfaceB.dafaultMethod() »£√‚!");
		System.out.println("num: " + num);
		
	}
}
