package algorithm.java.reviewio;

import java.util.Scanner; //Scanner클래스는 util패키지에 포함되어 제공된다

public class JavaIo_Scanner {

	public static void main(String[] args) {
		
		//입력값(문자열, 파일, 입력스트림)을 문자열이나 기본자료형으로 분석한다.
		Scanner sc = new Scanner(System.in);
		
		/*
		구분자  : 입력값을 문자열로 구분 
		 	    기본적인 구분자는 빈 공백(White Space), \n \t...
	
		토큰    : 구분자나 구분패턴으로 구분된 단어
			     구분된 토큰은 next자료형(); 메소드를 사용하여 다른 타입의 값으로 바뀐다.
		*/
		
		int    n  = sc.nextInt();
		double d  = sc.nextDouble();
		String s  = sc.next();     //공백을 문자로 인식불가 -> 공백 전까지만 값을 가져온다
		String s1 = sc.nextLine(); //공백도 문자열로 인식가능
		
		//키보드버퍼 내, Enter값을 제거해야함 (nextLine 쓸 때 유의사항)
		//남아있는 엔터값 삭제
		sc.nextLine();

		//만약, Scanner 객체에 다음 토큰이 있으면 true 리턴
		// hasNext자료형 : 해당자료형에 일치하는 토큰이 남아있을 경우, 토큰을 자료형값으로 반환하는 메소드
		sc.hasNextInt();
		
		
		
		sc.close(); //썼으면 닫음. Scanner객체생성과 동시에 샌드위치코드로 작성해서 사용
		
		
		/*
		 * 
		Scanner vs BufferedReader
		
		Scanner클래스는 입력받은 문자를 정규식으로 검사하고 난 후, 반환
		BufferedReader클래스는 별다른 정규식 없이, readLine()로 한줄씩 읽어올 수 있다
		
		여기서 속도차이 발생
		*/
		
	}
}