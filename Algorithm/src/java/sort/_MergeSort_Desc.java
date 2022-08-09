package java.sort;

/*
	
�������� : ��Ұ� ����� �迭�� ��� �ɰ��� ���̰� 1�� �迭�� �����, �� ���� �����ϸ鼭 ��ģ��
����/���������� ���ڸ� ����(�����迭���� �߰����� ������ �ʿ���������)������,
���������� �߰����� ������ �ʿ���Ѵ� -> �ɰ��ϱ�
�������� �־��� ��� O(n^2)�� �ð����⵵�� �����µ�, ���������� ���� O(nlogn)�� �ð����⵵�� ������
=> ���������� ����ϴ� ���� ����. �־��� ������ �����Ѵٸ�
	
���������� ������ �� : �ݵ�� 2���� �κи���Ʈ�� �������Ѵٴ� ���� �ƴ� -> 2���� �κи���Ʈ�� �����¹�� = two-way
������ �κи���Ʈ�� ���ĵ� �����̸�, �� �κи���Ʈ�� ù��° ��Һ��� ���ؼ� ��ü �迭�� �����ؼ� ���� (�� �κи���Ʈ�� ù�� ° ��Һ��� ���������� ��)	
	
	
*/

public class _MergeSort_Desc {
	
	//�����迭����
	public static int [] n;
	//�����迭ũ���� ���纻 ����
	public static int [] temp;
	
	
	
	public static void main(String[] args) {
		
		//�����迭����
		n    = new int[] {5,1,2,9,8,6,4,7,3};
		//�����迭ũ���� ���纻 ����
		temp = new int[n.length];
		
		System.out.println("---[Befroe sort]---");
		display(n); //���� �迭 �����س����ϱ�, �� �迭�� ������ ���� ���������� �ش� �޼ҵ忡 �Ѱ��ֱ�
		
		//�迭�� 0base�ϱ� start��ġ�ǰ��� ó���� 0�̴�,
		//end�� ���� �迭�� ���̸�ŭ�̶�� ������ �� ������, 0base�ϱ� ��Ȯ�ϰ� ������ ÷�� �����Ϸ���迭�� ���̿��� -1 ������Ѵ�.
		mergeSort(0, n.length-1); //start��ġ�� end��ġ �Ѱ��ֱ�
		
		System.out.println("---[After sort]---");
		display(n);
	}
	
	
	
	//�������� �޼ҵ�
	public static void mergeSort(int start, int end) {
		
		if(start<end) { //�迭�� �������� ���������� ������ ���ɼ��� => ���ο��� �Ѱܹ��� �Ķ���Ͱ� �߸��Ǹ� ���ʿ� �޼ҵ������ü�� �� ��
		
			//�迭�� ������ ���� ��
			int mid = (start+end)/2;
			
			//������ ���� ���� -> �߾ӱ������� ������ ���� ������
			mergeSort(start, mid); //���������� 0, ���������� mid��(�迭�� �߰�������)
			mergeSort(mid+1, end); //���������� mid+1(�߰����� ������)����, �迭�� ������
			
			
			int s     = start;    //s���� �迭�� ù ������ġ���� ����ִ�
			int e     = mid + 1;  //e�� ����� �������� ������ �迭�� ���� üũ�ϱ����� mid+1�� ����
			int index = s;    //���� �� ���� �迭�� �������, �ε������� ������ �� ����� ����
			
			
			//���� ���� : ������ �����Ѵ��, start������ �߰���������, mid+1������ �迭�� �� �������� ������ �����ϴ� ���ȸ� �ݺ�
			while(s<=mid || e<=end) {
				
				// �� ���� �� �ϳ� �̻��� �����ϸ�, ���ʺ����� ���Ҹ� ������
				// e>end     : �����ʰ��� ���� �̹� �� ������ ���
				// n[s]>n[e] : ���ʺ����� ���� ������ ������ ������ ū ���
				if( e>end || (s<=mid && n[s]>n[e]) ) { //�� ���ǿ��� ��������/�������� ������
					
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
	
	
	
	//������ �޼ҵ�
	public static void display(int [] n) {
		
		//���� �ش�迭�� ��¥ �̸��� n������, �ѱ涧 n���� �ѱ�� ���⼭ a��� �̸����� �޾ұ� ������ a��� ������Ѵ�. ���ڷ� �޴� �������� �����Ӱ� �ۼ��Ѵ�.
		for(int i=0; i<n.length; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}//display() end
	
}	