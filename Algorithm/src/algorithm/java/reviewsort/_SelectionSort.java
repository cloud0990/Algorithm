package algorithm.java.reviewsort;

import java.util.Scanner;

public class _SelectionSort {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int z = scanner.nextInt();
		
		int [] n = {x,y,z};
		
		
		//Selection Sort
		for(int i=0; i<n.length-1; i++) {     //마지막에 있는 값은 이미 정렬되어 뒤로 밀린 값이기때문에 비교할 필요가 없다 -1
			for(int j=i+1; j<n.length; j++) { // 자기자신과는 비교할 필요가 없기 때문에 i+1
				
				if(n[i]<n[j]) { // > 는 오름차순정렬 < 는 내림차순 정렬
					
					//n[i]와 n[j]의 값 교환 => 자바에서는 직접 바로 교환할 수 없기때문에, 임시변수를 통해서 교환해야함
					int temp = n[i]; //temp변수에 n[i]의 값이 들어감
					n[i] = n[j];     //n[j]의 값을 n[i]에 대입
					n[j] = temp;     //n[j]의 값에 n[i]값 대입 => 위에서 n[i]의 값을 temp라는 임시변수 안에 대입했음
				}
			}
		}
		
		//결과 출력
		for(int k=0; k<n.length; k++) {
			System.out.print(n[k]+" ");
		}
	}
}