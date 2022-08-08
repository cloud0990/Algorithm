package algorithm.boj.정수론_조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*

testCase : 최대 100
의상 수  : 최대 30

1. 문제접근 및 설계

-Map의 key value로 데이터관리 활용

key   : 의상이름 저장 -> 의상이름은 중복될 수 없다. ex) hat      turban    sunglasses
value : 의상종류 저장 -> 의상종류는 중복될 수 있다. ex) headgear headgear  eyewear


체크해야할 조건은 크게 2가지로 나눈다.
1. value값 중에서 중복값이 있는 경우
  -> 중복되는 조합은 제거한다.
  
2. value값 중에서 중복값이 없는 경우
  -> 모두 돌아가면서 조합할 수 있다.


*/

public class _9375_패션왕신해빈 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder   sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//테스트케이스 입력받기
		int testCase = Integer.parseInt(st.nextToken());
		
		
		//테스트케이스
		for(int i=0; i<testCase; i++) {
			
			//1. Map 생성
			Map<String, Integer> map = new HashMap<>();
			
			st = new StringTokenizer(br.readLine()); //입력초기화
			
			//2. 의상 갯수 입력받기
			int n = Integer.parseInt(st.nextToken());
			
			//3. 의상 입력받기
			for(int k=0; k<n; k++) {
		
				st = new StringTokenizer(br.readLine()); //입력초기화
				
				//의상이름은 필요없기 때문에 입력은 받지만 저장하지않음
				st.nextToken();
				
				//3-1. 의상종류 입력받기
				String type = st.nextToken();
				
				//3-2. 이미 map에 입력받은 의상종류가 있다면
				//첫번째 for문에서는 map이 비어있으니까 체크되지않음. 두 번째 for문 부터 제대로 체크
				if(map.containsKey(type)) {
					
					/* 입력받은 의상종류에 해당되는 key값이 있는 경우
					  - key값은 원래 중복될 수 없기 때문에 중복되는 값이 추가되면
					    기존의 key값이 가지고있는 value가, 추가된 key가 가지고있는 value로 덮어씌여진다 */

					                //get() : 해당 key값이 가지고있는 value값을 반환한다.
					map.put(type, map.get(type)+1);
					//여기서는 type이 가지고있는 Integer value의 값을 반환하기 때문에 정수 연산이 가능하다.
				
					
				//3-3. map에 입력받은 의상종류가 없다면
				}else {
					//입력받은 의상종류에 해당되는 key값이 없다면, map에 추가
					//value로 1을 저장하는 이유 : 해당 의상종류를 count하기 위함
					map.put(type, 1);
				}
			}//문제 입력완료
	
			/*
				map의 저장된 value값을 처음부터 마지막까지 돌면서
	
				1. 현재 인덱스를 선택하는 경우      = 옷을 입는 경우
				2. 현재 인덱스를 선택하지 않는 경우 = 옷을 입지않는 경우
				
				두가지로 모든 경우를 완전탐색한다.
			*/
			
			
			//경우의 수 구하기
			int answer = 1;
			
			//forEach를 사용해서 map에 저장된 value의 집합(values())을 하나씩(value) 조회
			for(Integer value : map.values()) {
				
				//하나의 원소를 선택하는 경우 + 원소를 선택하지 않는 경우
				//같은종류의 옷을 입는 경우(value) + 같은 종류의 옷을 입지 않는 경우(1)
				answer = answer * (value+1);
				
			}//forEach end
			
			//옷을 안 입는 경우는 제외한다 = -1
			sb.append(answer-1).append("\n");
			
		}//testCase end

		//결과출력
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
}