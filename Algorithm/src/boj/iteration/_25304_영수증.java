package boj.iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/*

260000
4
20000 5
30000 2
10000 6
5000 8

 */


public class _25304_영수증 {

	public static void main(String[] args) throws Exception{

		//입출력 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		//예제 입력
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for(int i=0; i<N; i++) {
			int a = 0;
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			result += a * Integer.parseInt(st.nextToken());
		}
		
//		int[] a = new int[N];
//		int[] b = new int[N];
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//			a[i] = Integer.parseInt(st.nextToken());
//			b[i] = Integer.parseInt(st.nextToken());
//		}
//		for(int i=0; i<N; i++) {
//			result += a[i] * b[i];
//		}

		if(result == X) {
			sb.append("Yes");
		}else {
			sb.append("No");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}