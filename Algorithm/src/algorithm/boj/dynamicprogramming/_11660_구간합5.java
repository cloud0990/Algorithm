package algorithm.boj.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660_구간합5 {

	public static void main(String[] args) throws Exception {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //배열의 크기
		int m = Integer.parseInt(st.nextToken()); //합을 구해야할 수
		
		int [][] arr  = new int[n+1][n+1];
		int [][] nArr = new int[n+1][n+1]; //누적합 담을 배열

		//배열 입력받기
		for(int i=1; i<arr.length; i++) { //행 채우기
			
			st = new StringTokenizer(br.readLine(), "");
			
			for(int k=1; k<arr[i].length; k++) { //열 채우기
				
				arr[i][k] = Integer.parseInt(st.nextToken());
				
				//누적합 배열에 넣기
				nArr[i][k] = nArr[i][k-1] + nArr[i-1][k] - nArr[i-1][k-1] + arr[i][k];
			}
		}
		
		
		
		//구간 누적합 구하기
		for(int i=0; i<m; i++) { //m번 만큼 돈다
			
			st = new StringTokenizer(br.readLine(), " ");
			
			//구간1
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			//구간2
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println( nArr[x2][y2] - nArr[x2][y1-1] - nArr[x1-1][y2] + nArr[x1-1][y1-1] );
		}
		
		
	
	}
}