package algorithm.programmers.levelone;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

- 풀이방법
forEach 사용해보기

- 조건
arr의 요소가 없는 경우도 고려해야한다.
arr의 요소가 없는 경우의 체크는 arr[i] == null
요소가 있는 경우에 정답 출력


- 문제점
입력받는 값이 없을 경우를 고려하지않고, 무조건 입력값이 들어온다고 생각했다.
이번 문제를 통해서, 입력값에 대한 경우의 조건을 체크하는 방법을 알았다.
다음에 문제 풀 때는, 입력값에 대한 경우도 고려해봐야겠다.


- 추가로 알게된 점

정수형자료형
byte  : 8bit
short : 16bit
int   : 32bit
long  : 64bit

실수형자료형
float  : 32bit
double : 64bit


- 큰 자료형타입에 맞춰서 연산된다.

double + int    = double
float  + double = double


- 피연산자의 타입이 int 보다 작은 타입이면 int로 변환된다.
byte + short = int
char + short = int

*/

public class _평균구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//배열의 크기 입력받기
		int N = sc.nextInt();
		
		//입력받은 값이 0이라면
		if(N==0) {
			
			System.out.println(0);
			
		//배열을 생성할 수 있는 조건에만 배열생성 후, 결과메소드 호출
		//메소드내의 코드는 무조건 전달받은 값이 있는 경우라고 가정하고 코딩
		//입력받는 값의 유무는 main에서 지정
		}else {
			
			//배열 크기 지정
			int[] arr = new int[N];
			
			//배열 입력받기
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			//메소드 호출
			System.out.println(solution1(arr));
			
			//메소드 내에서 결과를 출력한 경우 : forEach
			solution2(arr);
			
			//Arrays.stream 사용
			System.out.println(solution3(arr));
		}
	}
	
	
	//초기 제출 코드
	public static double solution1(int[] arr) {
		
		double answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			answer += arr[i];
		}
		
		return answer/arr.length;
	}//solution1() end
	
	
	//개선 코드
	public static void solution2(int[] arr) {
		
		double answer = 0;
		
		//arr배열의 요소값을 i변수에 담아 하나씩 꺼내온다
		for(int i : arr) {
			answer += i;
		}
		
		System.out.println(answer/arr.length);
		
	}//solution2() end
	
	
	//Arrays.stream().average() 사용
	public static double solution3(int[] arr) {
		
		return  Arrays.stream(arr).average().getAsDouble();
	}//solution2() end
}