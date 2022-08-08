package algorithm.java.reviewsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

필요한 것

1. 원본배열
   원본배열의 복사본배열

2. 배열의 start값
   배열의 end값
   배열의 mid 값 -> (start+end)/2

3. mergeSort(start, end)값 인자값에 넣어서 해당 메소드에 전달
   
4. mergeSort내에서 left/rightBound범위 설정해서 재귀적호출
   mergeSort(start, mid) / mergeSort(mid+1, end)
   
   if조건 범위 설정 -> start<end : out of length 안 뜨는 범위에서만 진입         

*/

public class 병합정렬 {
	
	static BufferedWriter bw;
	static StringBuilder  sb;
	
	static int[] arr;  //원본배열
	static int[] temp; //원본배열 복사본
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		
		int n = Integer.valueOf(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//배열 입력 완료
		
		//Before sorting
		display(arr);
		
		mergeSort(0, arr.length-1); //= n-1
 		
		//After sorting
		display(arr);
		
	}//main() end
	
	
	public static void mergeSort(int start, int end) {
		
		//조건에 만족할 때만 수행
		if(start<end) {
			
			//중간값 설정
			int mid = (start+end)/2;
			
			//왼쪽 분할
			mergeSort(start, mid); //leftBound
			//오른쪽 분할
			mergeSort(mid+1, end); //rightBound
			
			//해당 인덱스의 값을 비교해서, 어떤 원소를 참조할지 결정하기 위해, 각 분할의 첫번째 인덱스값 초기화
			int p   = start; //왼쪽 분할의 첫번 째 원소값
			int q   = mid+1; //오른쪽 분할의 첫번 째 원소값
			int idx = p; //idx안에 p(start)값 : temp에 정렬된값 넣으려면 index필요
			
			//반복범위 : start는 항상 mid이하, q(mid+1)은 항상 end이하(미만으로 조건설정시, 원소 1개까지 분할못함)
			while(p<=mid || q<=end) { //&&사용시, 종료되지않을 수 있으므로 ||연산자 사용
				
				//왼쪽분할에서 값을 가져올 경우
				if( q>end || (p<=mid && arr[p]<arr[q]) ) { //

					temp[idx++] = arr[p++];
				
				}else {
					temp[idx++] = arr[q++];
				}
			}//while end
			
			//temp의 정렬값을 원본배열에 복사
			for(int i=start; i<=end; i++) {
				arr[i] = temp[i];
			}
			
		}//if end
		
	}//mergeSort end
	
	public static void display(int[] arr) throws IOException {
		
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}//display() end
}