package algorithm.java.reviewsort;

/*
	
병합정렬 : 요소가 저장된 배열을 계속 쪼개서 길이가 1인 배열을 만들고, 그 이후 정렬하면서 합친다
버블/선택정렬은 제자리 정렬(원본배열에서 추가적인 공간이 필요하지않음)이지만,
병합정렬은 추가적인 공간을 필요로한다 -> 쪼개니까
퀵정렬은 최악의 경우 O(n^2)의 시간복잡도를 가지는데, 병합정렬은 상항 O(nlogn)의 시간복잡도를 가진다
=> 병합정렬을 사용하는 것이 좋다. 최악의 경우까지 고려한다면
	
병합정렬의 주의할 점 : 반드시 2개의 부분리스트로 나눠야한다는 점은 아님 -> 2개의 부분리스트로 나누는방식 = two-way
각각의 부분리스트는 정렬된 상태이며, 각 부분리스트의 첫번째 요소부터 비교해서 전체 배열에 정렬해서 넣음 (각 부분리스트의 첫번 째 요소부터 순차적으로 비교)	
	
	
*/

public class _MergeSort_Desc {
	
	//원본배열생성
	public static int [] n;
	//원본배열크기의 복사본 생성
	public static int [] temp;
	
	
	
	public static void main(String[] args) {
		
		//원본배열생성
		n    = new int[] {5,1,2,9,8,6,4,7,3};
		//원본배열크기의 복사본 생성
		temp = new int[n.length];
		
		System.out.println("---[Befroe sort]---");
		display(n); //여기 배열 선언해놨으니까, 그 배열의 정보를 담은 참조변수를 해당 메소드에 넘겨주기
		
		//배열은 0base니까 start위치의값은 처음인 0이다,
		//end의 값은 배열의 길이만큼이라고 생각할 수 있지만, 0base니까 정확하게 마지막 첨자 지정하려면배열의 길이에서 -1 해줘야한다.
		mergeSort(0, n.length-1); //start위치와 end위치 넘겨주기
		
		System.out.println("---[After sort]---");
		display(n);
	}
	
	
	
	//병합정렬 메소드
	public static void mergeSort(int start, int end) {
		
		if(start<end) { //배열의 시작점이 끝지점보다 작으면 명령수행 => 메인에서 넘겨받은 파라미터가 잘못되면 애초에 메소드실행자체가 안 됨
		
			//배열을 반으로 나눈 값
			int mid = (start+end)/2;
			
			//분할할 지점 설정 -> 중앙기준으로 오른쪽 왼쪽 나누기
			mergeSort(start, mid); //시작지점은 0, 종료지점은 mid값(배열의 중간까지만)
			mergeSort(mid+1, end); //시작지점은 mid+1(중간기준 오른쪽)부터, 배열의 끝까지
			
			
			int s     = start;    //s에는 배열의 첫 시작위치값을 담고있다
			int e     = mid + 1;  //e는 가운데를 기준으로 오른쪽 배열의 값을 체크하기위해 mid+1로 선언
			int index = s;    //정렬 후 값을 배열에 담기위해, 인덱스값을 조정할 때 사용할 변수
			
			
			//정렬 시작 : 위에서 분할한대로, start지점이 중간지점까지, mid+1지점이 배열의 끝 전까지인 조건을 만족하는 동안만 반복
			while(s<=mid || e<=end) {
				
				// 두 조건 중 하나 이상을 만족하면, 왼쪽분할의 원소를 가져옴
				// e>end     : 오른쪽값의 값을 이미 다 가져온 경우
				// n[s]>n[e] : 왼쪽분할의 값이 오른쪽 분할의 값보다 큰 경우
				if( e>end || (s<=mid && n[s]>n[e]) ) { //이 조건에서 오름차순/내림차순 결정됨
					
					temp[index++] = n[s++];
				
				}else {
					temp[index++] = n[e++]; 
				}
				
			}//while end
			
			for(int i=start; i<=end; i++) {
				n[i] = temp[i];
			}//for end
			
		}//if end
		
	}//mergeSort() end
	
	
	
	//결과출력 메소드
	public static void display(int [] n) {
		
		//원래 해당배열의 진짜 이름은 n이지만, 넘길때 n으로 넘기고 여기서 a라는 이름으로 받았기 때문에 a라고 적어야한다. 인자로 받는 변수명은 자유롭게 작성한다.
		for(int i=0; i<n.length; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}//display() end
	
}	