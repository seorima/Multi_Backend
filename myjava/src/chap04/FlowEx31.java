package chap04;

class FlowEx31 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i <= 100;i++) {
			if (i%3==0) {
				continue;
				}
			sum+=i;
		}
		
		System.out.println("1부터 100 사이의 값 중 3의 배수의 값들의 합은 " +sum + "입니다");
	}
}
