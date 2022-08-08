package algorithm.boj.primenumbersieve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

-소수
2~N의 자연수를, 자기 자신보다 작은 수로 나눴을 때 나머지가 0이 아닌 수

-에라토스테네스의 체
가장 먼저 소수를 판별할 범위만큼 배열을 생성 후, 해당하는 값을 넣어준다.

0. 배열을 생성하여 초기화한다.
1. 자기 자신은 건너뛴다.
2. 이미 지워진 수는 건너뛴다.

이후에 하나씩 지워간다.


주어진 수들 중 소수의 개수 출력


1. boolean형 배열사용
2. 입력받은 su의 제곱근까지의 배수만 지우면 됨


*/



public class _1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		//소수를 판별할 범위만큼의 배열 생성
		int[] arr = new int[1001];
		
		
		//배열 초기화
		for(int i=2; i<arr.length; i++) {
			arr[i] = 1;
		}
		
		
		//소수 구하기
		for(int i=2; i<=(int)Math.sqrt(1000); i++) {
			
			//이미 지워진 값은 건너뛴다
			if(arr[i]==0) continue;
			
			//배수를 1로 지우기
			for(int k=2*i; k<=1000; k+=i) {
				
				arr[k] = 0;
			}
		}//for end
		
		
		//결과출력 변수선언
		int answer = 0;
		
		//입력초기화
		st = new StringTokenizer(br.readLine());
		
		//N만큼 반복
		for(int i=0; i<N; i++) {
			
			//입력은 받지만 저장은 하지않음 cf) 패션왕신해빈
			int su = Integer.parseInt(st.nextToken());
			
			if(arr[su]==1) {
				answer++;
			}
		}
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}