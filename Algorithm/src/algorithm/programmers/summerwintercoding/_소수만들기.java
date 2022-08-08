package algorithm.programmers.summerwintercoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

처음에는 소수만들기와 찾기를 하나의 메소드에서 모두 진행했지만,
소수를 찾으려고 메소드를 호출하면 호출할 때마다 전체 소수를 다시 찾는 불필요한 반복문이 돈다는 것을 알게되었다.
그래서 전체소수배열은 1회만 생성하고, 이미 만들어진 소수의 배열과 누적합을 비교만 할 수 있게 기능별로 모듈화했다.

*/

public class _소수만들기 {

	//소수배열 전역변수
	static int[] prime_arr;
	
	public static void main(String[] args) throws IOException {
		
		//1. 소수 배열 생성 
		prime_arr = new int[10001];
		
		//1-1. 1로 초기화
		Arrays.fill(prime_arr, 1);
		
		
		//2. 입출력 객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		
		//3. 예제입력
		//3-1. 배열의 크기 입력받기
		int N = Integer.parseInt(st.nextToken());
		
		//3-2. 배열 생성
		int[] nums = new int[N];
		
		//3-3. 배열 초기화
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.valueOf(st.nextToken());
		}//예제입력 완료
		
		//정답 출력
		int cnt = 0;
		
		//소수찾기 메소드 호출 -> 소수는 한 번만 찾아놓고 찾아진 소수로 세 수의 합의 소수여부를 판단한다.
		primeNumberSeive(prime_arr);
		
		//4. 3개 요소의 합 구해서 make_primeNo 호출
		for(int i=0; i<nums.length-2; i++) {
			for(int k=i+1; k<nums.length-1; k++) {
				for(int j=k+1; j<nums.length; j++) {
					
					//sum변수는 반복문 1회마다 초기화한다.
					int sum = nums[i] + nums[k] + nums[j];
					
					//소수만들기 메소드의 반환값이 true면, 카운트 증가
					if(make_primeNo(sum)) cnt++;
					
				}//j end
			}//k end
		}//for i end
		
		
		//5. 결과출력
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}//main() end
	
	
	//소수찾기 메소드
	public static void primeNumberSeive(int[] prime_arr) {
		
		//찾을 수의 제곱근까지만 반복한다.
		for(int i=2; i<=Math.sqrt(10000); i++) {
			
			//이미 지워진 수는 건너뛴다.
			if(prime_arr[i] == 0) continue;
			
			//2의 배수는 지운다.
			for(int k=i+i; k<=10000; k+=i) {
				
				prime_arr[k] = 0;
			}
		}
	}//primeNumberSeive() end
	
	
	//소수만들기 cnt 메소드
	public static boolean make_primeNo(int sum) {
		
		//인자값으로 전달된 누적합이 소수이면 true 반환
		for(int i=2; i<prime_arr.length; i++) {
			
			//prime_arr의 값이 지워지지않았다면 소수이다.
			if(prime_arr[i]!=0) {
				//각각 다른 수의 합이지만, 합의 결과가 같은값일 수 있기 때문에 체크된 소수는 지우지않는다.
				//prime_arr의 인덱스값이 소수인 경우에만 들어오기때문에 반복문의 i변수는 prime_arr의 인덱스와 같다.
				if(i==sum) return true;
			}
		}
		return false;	
	}//make_primeNo() end
	
}