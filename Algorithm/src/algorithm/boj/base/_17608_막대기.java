package algorithm.boj.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _17608_막대기 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//막대기의 갯수 입력받기
		int n     = Integer.valueOf(st.nextToken());
		int max   = 0; //전역변수 : 전역변수로 해야 max값이 누적갱신됨
		int count = 0;
		//입력받은 n만큼의 배열 생성
		int[] arr = new int[n];
		
		//입력받기 -> 위에서 한 줄로 입력받은 값을 잘라서 n안에 대입했기때문에, 남아있는 토큰이 없음
		for(int i=0; i<n; i++) {
			//스페이스(공백기준 한 줄)로 입력받는다면 for문 밖에서 초기화해야하지만, 예제에서는 엔터로 구분하기때문에
			//한 줄 입력받을 때 마다 초기화해야함
			st = new StringTokenizer(br.readLine()); 
			arr[i] = Integer.parseInt(st.nextToken());
		} //예제입력완료
		
		for(int k=n-1; k>=0; k--) {
			
			if(max<arr[k]) {
				max = arr[k];
				count++;
			}
		}
		
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();//출력버퍼에 저장된 값을 출력하고 버퍼를 비운다
		bw.close();
		br.close();
	}
}