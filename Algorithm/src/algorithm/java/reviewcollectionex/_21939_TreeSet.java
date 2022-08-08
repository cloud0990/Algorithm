package algorithm.java.reviewcollectionex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
/*
	recommend와 solved는 하나 이상 있을때만 존재한다고 했으니 예외는 고려할 필요가 없다. 
	문제번호와 난이도를 저장할 자료구조가 필요할 것 같다. 
	문제번호는 중복이 불가능하지만 난이도는 중복 가능 -> map을 사용해서 문제번호를 key로, 난이도를 value로 넣자. 
	정렬을 어떻게 할까? -> treeset을 사용해서 정렬한 상태로 받자. 정렬기준만 명시해주면 될 듯  
*/
public class _21939_TreeSet {
	
	public static class Algorithm implements Comparable<Algorithm>{
		
		int idx_P;
		int level_L;
		
		public Algorithm() {
			
		}
		
		public Algorithm(int idx_P, int level_L) {
			// TODO Auto-generated constructor stub
			this.idx_P = idx_P;
			this.level_L = level_L;
		}
		
		@Override
		public int compareTo(Algorithm o) {
			// TODO Auto-generated method stub
			
			//난이도가 같은 경우 문제번호(idx)를 기준으로 정렬합니다.
			if(level_L == o.level_L) {
				return idx_P - o.idx_P;
			} else { 
				return level_L - o.level_L;
			}
		}
		public String toString() {
			return "idx_P : " + idx_P + " level_L : " + level_L;
		}
		
	}
	
	//
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Algorithm> set = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			set.add(new Algorithm(P, L));
			map.put(P, L);
		}
		
		
		//System.out.println(set.toString());
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
				case "add": 
					int idx_P = Integer.parseInt(st.nextToken());
					int level_L = Integer.parseInt(st.nextToken());
					set.add(new Algorithm(idx_P,level_L));
					map.put(idx_P, level_L);
					break;
				case "recommend":
					if(Integer.parseInt(st.nextToken())==1) {
										//last는 가장 큰 값
										//자체적으로 정렬할 때, 난이도 순으로 정렬이 되고, 난이도가 같은 경우 문제 번호가 큰 것이 뒤에 오도록 오름차순 정렬됨
										//따라서 가장 오른쪽(last)값이 recommend 1에 적당하다.
						sb.append(set.last().idx_P).append('\n');
					} else { //-1이라면 -> 난이도가 가장 쉽고, 여러개라면 문제 번호가 제일 작은것(오름차순이므로 이또한 ㅇㅋ)
						sb.append(set.first().idx_P).append('\n');
					}
					break;
				default://solved
					int P = Integer.parseInt(st.nextToken());
					set.remove(new Algorithm(P, map.get(P)));
					map.remove(P);
					break;
				
			}
		}
		System.out.println(sb);
	

		
	}

}
