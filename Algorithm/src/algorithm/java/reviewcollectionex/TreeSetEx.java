package algorithm.java.reviewcollectionex;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * TreeSet 이진 탐색 트리로 구현 - 범위 탐색, 정렬에 유리 이진 트리는 모든 노드가 최대 2개의 하위 노드를 갖음 각 요소가 나무
		 * 형태로 연결(linkedlist의 변형)
		 * 
		 * 이진탐색 트리 부모보다 작은 값은 왼쪽, 큰 값은 오른쪽에 저장 단점 - 데이터가 많아질 수록(트리가 커질수록) 추가, 삭제에 시간이 더
		 * 걸림(root부터 값을 비교하기 때문에 비교 횟수 증가)
		 * 
		 * class TreeNode { TreeNode left;//왼쪽 자식 Object element;//데이터 TreeNode
		 * right;//오른쪽 자식 }
		 * 
		 * 
		 * 데이터의 저장과정 - boolean add(Object o) set은 중복을 허용하지 않기때문에 데이터를 저장하기 전에 중복 검사를
		 * 수행합니다. 
		 * hashset - equals, hashcode로 비교 treeset - compare를 호출해서 비교
		 * 
		 * 
		 * 트리셋만의 주요 생성자와 메서드 TreeSet() 기본 생성자 
		 * TreeSet(Collection c) 주어진 컬렉션 c를 저장하는 treeset생성 
		 * TreeSet(Comparator comp) 주어진 정렬 기준으로 정렬하는 treeset을 생성
		 * 
		 * Object first() 정렬된 순서에서 첫 번째 객체를 반환(제일 작은거, 제일왼쪽아래) 
		 * Object last() 정렬된 순서에서 마지막 객체를 반환(제일 큰거, 제일 오른쪽 아래) 
		 * Object ceiling(Object o) 지정된 객체o와 같은 객체를 반환, 없으면 큰 값을 가진 객체 중 제일 가까운 객체를 반환, 없으면 null(같거나 큰것) 
		 * Object floor(Object o) 지정된 객체o와 같은 객체를 반환, 없으면 작은 값을 가진 객체 중 제일 가까운 객체를 반환, 없으면 null(같거나 작은것) 
		 * Object higher(Object o) 지정된 객체o보다 큰 값을 가진 객체중 가장 가까운 값의 객체를 반환, 없으면 null(큰것) 
		 * Object lower(Object o) 지정된 객체o보다 작은 값을 가진 객체중 가장 가까운 값의 객체를 반환, 없으면 null(작은것)
		 * 
		 * SortedSet subSet(Object fromElement, Object toElement) 범위검색, from과 to사이의 결과를
		 * 반환한다. 끝범위인 to는 포함되지 않는다!! SortedSet headSet(Object toElement) 지정된 객체보다 작은 값을
		 * 반환 SortedSet tailSet(Object fromElement) 지정된 객체보다 큰 값을 반환
		 */


		// Set set = new HashSet(); -> 얜 정렬 안됨, 가끔 우연의 일치로 정렬이 될 수도 있음. 정렬하려면 list로
		// 자료구조를 변환해주고, collections.sort사용. set은 원래 사용이 안되서 리스트로 바꿔서 하는 거임

		/*
		 * for(int i=0; set.size() < 6; i++) { 
		 * 	int num = (int)(Math.random()*45) + 1;
		 * 	set.add(num); 
		 * ★★★★★★★★★★★★★★★★
		 * //일반적인 wrapper클래스들은 클래스 자체에서 비교기준을 구현 상속 하고 있기 때문에 비교기준이기본적으로
		 * 정해져 있지만, //사용자 정의 객체는 비교기준을 직접 명시해주어야 합니다. }
		 * 
		 * 
		 * set.add(new Test()); set.add(new Test()); set.add(new Test()); set.add(new
		 * Test());
		 * 
		 * System.out.println(set);
		 */

		/*
		 * String from = "b"; String to = "d";
		 * 
		 * 
		 * set.add("abc"); set.add("alien"); set.add("bat"); set.add("car");
		 * set.add("Car"); set.add("disc"); set.add("dance"); set.add("dZZZZ");
		 * set.add("dzzzz"); set.add("elephant"); set.add("elevator"); set.add("fan");
		 * set.add("flower");
		 * 
		 * 
		 * System.out.println(set); System.out.println("range search : from " + from +
		 * " to " + to); System.out.println("result1 : " + set.subSet(from, to));
		 * System.out.println("result2 : " + set.subSet(from, "dzzz"));
		 */

		/*
		 * int[] score = { 80, 95, 90, 50, 35, 45, 65, 10, 100 };
		 * {1, 2, 3, 4, 5, 6, 7}
		 * for (int i = 0; i < score.length; i++) { set.add(new Integer(score[i])); }
		 * 
		 * System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
		 * System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
		 */
		
		TreeSet set = new TreeSet(new TestComp()); // 범위 검색, 정렬됨
		/*
		 * for(int i=0; set.size() < 6; i++) { int num = (int)(Math.random()*45) + 1;
		 * set.add(new Test()); }
		 */
		
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		
		System.out.println(set);
		

	}
}

class Test{}

class TestComp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
//둘 중 하나???
//1. treeset타입으로 생성된 객체가 정렬 기준을 갖고 있던지 -> TestComp
//2. 트리셋에 저장되는 객체 자체가 정렬기준을 구현하고 있던지 - > class Test implements Comparable {}

/*
 * class Test {} // 비교기준이 없음. -> 비교기준을 만들어 줘야 함 class TestComp implements
 * Comparator{
 * 
 * @Override public int compare(Object o1, Object o2) { return 0; // TODO
 * Auto-generatedmethod stub return 1;
 * 
 * //기본적으로 기준을 정해줄 때, o1 - o2로 진행을 하는데, 값이 0이라는 것은 같은 값이라는 뜻 따라서 1이거나 -1일때는 둘중에
 * //하나가 더 크거나 작다는 뜻이니 이말은 값이 다르다는 거다. 오름차순이 기본이고, 0일때는 교환x, 양수면 교환, 음수면 교환x
 * //내림차순으로 지정하려면 기본인 o1-o2 대신 o2-o1을 하면 됩니다.
 * 
 * }
 * 
 * }
 */
