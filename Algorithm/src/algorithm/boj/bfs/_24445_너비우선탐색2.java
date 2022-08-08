package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*

정점의 수 N (5 ≤ N ≤ 100,000)
간선의 수 M (1 ≤ M ≤ 200,000)
시작 정점 R (1 ≤ R ≤ N)

*/


public class _24445_너비우선탐색2 {
	
	//인접리스트
	static List<ArrayList<Integer>> adj_list = new ArrayList<>();
	static int N;
	static int M;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. Vertex, Edge, start Vertex 입력받기
		N = Integer.parseInt(st.nextToken()); //정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		
		int R = Integer.parseInt(st.nextToken()); //시작 정점
		
		
		for(int i=0; i<=N; i++) {
			//2-1. 입력받은 정점의 갯수만큼 ArrayList생성
			adj_list.add(new ArrayList<>());
		}
		
		//2. Vertex만큼 ArrayList 생성 + 정점 u v의 양방향 리스트 생성
		for(int i=0; i<M; i++) {

			st = new StringTokenizer(br.readLine());
			
			//2-2. 정점 u v 입력받기
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//2-3. 양방향 리스트 추가
			adj_list.get(u).add(v);
			adj_list.get(v).add(u);
			
		}//예제 입력완료
		
		//3. 내림차순 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(adj_list.get(i), Collections.reverseOrder());
		}
		
		//방문순서 기록 배열 생성
		int[] arr = new int[N+1];
		
		//4. BFS() 호출
		BFS(R, arr);
		
		//5. 결과출력
		for(int i=1; i<=N; i++) {
			System.out.println(arr[i]);
		}
	}//main() end
	
	
	
	public static void BFS(int start, int[] arr) {
		
		//1. 큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		//2. 시작지점 방문체크
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		
		//3. 시작지점 큐에 추가
		q.add(start);
		
		//방문순서 체크 변수
		int cnt = 1;
		
		//4. 반복
		while(!q.isEmpty()) {
			
			//4-1. 큐에서 반환받은 값을 현재정점 변수에 담는다
			int now = q.poll();
			
			//4-2. 현재정점의 방문순서 기록
			arr[now] = cnt++;
			
			for(Integer i : adj_list.get(now)) {
				
				//4-3. 방문하지 않은 경우, 범위 내에 있는 경우의 조건 체크
				if(!visited[i]) {
					
					//4-2. 다음 방문정점 방문체크
					visited[i] = true;
					
					//4-3. 다음 방문정점 큐에 추가
					q.add(i);
				}
			}
		}//while end
	}//BFS() end
	
}