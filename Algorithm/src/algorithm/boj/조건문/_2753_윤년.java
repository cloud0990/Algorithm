package algorithm.boj.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
main메소드는 실행시키는 메소드니까 일단 무슨 값을 넘겨받던 실행할 수 있는 식 구현하고, 메인메소드에서 입력객체 생성해서 넘겨주고, 결과출력

if~else 조건문
&&연산자, ||연산자
*/

public class _2753_윤년 {

	static StringBuilder sb = new StringBuilder();
	
	public static String yunYear(int year) {
		
		if(year%4==0 && (year%100!=0 || year%400==0) ) {
			sb.append("1");
		}else {
			sb.append("0");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int year = Integer.parseInt(st.nextToken());
		
		bw.write(yunYear(year));
		bw.flush();
		bw.close();
		br.close();
	}
}