package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5 4
3 1
3 2
4 3
5 3
*/

public class _1325_효율적인해킹_재귀 {
	
	//전역변수
	//방문횟수배열
	static int[] computer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for (int i=0; i<M; i++) {
		
			st = new StringTokenizer(br.readLine()); //입력초기화
			
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
		}
		
		
		//각 컴퓨터(정점)별로 해킹할 수 있는 컴퓨터 수 카운트
		//그 중, 최대값을 가진 컴퓨터를 출력
		computer = new int[N+1];
		
		int max = 0;
		
		
		for (int i=1; i<=N; i++) {
			
			//방문배열 초기화
			boolean[] visited = new boolean[N + 1];
			
			DFS(i, visited, list);
		
		}
		
		
		
		//최대로 해킹할 수 있는 컴퓨터 수를 구함
		for (int i=1; i<=N; i++) {
			
			max = Math.max(max, computer[i]);
		}
		
		
		
		//가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터가 여러개일수도 있기 때문에 for문을 돌면서 각 컴퓨터 번호를 출력
		for (int i=1; i<=N; i++) {
			
			if (computer[i] == max) {
				
				//출력버퍼에 저장
				bw.write(i + " ");
			}
		}
		
		//출력
		bw.flush();
		bw.close();
		br.close();
	
	}//main() end
	
	
	
	public static void DFS(int start, boolean[] visited, ArrayList<Integer>[] list) {
	
		//시작노드 방문체크
		visited[start] = true;

		for (Integer node : list[start]) {
			
			//방문하지 않은 배열만 방문
			if (!visited[node]) {
			
				//방문횟수 추가
				computer[node]++;
			
				//재귀함수 호출
				DFS(node, visited, list);
			
			}//if end
		}//for end
		
	}//while end

}