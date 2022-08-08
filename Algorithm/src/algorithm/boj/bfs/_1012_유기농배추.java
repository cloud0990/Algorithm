package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_유기농배추{
	
	//전역변수
	
	//1. 방문배열
	static boolean[][] visited;
	
	//2. 4방향 탐색 범위 배열 
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	//3. 주어질 배열
	static int[][] arr;
	
	//4. 결과출력 변수
	static int answer;
	
	//5. 예제로 입력받을 변수들
	static int M,N,K;
	
	
	public static void main(String[] args) throws IOException {
		
		//입출력객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//예제입력받기
		int tc = Integer.parseInt(st.nextToken());
		
		//예제입력
		for(int i=0; i<tc; i++) {

			st = new StringTokenizer(br.readLine());
			
			//반복문의 인덱스를 인자값으로 전달한다.
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			//입력받은 M과 N만큼 arr / visited 배열 초기화
			arr     = new int[M][N];
			visited = new boolean[M][N];
			answer  = 0;
			
			for(int j=0; j<K; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				
				arr[m][n] = 1;
			}//for k end
			
			
			for(int x=0; x<M; x++) {
				
				for(int y=0; y<N; y++) {
					
					//방문할 수 있는 곳만 방문
					if(!visited[x][y] && arr[x][y]==1) {
						
						//BFS메소드 호출
						BFS(x,y);
						//결과 1씩 증가
						answer++;
					}
				}//for y end
			}//for x end
		
			
			//출력버퍼에 저장
			bw.write(answer + "\n");
		}//tc 종료
		
		//출력
		bw.flush();
		bw.close();
		br.close();
	}//main() end
	
	
	
	public static void BFS(int x, int y) {
		
		//1. 큐 생성
		Queue<int[]> q = new LinkedList<>();
		
		//2. 현재노드 방문체크
		visited[x][y] = true;
		
		//3. 현재노드 큐에 추가
		q.add(new int[] {x,y});
		
		//3. 결과출력 변수 초기화
		//answer = 0;
		
		//4. 반복시작
		while(!q.isEmpty()) {
			
			//5. 현재정점 큐에서 꺼내오기
			//poll() -> 큐의 맨 앞에있는 값을 반환 후 삭제한다.
			int[] now = q.poll();
			
			/*
			 	- peek() -> 큐의 맨 앞에 있는 값 확인하기
				int nowX = q.peek()[0];
				int nowY = q.peek()[1];
				
				q.poll();
				
				peek()를 사용할 거면, 꺼내서 확인 후, poll()로 값을 삭제해야한다.
				
			*/
			
			//현재노드 방문체크
			visited[now[0]][now[1]] = true;
			//visited[nowX][nowY] = true;
			
			//6. 반복문을 통해 다음으로 갈 노드의 위치 구하기
			for(int i=0; i<4; i++) {
				
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				//int nextX = nowX + dx[i];
				//int nextY = nowY + dy[i];
				
				//7. 방문할 수 있는 곳인지 체크
				//7-1. 배열의 범위 내에 있는지
				if(nextX>=0 && nextY>=0 && nextX<M && nextY<N) {
					
					//7-2. 아직 방문하지않았으며, 갈 수 있는 곳인지
					if(!visited[nextX][nextY] && arr[nextX][nextY]==1) {
						
						//8. 다음방문노드 방문체크
						visited[nextX][nextY] = true;
						
						//9. 다음방문노드 큐에 추가
						q.add(new int[] {nextX, nextY});
					}
				}
				
			}
		}//while end
		
	}//BFS() end
	
}