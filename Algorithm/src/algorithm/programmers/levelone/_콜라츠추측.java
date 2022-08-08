package algorithm.programmers.levelone;

import java.util.Scanner;

/*

:::연산 후의 자료형 고려:::

- 범위
1 <= n < 8000000

정해진 범위만 봤을 때는 int자료형의 크기를 벗어나지않지만,
num이 홀수인 경우 3을 곱해야하기 때문에 최악의 경우에는 벗어날 수 있다.

그래서 전달받은 num을 long형으로 영역확장 후 연산해야한다.


- if~else로 쓸 수 있는 조건은 삼항연산자로도 가능하다.
삼항연산자 활용해보기

*/

public class _콜라츠추측 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//수 입력받기
		int num = sc.nextInt();
		
		System.out.println(solution1(num));
		System.out.println(solution2(num));
		
	}
	
	//초기 제출식
	public static int solution1(int num) {
		
		int answer = 0;
		int cycle  = 0;
		
		//탈출조건 설정
		while(true) {
			
			cycle++;
			
			//탈출조건
			if(cycle==500) break;
			if(num==1)     break;
			
			//1-1. num이 짝수인 경우
			if(num%2==0) {
				
				num = num / 2;
				answer++;
			//1-2. num이 홀수인 경우
			}else if(num%2==1) {
				num = (num*3) + 1;
				answer++;
			} 
		}//while end
		
		if(cycle>=500) {
			return -1;
		}else {
			return answer;
		}
	}//solution1() end
	
	
	
	//개선코드
	public static int solution2(int num) {
		
		long n = (long)num;
		
		//반복의 제한은 500회
		for(int answer=0; answer<500; answer++) {
			
			//탈출조건
			if(n==1) return answer;
			
			n = (n%2==0) ? n/2 : (n*3)+1;
			
		}//for end
		
		//500회 반복할 때까지 (num==1)을 만족하지 못헀을 경우
		return -1;
		
	}
}