package chap04;

class FlowEx26 {
	public static void main(String[] args) { 
		int sum = 0;
		int i   = 0;

		while(sum <= 1000) { // i를 1씩 증가시켜서 sum에 계속 더해나간다.
			i++;
			sum+=i;
			
		}
		System.out.printf("1부터 %d까지의 합은 %d 입니다",i,sum);
	} // main의 끝
}
