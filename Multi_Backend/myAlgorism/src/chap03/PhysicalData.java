package chap03;

import java.util.Comparator;


public class PhysicalData {

	
        String name;          // 이름
        int    height;        // 키
        double vision;        // 시력

        PhysicalData(int height){
        	this(null,height,0.0);
        }
        
        //--- 생성자(constructor) ---//
        PhysicalData(String name, int height, double vision) {
            this.name = name;  
            this.height = height;  
            this.vision = vision;
        }
        //생성자 두개 만든이유는 처음에 메인에서 신체정보를 같는 정보를 적어. 처음생성ㅅ자는 키값만 보려고 다르건ㄱ 기본값받는..어어 그래서 그거 받고, ...

        //--- 문자열로 만들어 반환하는 메서드 --//
        public String toString() {
            return name + " " + height + " " + vision;
        }

       

}
