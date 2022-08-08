package algorithm.boj.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1110_더하기사이클 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//2자리의 자연수 입력
		int n = Integer.parseInt(st.nextToken());
	
		//초기값 저장
		int cycle = n;
		int im    = 0;
		
		//결과(사이클 수)
		int count = 0;
		
		while(true) {
			
			//10의 자릿수 + 1의 자릿수
			im = (cycle%100/10) + (cycle%10);
			
			//위에서 나온 결과의 1의 자릿수를 10의 자릿수로 만든다
			cycle = ((cycle%10)*10) + (im%10);
			
			count++;
			
			//탈출조건
			if(cycle==n) break;
			
		}//while end
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}