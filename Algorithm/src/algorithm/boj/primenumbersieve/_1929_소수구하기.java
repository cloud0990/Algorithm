package algorithm.boj.primenumbersieve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

1 <= M <= N <= 1,000,000

M과 N은 공백을 두고 주어진다.

결과출력 : 증가하는 순서대로 Enter


소수 : 1과 자기자신 외의 약수가 없다.


-에라토스테네스의 체

가장 먼저 소수를 판별할 범위만큼 배열을 생성 후, 해당하는 값을 넣어준다.

0. 배열을 생성하여 초기화한다.
1. 자기 자신은 건너뛴다.
2. 이미 지워진 수는 건너뛴다.

이후에 하나씩 지워간다.


--> 인덱스 계산하기 편하게 1칸 추가로 배열생성
1은 소수가 아니기 때문에 반복문의 초기식은 2부터 시작할 거임

*/

public class _1929_소수구하기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//M이상 N이하의 범위에 있는 소수 구하기
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		//소수를판별할 범위만큼의 배열 생성
		//인덱스 계산하기 편하게 +1 생성
		//N이하의 범위니까 배열의 크기는 N만큼 설정
		int[] arr = new int[N+1];
		
		//배열 채우기
		//2~N까지 입력받음 -> 위에서 +1칸 더 크게 만들어서 0번째 인덱스는 안 채울 거고, 1은 소수가 아니니까 2부터 입력
		for(int i=2; i<=N; i++) {
			arr[i] = i;
		}
		
		
		//1. 이미 지워진 수는 건너뛴다.
		//2. 배수는 지운다.
		
		//만약에 100까지의 수 중에서 소수를 찾는다면
		//여기서 범위 10까지 지정해놓고
		//밑에서 2*i 초기식, 증감식 k+=i만큼 증가하면서 배수 다 지우니까 100까지 돌기는함
		//여기 조건식에서 100주는 것 보다 제곱근으로 조건식 설정하면 시간복잡도 줄어듬
		for(int i=2; i<=Math.sqrt(N); i++) {
			
			//이미 지워진 수는 건너뜀 -> 0으로 지움
			if(arr[i]==0) continue; //건너 뛰어야하니까 continue써야함 -> break쓰면 그냥 반복문 탈출함
									//조건에 만족해서 continue명령을 수행하게되면 다음 증감식으로 바로 이동
			
			
			//N이하의 배수 지우기
			//        i+i        k=k+i
			for(int k=2*i; k<=N; k+=i) {
				
				arr[k] = 0;
				
			}//for k end
		}//for i end
		
		
		for(int i=M; i<=N; i++) {
			
			//지워지지않고 남은 수가 소수니까 0이 아닌 인덱스값 출력
			if(arr[i]!=0) {
				sb.append(arr[i]).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}