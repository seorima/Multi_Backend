package chap06;

public class Tv {

	String color;
	boolean power;
	int channel;
	
	void setPower() {
		power = !power;
	}
	void channerUp() {
		channel++;
	}
	void channerDown() {
		channel--;
	}
}
