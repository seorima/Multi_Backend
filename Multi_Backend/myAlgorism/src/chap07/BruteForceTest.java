package chap07;

public class BruteForceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "ABABCDEFGHA";
		String pattern = "ABC";
		
		for(int i=0;i<text.length()-pattern.length();i++) {
			boolean isEqual = true;
			
			for(int j=i;j<i+pattern.length();j++) {
				if(text.charAt(j) != pattern.charAt(j-i)) {
					isEqual = false;
					break;
				}
			}
			
			if(isEqual) {
				System.out.println(i+1);
			}
		}
		
	}

}
