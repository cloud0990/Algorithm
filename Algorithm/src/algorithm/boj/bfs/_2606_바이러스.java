package algorithm.boj.bfs;

import java.io.*;
import java.util.*;

/*

시작정점(1)에서 방문할 수 있는 인접정점의 갯수 구하기

*/

public class _2606_바이러스 {

	//전역변수
	//1. 인접리스트
	static List<ArrayList<Integer>> adj_list = new ArrayList<>();
	//2. 정점의 수
	static int N;
	//3. 인접정점 쌍의 수
	static int M;
	//4. 출력객체
	static StringBuilder   sb = new StringBuilder();
	static BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. 예제입력
		//정점의 수 입력받기
		N = Integer.parseInt(st.nextToken()); 
		
		//1-1. 입력초기화 + 인접정점 쌍의 수 입력받기
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		//1-2. 주어진 시작정점 변수 생성
		int start = 1;
		
		//2. 정점의 수만큼 ArrayList 생성
		for(int i=0; i<=N; i++) {
			adj_list.add(new ArrayList<Integer>());
		}
		
		//3. 인접정점쌍의 수 입력받기
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine()); //입력 초기화
			
			//인점정점 입력받기
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//양방향리스트 생성
			adj_list.get(u).add(v);
			adj_list.get(v).add(u);
		}// 예제 입력완료
		
		
		//4. 결과출력
		bw.write(BFS(start).toString());
		bw.flush();
		bw.close();
		br.close();
		
	}//main() end
	
	
	//BFS메소드 생성
	public static String BFS(int start) {
		
		//1. 큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		//2. 방문상태배열
		boolean[] visited = new boolean[N+1];
		
		//2-1. 현재정점 방문여부 체크 (시작정점=1)
		visited[start] = true;
		
		//3. 현재정점 큐에 추가
		q.add(start);
		
		//4. 방문횟수 변수 생성
		int answer = 0;
		
		//5. 반복
		while(!q.isEmpty()) {
			
			//5-1. 현재위치 큐에서 꺼내오기
			int now = q.poll();
			
			//5-2. start와 연결된 인접리스트 값을 하나씩 읽으면서 방문할 수 있는 인접정점 체크
			for(Integer i : adj_list.get(now)) {
				
				//6. 조건) 방문하지 않았다면
				if(!visited[i]) {
	
					//6-1. 다음방문정점 방문체크
					visited[i] = true;
					
					//6-2. 다음방문정점 큐에 추가
					q.add(i);
					
					//6-3. 방문횟수 체크
					answer++;
				}
				
			}//for end
		}//while end

		//결과 StringBuilder에 추가
		sb.append(answer);
		
		//7. cnt return
		return sb.toString();
		
	}//BFS() end

}