package algorithm.boj.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1149_RGB거리_for문 {
	
	public static void main(String[] args) throws IOException {
		
		//입출력객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		//행 : N / 열 : R,G,B
		int[][] arr  = new int[N][3];
	
		//2차원 배열이지만 열의 위치는 R,G,B로 정해져있기 때문에 이중for문으로 입력받지않는다.
		for(int i=0; i<N; i++) {
			
			//입력 초기화
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}//예제 입력완료
		
		for(int i=1; i<N; i++) {
			
			//서로 다른 색상 중에서 최솟값을 찾아서 누적
			//i-1로 0행 인덱스의 누적합을 i(=1)에 누적한다.
			//조건 : 인접한 집끼리는 겹치지않는다.
			arr[i][0] += Math.min( arr[i-1][1], arr[i-1][2] );
			arr[i][1] += Math.min( arr[i-1][0], arr[i-1][2] );
			arr[i][2] += Math.min( arr[i-1][1], arr[i-1][0] );
		}
		
		sb.append(Math.min(Math.min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}