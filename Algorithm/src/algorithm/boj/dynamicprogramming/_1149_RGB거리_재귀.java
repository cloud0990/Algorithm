package algorithm.boj.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1149_RGB거리_재귀 {
	
	//전역변수,객체
	static int[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//입출력 객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		//               3 : R(0), G(1), B(2) 순서
		arr = new int[N][3];
		
		//예제입력 : 열은 정해져있기 때문에 이중for문으로 입력받지않는다.
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}//예제입력 완료		
		
		//1행에 0행의 값 누적시킬 거여서 시작은 1 전달
		dfs(1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int depth) {
		
		//depth가 N과 같아지면, 결과 저장 후 종료
		if(depth==N) {
			
			//N-1(마지막행)에는 총 누적합이 담겨있기때문에 그 중에서 가장 최솟값을 찾아 저장한다.
			sb.append(Math.min(Math.min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));
			
			return;
		}
		
		//탈출 조건에 걸리지않았으면 아래 코드 수행
		//누적 조건 : 인접한 곳은 누적하지않는다.
		//첫 depth-1의 값 = 0 (0행의 엇갈린 R,G,B 중에서 최솟값을 찾아 누적)
		arr[depth][0] += Math.min(arr[depth-1][1], arr[depth-1][2]);
		arr[depth][1] += Math.min(arr[depth-1][0], arr[depth-1][2]);
		arr[depth][2] += Math.min(arr[depth-1][0], arr[depth-1][1]);
		
		//depth 1증가한 값 전달해서 재귀호출
		dfs(depth+1);
		
	}//dfs() end

}