package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysicalDataExam {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner stdIn = new Scanner(System.in);

		final Comparator<PhysicalData> HEIGHT_ORDER = new HeightOrderComparator();
		
		PhysicalData[] x = {                    // 키의 오름차순으로 정렬
	            new PhysicalData("강민하", 162, 0.3),
	            new PhysicalData("이수연", 168, 0.4),
	            new PhysicalData("황지안", 169, 0.8),
	            new PhysicalData("유서범", 171, 1.5),
	            new PhysicalData("김찬우", 173, 0.7),
	            new PhysicalData("장경오", 174, 1.2),
	            new PhysicalData("박준서", 175, 2.0),
	        };
	        System.out.print("키가 몇 cm인 사람을 찾고 있나요?: ");
	        int height = stdIn.nextInt();                // 킷값을 읽어 들임
	        int idx = Arrays.binarySearch(x,new PhysicalData(height),HEIGHT_ORDER);

	        if (idx < 0)
	            System.out.println("그 값의 요소가 없습니다.");
	        else {
	            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	            System.out.println("찾은 데이터: " + x[idx]);
	        }
		
	}

}
