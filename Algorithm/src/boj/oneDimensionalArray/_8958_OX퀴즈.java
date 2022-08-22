package boj.oneDimensionalArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _8958_OX퀴즈 {
	
	public static void main(String[] args) throws Exception {
		//입출력객체
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		//테스트케이스 입력받기
		int tc = Integer.parseInt(st.nextToken());
		//입력 초기화
		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			String text = st.nextToken();
			Character[] arr = new Character[text.length()];
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = text.charAt(j);
			}
			
			int cnt = 0;
			int sum = 0;
			for(int k=1; k<=arr.length; k++) {
				if("O".equals(arr[k-1])) {
					if("X".equals(arr[k])) {
						sum += cnt;
						cnt = 0;
						continue;	
					}// end : X if
					cnt += 1;
				}// end : O if
			}//end : for
			System.out.println(sum);
		}//end : for tc
		
	}// end : main
}