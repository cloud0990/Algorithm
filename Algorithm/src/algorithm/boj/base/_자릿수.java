package algorithm.boj.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

나머지연산자로 수의 자릿수 구하기

자릿수를 구하고싶은 자연수 = n

1의자릿수       : n % 10 
10의 자릿수     : n % 100 / 10
100의 자릿수    : n % 1000 / 100
1000의 자릿수   : n % 10000 / 1000
10000의 자릿수  : n % 100000 / 10000
100000의 자릿수 : n % 1000000 / 100000

*/

public class _자릿수 {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		
		//입력초기화
		st = new StringTokenizer(br.readLine());
		
		int b = Integer.parseInt(st.nextToken());
		
		sb.append(a * (b%10)).append("\n")
		  .append(a * (b%100/10)).append("\n")	
		  .append(a * (b/100)).append("\n")	
		  .append(a * b);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}