package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*

시작정점(1)에서 방문할 수 있는 인접정점의 갯수 구하기

*/

public class _2606_바이러스_스택 {

	//전역변수
	//1. 인접리스트
	static List<ArrayList<Integer>> adj_list = new ArrayList<>();
	//2. 정점의 수
	static int N;
	//3. 인접정점 쌍의 수
	static int M;

	
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
		
		System.out.println(DFS(start));
		
	}//main() end
	

	public static int DFS(int start) {
		
		//스택 생성
		Stack<Integer> stack = new Stack<>();
		
		boolean[] visited = new boolean[N+1];
		
		//시작지점 방문처리
		visited[start] = true;
		
		//시작지점 스택에 추가
		stack.push(start);
		
		int answer = 0;
		
		while(!stack.isEmpty()) {
			
			//현재정점 stack에서 꺼내오기
			int now = stack.pop();
			
			for(Integer node : adj_list.get(now)) {
				
				//방문하지않은 경우에만 방문
				if(!visited[node]) {
					
					//방문처리
					visited[node] = true;
					
					//다음방문정점 스택에 추가
					stack.push(node);
					
					//방문횟수 카운트
					answer++;
				}//if end
				
			}//for end
		}//while end
		
		return answer;
	}//DFS() end
}