package algorithm.boj.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

1. 문제
두 정수를 입력받고, A/B의 결과를 출력한다

2. 고려사항
소숫점자리 출력을 위해 double형으로 선언한다.
StringBuilder로 결과출력하기

*/

public class _1008_divide {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		double A = Integer.parseInt(st.nextToken());
		double B = Integer.parseInt(st.nextToken());
		
		sb.append(divide(A,B));
		System.out.println(sb);
		
		br.close();
	}//main() end
	
	public static double divide(double A, double B) {
		return A/B;
	}//divide() end
}