package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

자연수 N (1 ≤ N ≤ 1,000,000)

- Edge Case : int형 (연산해도 20억 안 넘을 듯)

분해합 : N + N을 이루는 각 자릿수의 합

어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라고 한다.
ex)
245의 분해합 = 256(245+2+4+5)
256의 생성자는 245이다.

문제 : M이 주어졌을 때, N의 가장 작은 생성자를 구하시오
단, 생성자가 없을 경우 0을 출력한다.

1. 가장 작은 생성자는 어떻게 구함
2. 생성자가 없는 경우는 어떻게 앎
  -> 각 자릿수의 합을 구할 수 없는 1의 자리숫자일 때?

*/

public class _2231_분해합2 {

	public static void main(String[] args) throws IOException {
		
		//입출력객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//예제입력
		int M = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		while(M>0) {
			
			//탈출조건 설정
			if(sum==M) {
				System.out.println(M);
				break;
			}
			
			if(M==1 && sum != M) {
				System.out.println(0);
				break;
			}
			
			sum += (M%10);
			
			//오른쪽 자리로 한 칸씩 이동
			M /= 10;
			
		}//while end
		
		
	}
}