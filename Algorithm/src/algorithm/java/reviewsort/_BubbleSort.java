package algorithm.java.reviewsort;

public class _BubbleSort {

	public static void main(String[] args) {
		
		//인접한 요소와 값을 비교하여 정렬
		//정렬의 대상이되는 데이터외의 추가적인 공간을 필요로하지 않음
		//안정정렬 : 동일한 값에 대해 기존의 순서가 유지됨
		//ㄴ>cf) 선택정렬-불안정정렬 -> 동일한 값에 대한 기존의 순서가 유지되지않음
		//       선택정렬은 반복 1회당 요소의 교환이 1번 발생한다. 작은 값과 큰 값 swap(작은 값을 찾아서 맨 앞으로 이동하는 방식)
		//버블정렬은 마지막요소-1만큼 반복한다. 이미 어느정도 정렬이 되있다면 금방 끝나겠지만, 최악의 경우 모든 요소를 교환해야한다
		
		int [] bSort = {5,9,7,6,1,3,4,8,2};
		
		
		//배열의 모든 요소
		for(int i=0; i<bSort.length; i++) {
			
			//첫 반복은 k와 i가 0이니까 모든 요소의 인접요소를 비교하여 정렬하지만
			//두 번째 반복부터는 이미 맨 뒤에 정렬된 데이터가 있으니까 그 값은 비교할 필요가 없어서 i-1
			for(int k=0; k<bSort.length-i-1; k++) { // i 반복문 한 번 돌 때마다 맨 끝에는 이미 정렬된 값이 들어가니까
				
				if(bSort[k]>bSort[k+1]) {  //인접한 요소 +1과의 값 비교
					int temp   = bSort[k+1];
					bSort[k+1] = bSort[k];
					bSort[k]   = temp;
				}
			}
		}
		
		for(int i=0; i<bSort.length; i++) {
			System.out.print(bSort[i] + " ");
		}
		
		
	}
}