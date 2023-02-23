package chap03;

import java.util.Comparator;


class HeightOrderComparator implements Comparator<PhysicalData>  {
	 //--- 키의 오름차순으로 정렬하기 위한 comparator ---//
   
        public int compare(PhysicalData d1, PhysicalData d2) { //두개의 PhysicalData객체를 받아서 구별하는건데....
            return (d1.height > d2.height) ?  1 :
                   (d1.height < d2.height) ? -1 : 0;
        
    }

}
