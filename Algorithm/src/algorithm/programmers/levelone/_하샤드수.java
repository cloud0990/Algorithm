package algorithm.programmers.levelone;

import java.util.Scanner;

public class _하샤드수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		//결과출력
		System.out.println(solution(x));
	}
	
	
	public static boolean solution(int x) {
		
		//입력받은 정수를 String형으로 변환한다
		String x_str = String.valueOf(x);
		
		//숫자의 자릿수 더하기
		int sum = 0;
		
		for(int i=0; i<x_str.length(); i++) {
			
			//x_str을 Integer형으로 변환하여 자릿수의 합을 구한다
			//주의할 점 : charAt의 아스키코드 값에서 원하는 정수값을 확인하기위해 0 / 48을 빼야한다
			sum += Integer.valueOf(x_str.charAt(i)-'0');
		}
		
		boolean answer = false;
		
		if(x%sum==0) {
			answer = true;
		}else {
			answer = false;
		}
		
		return answer;
	}
}