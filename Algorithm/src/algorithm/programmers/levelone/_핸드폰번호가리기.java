package algorithm.programmers.levelone;

import java.util.Scanner;

public class _핸드폰번호가리기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//휴대폰번호 입력받기
		String phone_number = sc.nextLine();
		
		//결과출력(메소드호출)
		System.out.println(solution(phone_number));
		System.out.println(solution2(phone_number));
		
	}
	
	
	//substring() 사용
	public static String solution(String phone_number) {
		
		StringBuilder sb = new StringBuilder();
		
		//4자리 제외한만큼 * 추가
		for(int i=0; i<phone_number.length()-4; i++) {
			sb.append("*");
		}
		
		int n = phone_number.length();
		
		//휴대폰번호의 뒷자리 4자리 자르기
		sb.append(phone_number.substring(n-4, n));
		
		String answer = sb.toString();
		
		return answer;
	}

	
	//char[] 사용
	public static String solution2(String phone_number) {
		
		//휴대폰번호 char배열에 문자로 담기
		char[] pN = phone_number.toCharArray();
		
		//배열 안에 담긴 값을 뒤 4자리 제외하고 *으로 초기화
		for(int i=0; i<pN.length-4; i++) {
			pN[i] = '*';
		}
		
		//char[] -> String객체로 변환
		String answer = String.valueOf(pN);
		
		return answer;
	}

}