package algorithm.boj.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_유기농배추_BFS {

	//전역변수
	//1. 방문상태배열
	static boolean[][] visited;
	//2. 방향탐색 dx, dy
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	//3. 예제배열
	static int[][] arr;
	
	//4. 행, 열
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		
		//0. 입출력객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. 테스트케이스 입력받기
		int tc = Integer.parseInt(st.nextToken());
		
		//2. 테스트케이스 반복 시작
		for(int i=0; i<tc; i++) {
			
			//입력초기화
			st = new StringTokenizer(br.readLine());
			
			//3. 행, 열, 인접행렬의 위치 입력받기
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			//4. 예제배열/방문배열 초기화 (여기서 초기화 해야 다음 테스트케이스 때 새로운 값으로 시작가능)
			arr     = new int[M][N];
			visited = new boolean[M][N];
			int answer = 0;
			
			//5. 예제입력받기
			for(int j=0; j<K; j++) {
				
				//입력초기화
				st = new StringTokenizer(br.readLine());
				
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				
				arr[m][n] = 1;
			}//예제입력 완료
			
			//6. 주어진 행과 열만큼 반복하면서 너비우선탐색 (메소드 호출)
			for(int x=0; x<M; x++) {
				for(int y=0; y<N; y++) {
					//아직 방문하지 않은 시작노드이거나, 갈 수 있는 곳이면 방문
					if(!visited[x][y] && arr[x][y]==1) {

						BFS(x, y); //배열의 인덱스를 시작노드로 전달
						//6-1. 탐색할 수 있는 인접행렬위치의 집단 카운트 증가
						answer++;
					}
				}
			}//너비우선탐색 완료
			
			//7. 테스트케이스 한 세트 종료 전, 출력버퍼에 결과저장
			bw.write(answer + "\n");
		}//테스트케이스 종료
		
		
		//출력버퍼 비우기
		bw.flush();
		bw.close();
		br.close();
		
	}//main() end

	
	public static void BFS(int x, int y) {
		
		//1. 큐 생성
		Queue<int[]> q = new LinkedList<>();
		
		//2. 시작노드 방문체크
		visited[x][y] = true;
		
		//3. 시작노드 큐에 추가
		q.add(new int[] {x,y});
		
		//4. 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			
			//4-1. 현재노드 큐에서 꺼내오기
			int nowX = q.peek()[0];
			int nowY = q.peek()[1];
			
			//+) 큐 비우기
			q.poll();
			
			//4-2. 현재노드 방문체크
			visited[nowX][nowY] = true;
			
			//5. 방햠탐색
			for(int i=0; i<4; i++) {
				
				//5-1. 다음방문노드 체크하기
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				//6. 조건성립 시 다음방문노드 탐색
				//6-1. 다음방문노드의 위치가 배열범위 내에 있는가
				if(nextX>=0 && nextY>=0 && nextX<M && nextY<N) {
					//6-2. 방문하지않은 곳인가, 탐색할 수 있는 곳인가
					if(!visited[nextX][nextY] && arr[nextX][nextY]==1) {
						
						//7. 다음방문노드 방문체크
						visited[nextX][nextY] = true;	
						
						//7-1. 다음방문노드 큐에 추가
						q.add(new int[] {nextX, nextY});
					}
				}
				
			}//for end : 방향탐색 종료
			
		}//while end
	}//BFS() end
}