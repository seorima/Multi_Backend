package chap07.pacA;

public class IH {
	
	private int score; //private가 아닌순간 다른곳에서 값이 바뀌어지는 순간 그것을 막을수있는 방법이 없음 -> 필드는 프라이빗으로 함.
	
	IH(int score){
		if(score >= 0 & score <= 100) {
			this.score = score;
		}
		else {
			this.score = 0;
		}
	}
	
	void setScore(int score) {
		if(score >= 0 & score <= 100) {
			this.score = score;
		}
		else {
			this.score = 0;
		}
	}
	
	int getScore() {
		return this.score;  //공개되어야하는 상황에만..!이 getScore를 쓴다?!
	}
	
	
}
