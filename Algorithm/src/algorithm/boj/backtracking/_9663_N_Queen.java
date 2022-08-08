package algorithm.boj.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

N-Queen 규칙
퀸은 상하좌우, 대각선 4방향으로 거리 제한 없이 이동할 수 있는 기물이다.
즉, 서로의 퀸이 움직이는 경로에 다른 퀸이 있어서는 안 된다.


1. 퀸을 놓을 수 있는 위치 (상하좌우, 대각선) -> 이동방향 체크
배열의 범위를 초과하지 않으면 방문한다는 조건 만들기

상 : 행-- / 열 그대로 있음
하 : 행++ / 열 그대로 있음
좌 : 행 그대로 있음 / 열--
우 : 행 그대로 있음 / 열++

대각선
상
좌 : 행--/열--
우 : 행--/열++

하
좌 : 행++/열--
우 : 행++/열++


2. 배열의 모든 요소가 다 채워지면종료 -> dfs/depth==N

3. 방문했던 곳 원상복구해야함


-- 퀸을 배치할 수 있는지/없는지 확인하는 메소드
*/

public class _9663_N_Queen {
	
	//전역변수 객체 생성
	static int[] arr; //퀸을 배치할 배열
	static int   N;   //배열의 크기
	static int   cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		//입출력 객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//예제입력받기
		N = Integer.parseInt(st.nextToken());
		
		//N만큼 배열 초기화
		arr = new int[N];
		
		//dfs 함수 호출
		dfs(0);
		
		
		//결과출력
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static void dfs(int depth) {
		
		//탈출 조건 : 모든 퀸이 배치된다면 cnt 증가 후 종료
		//현재탐색 중인 행과 N이 같아진다는 것은, N까지의 모든 퀸이 배치가 완료된 것이다.
		if(depth==N) {
			
			cnt++;
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			//현재 탐색 중인 행에 값 추가
			arr[depth] = i;
			
			//갈 수 있는 곳이라면 다음 행에 퀸 배치
			if(possibility(depth)) { //possibility==true
				dfs(depth+1);
			}
			
		}//for end
		
	}//dfs end
	
	
	//갈 수 있는 곳인지 체크하는 메소드
	public static boolean possibility(int col) {
		
		for(int i=0; i<col; i++) {
			
			//현재 위치에 퀸이 있다면 fasle
			if(arr[col]==arr[i]) return false;
			
			//퀸이 대각선상에 놓여있을 경우 false
			if( (col-i) == Math.abs(arr[i]-arr[col]) ) return false;
			
		}//for end
		
		//위의 조건에 걸리지않는다면 배치할 수 있는 곳, true 반환
		return true;
	}
	
}