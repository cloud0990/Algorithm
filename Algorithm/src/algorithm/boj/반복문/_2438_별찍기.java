package algorithm.boj.¹Ýº¹¹®;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2438_º°Âï±â {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		
		for(int i=1; i<=n; i++) {
			
			//°ø¹éÂï±â
			for(int j=1; j<=n-i; j++) { //j = 1 2 3 4
				sb.append(" ");
			}
			
			//º°Âï±â
			for(int k=1; k<=i; k++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}