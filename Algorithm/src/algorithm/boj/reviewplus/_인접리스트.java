package algorithm.boj.reviewplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*

5 5 1
1 4
1 2
2 3
2 4
3 4

- 결과
node 1 : 2 -> 4
node 2 : 1 -> 3 -> 4
node 3 : 2 -> 4
node 4 : 1 -> 2 -> 3
node 5 : 

*/

public class _인접리스트 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//정점의 갯수
		int N = Integer.parseInt(st.nextToken());
		//간선의 갯수
		int M = Integer.parseInt(st.nextToken());
		
		//인접리스트 객체 생성
		List<ArrayList<Integer>> adj_list = new ArrayList<>();
		
		//인접리스트 1base초기화 (Vertex의 갯수만큼)
		for(int i=0; i<=N; i++) {
			adj_list.add(new ArrayList<Integer>());
		}
				
		//간선(Edge) 입력받기
		for(int i=0; i<M; i++) {
			
			//입력초기화
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//양방향리스트
			adj_list.get(u).add(v);
			adj_list.get(v).add(u);
		}
		
	}
}