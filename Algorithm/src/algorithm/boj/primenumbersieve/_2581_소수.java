package algorithm.boj.primenumbersieve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2581_소수 {

	//전역변수
	//결과출력 객체
	static StringBuilder  sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException {
		
		//입출력 객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//M, N입력받기
		int M = Integer.parseInt(st.nextToken());
		
		st    = new StringTokenizer(br.readLine()); //입력초기화
		int N = Integer.parseInt(st.nextToken());
		
		//소수배열 초기화
		int[] arr = new int[10001];
		
		//소수찾기 메소드 호출
		primeNumberSeive(arr);
		
		//결과 메소드 호출 : find_primeNumber
		//인자값으로 M N 을 넘긴다.
		find_primeNumber(M,N,arr);
	
		//사용한 자원 종료
		br.close();

	}//main() end
	
	//primNumberSeive() -> 소수찾기 메소드
	public static void primeNumberSeive(int[] arr) {
		
		//소수배열 1로 초기화
		//toIndex에 설정한 값 전까지만 초기화되기때문에 10001로 설정
		Arrays.fill(arr, 2, 10001, 1);
		
		//알고싶은 범위의 제곱근까지만 탐색한다.
		for(int i=2; i<=Math.sqrt(10000); i++) {
			
			//이미 지워진 수는 건너뛴다 -> 증감식으로 이동
			if(arr[i]==0) continue; 
			
			for(int k=i+i; k<=10000; k+=i) {
				
				//배수는 지운다
				arr[k] = 0;
			}
		}
	}//end
	
	
	//find_primNumber(M, N) -> M과 N 사이의 소수의합 + 소수 중 최소값 찾기 메소드
	public static void find_primeNumber(int M, int N, int[] arr) throws IOException {
		
		//최솟값을 찾는 범위가 양수이기 때문에 10000으로 초기화
		//최솟값이 0이면, 당연히 min이 제일 작기 때문에 원하는 결과를 확인할 수 없다.
		//주어진 수의 최대범위로 초기화한다.
		//+) Integer.MIN_VALUE -> int형의 최솟값
		int min = 10000;
		
		//소수를 누적하기위한 변수
		int sum = 0;
		
		//for문 i=M , i<=N까지 반복
		for(int i=M; i<=N; i++) {
			
			//소수배열의 해당 인덱스값이 0이 아니면, 누적 (지워지지않았다면 / 소수라면 arr[i]==1)
			if(arr[i]!=0) {
			
				sum += i;
				
				//최소값 찾기 -> Math.min() 사용
				min = Math.min(min, i);
			}
		}//for end
		
		//소수가 없다면 -1 출력
		if(sum==0) {
			sb.append("-1");
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		
		}else {
			//메소드 내에서 결과출력
			sb.append(sum).append("\n").append(min);
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		}
		
	}//end

}