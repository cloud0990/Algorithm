package algorithm.boj.기본수학1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1712_손익분기점 {

	public static void main(String[] args) throws IOException {
		
		//입출력객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//A B C 입력받기
		long A = Long.parseLong(st.nextToken()); //고정비용
		long B = Long.parseLong(st.nextToken()); //가변비용
		long C = Long.parseLong(st.nextToken()); //판매비용
		
		//메소드 호출 + 결과출력
		sb.append(break_even_point2(A,B,C));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}//main() end
	
	
	public static long break_even_point2(long A, long B, long C) {
		
		
		if(C-B<=0) {
			return -1;
		}else {
			
			return A/(C-B)+1;
			
		}
	}
	
	
	//손익분기점 메소드
	public static long break_even_point(long A, long B, long C) {
		
		long cnt     = 1; 
		long profit  = 0;
		long mutable = 0;
		
		
		while(true) {
			
			//탈출조건
			if( A+mutable < profit ) return cnt-1; //밑에서 추가적으로 cnt++하고 내려왔기 때문에 -1해서 출력
			
			if( A+mutable >= profit ) {

				mutable = B * cnt;
				profit  = C * cnt;
				
				cnt++;
			}
		}//while end
		
	}//profit() end
	
}