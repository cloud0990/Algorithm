package algorithm.boj.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2525_오븐시계 {

	static StringBuilder sb = new StringBuilder();
	
	public static String time(int h, int m, int tl) {
		
		//m+tl이 아래의 조건을 만족하지않는다면, h는 원래값, m은 timelapse를 더한 값으로 출력
		m = m + tl;
		
		if(m>59) {
			
			h = h + (m/60);
			
			m = m%60;
			
			if(m==60) {
				m = 0;
			}else if(h>23) {
				h = h - 24;
			}
		}
		
		return sb.append(h).append(" ").append(m).toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		
		//시간, 분 입력받기
		int H = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		//소요시간 입력받기
		int timeLapse = Integer.parseInt(st.nextToken());
		
		bw.write(time(H,M,timeLapse));
		bw.flush();
		bw.close();
		br.close();
	}
}