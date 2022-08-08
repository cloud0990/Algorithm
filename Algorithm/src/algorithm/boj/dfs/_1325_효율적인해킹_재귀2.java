package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5 4
3 1
3 2
4 3
5 3
*/

public class _1325_효율적인해킹_재귀2 {
	
	//전역변수
	static int[]     computer; //방문횟수배열
	static boolean[] visited;  //방문상태배열

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //노드의 범위
		int M = Integer.parseInt(st.nextToken()); //인점노드 쌍의 수
	
		
		//List배열 생성
		List<Integer>[] list = new ArrayList[N+1];
		
		//List배열 초기화
		//배열 첨자에 초기화시키는 거여서 1부터 시작해도 됨
		for(int i=1; i<=N; i++) {
			
			list[i] = new ArrayList<Integer>();
		}
		
		//반복인덱스 활용하는 게 아니라 반복횟수만큼 입력받기
		//ArrayList에 간선 입력받기
		for(int i=0; i<M; i++) {
			
			//입력초기화
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//단방향리스트
			list[u].add(v);
		}//예제 입력완료
		
		//방문 횟수 배열 초기화
		computer = new int[N+1];
		
		//방문최대횟수 찾기위한 변수
		int max = 0;
		
		//반복문인덱스의 첨자를 모두 시작노드로 지정해서 BFS메소드 호출
		for(int i=1; i<=N; i++) {
			
			//방문상태배열 초기화 -> 시작노드가 변할 때, 배열초기화가 안 되어있으면 방문할 수 있는 곳도 못 감
			visited = new boolean[N+1];
			
			//너비우선탐색 메소드 호출
			BFS(i, computer, list);
			
		}//시작노드 1~N 방문완료
		
		
		//최대값 찾기
		for(int i=1; i<=N; i++) {
			
			max = Math.max(max, computer[i]);
		}
		
		
		//최대값과 일치한 방문횟수배열의 인덱스 출력버퍼에 저장
		for(int i=1; i<=N; i++) {
			
			if(max==computer[i]) {
				bw.write(i+" ");
			}
		}
		
		//출력
		bw.flush();
		bw.close();
		br.close();
	}//main() end

	public static void BFS(int start, int[] computer, List<Integer>[] list) {
		
		//큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		//방문체크
		visited[start] = true;
		
		//큐에 추가
		q.add(start);
		
		
		//큐가 빌 때까지 인접노드 방문
		while(!q.isEmpty()) {
			
			//현재노드 큐에서 꺼내오기
			int now = q.poll();
			
			for(Integer node : list[now]) {
				
				//방문하지 않은 곳만 방문
				if(!visited[node]) {
					
					q.add(node);
					
					computer[node]++;
					
				}//if end
				
			}//for end
		}//while end
		
	}//BFS() end
	
}