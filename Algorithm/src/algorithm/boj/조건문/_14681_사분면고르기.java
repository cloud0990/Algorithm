package algorithm.boj.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
조건 : x와 y는 둘 다 양수이거나 음수이다.(0인 경우는 없다)
*/

public class _14681_사분면고르기 {

	static StringBuilder sb = new StringBuilder();
	
	public static String Quadrant(int x, int y) {
		
		if( (x>0) && (y>0) ) {       //x, y 둘 다 양수
			sb.append("1");
		}else if( (x<0) && (y>0) ) { //-x, y
			sb.append("2");
		}else if( (x<0) && (y<0) ) { //-x, -y
			sb.append("3");
		}else if( (x>0) && (y<0) ) { // x, -y
			sb.append("4");
		}
		
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.valueOf(st.nextToken());
		
		bw.write(Quadrant(x,y));
		bw.flush();
		bw.close();
		br.close();
	}
}