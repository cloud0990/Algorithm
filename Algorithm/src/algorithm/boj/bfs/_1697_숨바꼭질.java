package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

- 범위
0 ≤ N ≤ 100,000
0 ≤ K ≤ 100,000

- 이동범위
1. now - 1
2. now + 1
3. now * 2


- 설계
너비우선탐색 말 그대로 탐색이 우선이다.

1. 조건설정        2. 조건에 만족하는 정점 방문 (X)

1. 일단 모두 방문  2. 조건설정                  (O)


종료정점까지 가는 시간을 구한다.

boolean형으로 방문여부를 체크하고, 방문할 때마다 따로 cnt++을 하는 게 아니라,
방문할 수 있는 모든 지점을 방문하고 방문한 곳에 방문순서를 체크한다.
(방문과 순서를 동시에 체크할 수 있다 -> int[] time)

계속 방문하다가 종료지점노드를 만나게되면, 현재방문순서값을 출력한다.


- 방문체크 및 큐 추가조건
1. 다음 방문지점이 N과 K의 범위 내에 있다
2. 방문하지 않았다 (이미 방문한 곳은 방문하지않는다)


BFS의 기본적인 구조는 똑같고, 이동이나 경우에 따른 조건만 추가해주면 된다.


*/

public class _1697_숨바꼭질 {
	
	static int[] time = new int[100001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//시작정점
		int N = Integer.parseInt(st.nextToken());
		//도착정점
		int K = Integer.parseInt(st.nextToken());
	
		//결과출력
		//조건설정 : N과 K의 값이 같을 경우는 탐색할 필요없음
		if(N==K) {
			System.out.print(0);
		}else {
			BFS(N, K);
		}
		
	}//main() end
	
	
	public static void BFS(int start, int end) {
		
		//1. 큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		//2. 현재정점 방문체크 -> 방문체크와 시간체크 동시에 할 수 있음. 
		time[start] = 1;
		
		//3. 현재정점 큐에 추가
		q.add(start);
		
		
		//이동
		while(!q.isEmpty()) {
			
			//1. 현재정점값 저장
			int now = q.poll();
			
			//2. 3번의 이동값 미리 체크
			for(int i=0; i<3; i++) { // i = 0 1 2
				
				//다음방문지점 변수생성 : 새로운 반복마다 전의 next값을 0으로 초기화
				int next = 0;
				
				if(i==0) {
					next = now + 1;
				}else if(i==1) {
					next = now - 1;
				}else if(i==2) {
					next = now * 2;
				}
				
				//3. 다음으로 갈 정점이 도착정점과 같을경우 출력 후 메소드종료
				if(next==end) {
					
					//미리 출력해놨기 때문에, main()에서는 메소드호출만 하면 됨
					System.out.print(time[now]);
					
					return;
				}
				
				//4. 방문조건설정
				//다음방문지점이 범위 내에 있고, 방문하지 않았을 때만 방문
				//time의 next인덱스값이 0이다 = 방문하지 않았다
				// ㄴ> 방문했다면 방문순서가 매겨져있다
				if( 0<=next && next<time.length && time[next]==0 ) {
					
					//4-1. 다음방문할 정점의 순서부여
					time[next] = time[now] + 1;
					
					//4-2. 다음방문정점 큐에 추가
					q.add(next);
				}
				
			}//for end
			
		}//while end

	}//BFS() end
	
}