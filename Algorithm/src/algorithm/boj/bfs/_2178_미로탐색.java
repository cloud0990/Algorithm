package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

- 입력값 제외 필요한 변수

1. 방문처리 배열     : boolean
2. 4방향 탐색 배열   : dx, dy
3. 다음 갈 좌표 변수 : nextX, nextY
4. 현재 좌표 배열    : now (Queue의 제네릭타입이 int[]이어서 배열로 선언)


- 메소드
void BFS(N, M, arr)

*/

public class _2178_미로탐색 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//예제입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		//예제 배열 입력
		for(int i=0; i<arr.length; i++) {
			
			//한 줄씩 입력받기
			String str = br.readLine();
			
			for(int k=0; k<arr[i].length; k++) {
				arr[i][k] = Integer.valueOf(str.charAt(k)-'0');
			}
			
		}//예제입력완료
		
		//함수 호출
		BFS(N, M, arr);
		
		//결과출력 : 경로체크 후 마지막에 도착한 곳의 인덱스값 출력
		System.out.print(arr[N-1][M-1]);
	}
	
	
	
	public static void BFS(int N, int M, int[][] arr) {
		
		//Queue 선언
		Queue<int[]> q = new LinkedList<>();

		//4방향상태
		int[] x = {-1, 1, 0, 0}; //행
		int[] y = {0, 0, -1, 1}; //열
		
		//방문여부상태
		boolean[][] visited = new boolean[N][M];
		
		//시작지점 방문처리
		visited[0][0] = true;
		
		//시작지점 추가
		q.add( new int[] {0,0} );

			
		while(!q.isEmpty()) {
		
			//현재좌표
			//q에 첫 번째로 저장된 값을 대입한다 : now[0] 행 / now[1] 열
			int[] now = q.poll();
			
			//4방향 탐색
			for(int i=0; i<4; i++) {
				
				//1. 다음으로 갈 좌표에, 현재값과 이동할 값을 넣는다
				int nextX = now[0] + x[i]; //행
				int nextY = now[1] + y[i]; //열
				
				//2. 배열의 범위를 벗어난 경우 중단
				if( nextX<0 || nextX>=N || nextY<0 || nextY>=M )
					continue;
				
				//2-1.이미 방문했던 곳이거나, 갈 수 없는 곳인 경우 중단
				if( visited[nextX][nextY]==true || arr[nextX][nextY]==0 )
					continue;
				
				//3. 다음 갈 좌표 큐에 추가
				q.add(new int[] {nextX, nextY});
				
				//4. 방문체크
				visited[nextX][nextY] = true;
				
				//5. 다음 갈 좌표에, 현재좌표의 인덱스값 + 1
				arr[nextX][nextY] = arr[now[0]][now[1]] + 1;
				
			}//for end
		}//while end
	}//end
}