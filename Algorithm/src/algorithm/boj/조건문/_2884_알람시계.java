package algorithm.boj.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2884_알람시계 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		
		//현재 시,분 입력받기
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		
		if(M<45) {
			
			if(H<=0) {
				H = (H+24)-1;
			}else {
				H = H-1;
			}
			
			M = (M+60)-45;
	
		}else if(M>=45) {
			
			M = M-45;
		}
		
		sb.append(H).append(" ").append(M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}