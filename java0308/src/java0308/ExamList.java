package java0308;

import java.util.ArrayList;

public class ExamList {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        //<> 안에 들어가는데 어떤 데이터 타입을 넣을지 정하는 곳
        al.add("abc");
        al.add("cde");
        al.add("xyz");
        System.out.println( al.size() );  //3 -> 3개의 문자열을 저장
        
		//***타입 변환 필요***
//		String e = (String)al.get(3); //오류 발생
        String e = al.get(2);		 //추출 - 인덱스 2번째 값
        System.out.println(e);
        
        String r = al.remove(1);	//값 삭제 - 인덱스 1번째 값
        System.out.println("지워진 값="+r);
        System.out.println(al.size());
        System.out.println( al );
        al.add(0, r);
        System.out.println( al );
    }
}
