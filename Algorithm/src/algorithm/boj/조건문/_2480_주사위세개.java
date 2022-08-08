package algorithm.boj.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2480_주사위세개 {
	
	//최대값 구하기
	public static int max(int a, int b, int c) {

		int max = Math.max(Math.max(a, b), c);
		
		return max;
	}
	
	//같은 수가 2개인 경우의 같은 수 구하기
	public static int same(int a, int b, int c) {
		
		int same = 0;
		
		if(a==b || a==c) {
			same = a;
		}else if(b==c) {
			same = b;
		}
		
		return same;
	}
	
	//결과출력 함수
	public static int reward(int a, int b, int c) {
		
		int answer = 0;
		
		//같은 수가 3개인 경우
		if( (a==b) && (a==c) && (b==c) ) {
			answer = 10000 + (a*1000);
	
		//같은 수가 2개인 경우
		}else if( a==b || b==c || a==c ) {
			answer = 1000 + (same(a,b,c)*100);
		}else {
			answer = max(a,b,c)*100;
		}
		return answer;
	}//reward() end
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		//결과출력
		sb.append(reward(a,b,c));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}