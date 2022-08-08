package algorithm.java.reviewsort;

public class _MergeSort_Asc {
	
	public static int [] src;  //입력받을 배열
	public static int [] temp; //배열의 복사본
	
	
	public static void main(String[] args) {
		
		src  = new int [] { 1, 9, 8, 5, 4, 2, 3, 7, 6 };
		
		//src배열 크기 만큼의 복사본 배열 생성
		temp = new int [src.length]; 
		
		//Before sort
		printArray(src); 
		
		//sorting
		mergeSort(0, src.length-1);
		
		
		//After sort
		printArray(src);
	}//main() end
	
	
	public static void mergeSort(int start, int end) {
		
		if(start<end) {
			
			//배열 크기의 중간 값 구하기
			int mid = (start+end)/2;
			
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			//중간 기준으로 왼쪽 분할정렬
			int p   = start;
			int idx = p;
			
			//중간기준으로 오른쪽 분할정렬
			int q = mid + 1;
			
			
			//왼쪽값(p)이 mid보다 작거나같으면, 또는 오른쪽(q)값이 end보다 작거나 같으면 반복해라. 즉, 가운데를 기준으로 왼쪽 오른쪽만큼만 반복
			while(p<=mid || q<=end) {
				
				//즉, 오른쪽 값을 체크하면서, 왼쪽값이 중앙값을 침범하지 않으면서 왼쪽배열의 값이 오른쪽 배열의 값보다 작은 경우,
				if(q>end || (p<=mid && src[p]<src[q])) {
					temp[idx++] = src[p++]; //왼쪽값들을 배열의 복사본에 하나씩 추가한다.
				}else { //아닌 경우는, 오른쪽값을 배열의 복사본에 하나씩 복사한다.
					temp[idx++] = src[q++];
				}
			}//while end
			
			//start=0부터, end값(배열의끝)까지 하나씩 돌면서, 배열에 복사본에 넣어놓은 값들을, 다시 원본 배열에 하나씩 대입한다.
			for(int i=start; i<=end; i++) {
				src[i] = temp[i];
			}//for end
			
		}//if end
		
	}//mergeSort end
	
	
	public static void printArray(int [] a) {
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i] + " ");
		}
		System.out.println();
	}
	
}