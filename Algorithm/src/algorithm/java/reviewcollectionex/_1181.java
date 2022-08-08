package algorithm.java.reviewcollectionex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class _1181 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		Set<ww> ts = new TreeSet<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			ts.add(new ww(str, str.length()));
		}
		
		for(ww s : ts) {
			System.out.println(s);
		}
		
	}

}

class ww implements Comparable<ww>{
	String str;
	int str_length;
	
	public ww() {
		
	}
	
	public ww(String str, int str_length) {
		this.str = str;
		this.str_length = str_length;
	}

	@Override
	public int compareTo(ww o) {
		// TODO Auto-generated method stub
		if(this.str_length == o.str_length) {
			return this.str.compareTo(o.str);
		}
		
		return this.str_length- o.str_length;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.str;
	}
	
}

