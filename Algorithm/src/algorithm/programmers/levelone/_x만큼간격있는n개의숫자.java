package algorithm.programmers.levelone;

import java.util.Scanner;

/*

모든 연산시, 자료형 고려
무조건 해당 자료형에 맞춰줘야한다.

short -> int  연산 시, 큰 자료형에 맞춰지기 때문에 따로 downcasting을 하지 않아도 되지만,
int   -> long 연산 시, 결과값을 long형으로 확인하기 위해서 꼭 (long)으로 연산해야한다.

정수형자료형에서 기본 자료형은 int지만, long형과 연산할 일이 생기면 꼭 long으로
int자료형의 영역을 확장해줘야한다.

int  : 4byte
long : 8byte

*/

public class _x만큼간격있는n개의숫자 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		//함수호출
		solution(x,n);
		
		//결과출력
		
	}
	
	public static long[] solution(int x, int n) {
		
		long[] answer = new long[n];
		
		for(int i=0; i<n; i++) {
			answer[i] = (long)x * (i+1);
		}
		
		return answer;
	}
	
	public static long[] solution2(int x, int n) {
		
		long[] answer = new long[n];
		
		for(int i=1; i<=n; i++) {
			
			answer[i-1] = (long)x * i; 
		}
		
		return answer;
	}
	
}