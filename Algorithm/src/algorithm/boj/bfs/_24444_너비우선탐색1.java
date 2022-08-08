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

public class _24444_너비우선탐색1 {

	static int N;
	static int M;
	static List<ArrayList<Integer>> adj_list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	    	N = Integer.parseInt(st.nextToken()); //Vertex (= node)
		    M = Integer.parseInt(st.nextToken()); //Edge
		int R = Integer.parseInt(st.nextToken()); //Start Vertex
		
		//인접리스트 N만큼 추가생성
		for(int i=0; i<=N; i++) {
			adj_list.add(new ArrayList<>());
		}
		
		
		//간선 입력받기
		for(int i=0; i<M; i++) {
			
			//입력초기화
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//양방향 리스트
			adj_list.get(u).add(v);
			adj_list.get(v).add(u);
		}
		
		//인접리스트 오름차순 정렬 -> 오름차순으로 인접정점 방문
		for(int i=0; i<=N; i++) {
			Collections.sort(adj_list.get(i));
		}
		
		//방문순서 배열 초기화
		int[] arr = new int[N+1];
		
		//메소드 호출
		BFS(R,arr);
		
		
		//결과 출력
		for(int i=1; i<=N; i++) {
			System.out.println(arr[i]);
		}
		
	}//main() end
	
	
	
	//BFS 메소드
	public static void BFS(int R, int[] arr) {
		
		//1. 큐 객체생성
		Queue<Integer> q = new LinkedList<>();
		
		//2. 방문여부 배열 생성
		boolean[] visited = new boolean[N+1];
		
		//3. 시작정점 방문체크
		visited[R] = true;
		
		//4. 시작정점 큐에 추가
		q.add(R);
		
		//5. 시작정점 방문순서 변수 생성
		int cnt = 1;

		
		//반복문 안에서 처리하면 됨 -> 시작정점을 큐에 저장하고 첫번째 반복문 실행
		//6. 시작정점 방문순서 배열에 추가
		//arr[R] = cnt;
		
		//반복문 시작
		while(!q.isEmpty()) {
			
			//1. 현재정점 변수 생성
			int now = q.poll();

			//3. 현재정점 count 배열에 추가
			//현재 now의 인덱스에 cnt 증가한 값 담기
			arr[now] = cnt++;
			
			//2. now에 연결된 인접리스트 하나씩 꺼내기
			for(Integer i : adj_list.get(now)) {
				
				//2-1. 해당 인접정점 방문체크
				//이미 방문한 정점은 방문하지않는다
				if(!visited[i]) { //= if( visited[i] == false )
					
					visited[i] = true;
				
					//2-2. 해당 인접정점 방문 후, 큐에 저장
					q.add(i);
				}
			}//for end
			
			
			//now지점을 방문할 게 아니라, forEach문 안에서 현재지점과 연결된 인접정점의 해당하는 인덱스 방문처리
			//2. 현재 지점 방문체크
			//visited[now] = true;
			
			//방문처리하던 것과 같이, now(현재정점)과 연결된 인접리스트의 값을 큐에 추가해야한다
			//4. 현재정점 큐에 추가
			//q.add(now);
			
		}//while end
		
	}//BFS(R) end
}