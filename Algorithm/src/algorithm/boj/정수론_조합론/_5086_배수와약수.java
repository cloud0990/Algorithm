package algorithm.boj.정수론_조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5086_배수와약수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder   sb = new StringBuilder();
		StringTokenizer st;
		
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			//탈출조건의 순서는, A와 B를 입력받고 조건문 들어가기 전에 바로 확인해줘야 필요없는 코드수행을 하지않는다.
			//오류가 발생했던 이유는, 0끼리의 나머지/몫 연산은 안 되기 때문이다.
			if(A==0 && B==0) break;
			
			//A가 B의 약수인 경우
			if(B%A==0) {
				sb.append("factor").append("\n");
			
			//A가 B의 배수인 경우
			}else if(A%B==0) {
				sb.append("multiple").append("\n");
			
			//둘 다 아닌 경우
			}else {
				sb.append("neither").append("\n");
			}
			
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}