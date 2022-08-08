package algorithm.java.reviewcollectionex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		//초기에 리스트에 용적을 지정해주지 않으면 default값으로 10의 크기가 지정된다ㅣ.
		//기본형은 불가. 컴파일러가 오토박싱을 해줘서 객체를 넣어주는 거다. 일반자료형은 못들어옴
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(1));
		list1.add(new Integer(2));
		list1.add(new Integer(3));
		/*
		list1.add(5)
		list1.add(4)
		list1.add(2)
		list1.add(1)
		list1.add(2)
		list1.add(3)
		*/
		
		//일부를 뽑아서 새로운 리스트를 만든다.
		//ArrayList(Collection c)를 응용한 것
		/*풀어쓰면 다음과 같다.
		List sub = list1.subList(1,4); -> sub는 읽기만 가능합니다.
		ArrayList list2 = new ArrayList(sub);
		*/
		ArrayList<Integer> list2 = new ArrayList<Integer>(list1.subList(1, 1 + 3));
		//List sub = list2.subList(1, 2);
		//sub.add(1);
		/*
		 * for(Object s : sub) { System.out.print(s); }
		 */
		
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		//Collection은 인터페이스, Collections는 util 클래스 
		Collections.sort(list1);
		Collections.sort(list2);
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		//list1이 list2의 모든 요소를 포함하는가?
		System.out.println(list1.containsAll(list2));
		
		
		list2.add(11);
		list2.add(12);
		list2.add(3, 13); //중간 삽입을 지정하면 나머지 요소들이 한 칸씩 뒤로 이동해서 자리를 만들어 줘야 하기 때문에 부담가는 작업
		
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		list2.set(3, 20);
		
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		
		list1.add(0, 111);
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		//indexOf()는 지정된 객체의 위치를 알려준다. 
		System.out.println("index = " + list1.indexOf(111));
		
		//삭제
		//index 1에 있는 지정된 객체의 위치를 알려준다.
		list1.remove(1);
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		
		/*
		예를 들어 리스트에 "1"과 1이 저장된 경우 remove를 사용할 때 주의점
		list1.remove(1)을 사용하면 boolean remove(Object obj)가 호출되어 값 1이 삭제될 것 같지만
		Object remove(int index)가 호출되어 쓸데없이 인덱스가 1인 값이 삭제된다. 이는 자동박싱이 되는것을 간과하고 사용한 결과이다. 
		따라서 내가 원하는대로 인덱스가1인값이 아니라 실데이터가 1인 값을 삭제하려면 다음과 같이 메소드를 정의해야 한다. 
		list1.remove(new Integer(1));
		
		*/
		
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다. 
		//System.out.println(list1.retainAll(list2));
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		//list2에서 list1에 포함된 객체들을 삭제한다. 
		/*
			1. get(i)ㄹ list2에서 객체를 하나씩 꺼낸다.
			2. contains()로 꺼낸 객체가 list1에 있는지 확인한다. 
			3. remove(i)로 해당 객체를 list2에서 삭제
		*/
		for(int i=list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//ArrayList에 저장된 객체의 삭제 과정 
		/*
		 * 
			중간에 끼어있는 객체를 삭제하는 방법
			1. 삭제할 데이터보다 인덱스값이 뒤에 있는 객체들을 한 칸씩 이동하면서 삭제하고자 하는 값을 덮어 쓴다. 
			2. 데이터가 모두 한 칸씩 이동했으므로 가장 마지막에는 복사하기 전 객체가 남아있게되는데 이값을 삭제해야한다.(null처리하기)
			3. 데이터가 삭제되어 데이터의 개수가 줄었으므로 size의 값을 감소시킨다.
			cf)단 가장 마지막 index에 있는 값을 삭제하는 경우 1번 과정을 반복하면서 값을 복사하지 않아도 됩니다.
			중간에서 값을 삭제하거나 삽입을 진행할 때, 1번의 복사 과정을 반복하는 것은 부담스러운 연산과정이므로 되도록이면 1번 복사과정을 최소화 하도록 해야한다. 
			값을 인덱스 0에서부터 지우면 다 지워지지도 않고, 성능도 안좋음
			
			중간에 값을 삭제하는 방법 (삭제과정 반대)
			1. 삽입하고자하는 인덱스에서부터 값을 뒤쪽으로 한칸씩 이동시킨다.
			2. 데이터가 모두 한 칸씩 뒤로 이동했으므로 삭제하고자 하는 위치에는 복사 전 기존데이터가 남아있게 되는데 이 위치에 삽입하고자 하는 값을 넣는다. 
			3. size를 1증가시킨다.
		*/
		
		
		
		
		//Iterator
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
		}
		//1회용이다. 한 번다 끝까지 읽었으면 다시 it객체를 얻어와야 한다.
		//자료구조는 변경될 수 도 있지만, 그때마다 반복의 내용을 수정하지 않아도됨.
		
		//인터페이스 참조형으로 업캐스팅해서 선언하면 장점
		/*
		 	예를 들어 성능의 문제로 코드 개발 중간에 자료구조를 바꿔야 할 수 도 있다. 
		 	이럴때, 구현클래스가 공통적으로 상속받은 인터페이스를 참조자료형으로 사용하면, 
		 	공통적인 메소드만 사용하기 때문에, 자료구조의 변경이 쉽다. 
		 	그리하여 자료구조를 변경했을때, 공통적으로 사용하는 메소드만 재정의했기때문에, 
		 	코드를 검토할 필요가 없다. (그냥 처음부터 참조자료형을 구현 클래스로 썼다면, 혹시나 
		 	자료구조를 바꾸었을 때, 바꾸기 이전 클래스에서만 사용할 수 있는 메소드로 구현한 기능은 없는지 검토해야 한다.)
		 	
		 	하지만, 공통적인 메소드로만 사용해야 한다는 단점은 있음
		 	
		 	map에는 iterator가 없다. 
		 	가장 조상 collection인터페이스를 상속받는 것은 list, queue, set이다. 
		 	그래서 map을 컬렉션으로 안보는 거임
		 	따라서 map을 iterator로 조회할 때는, keyset, entryset, values처럼 
		 	반환값이 set인 메소드를 사용해서 iterator를 사용해야 함
		*/
		
		/*
		 * Map map = new HashMap();
		 * 
		 * Iterator it1 = map.entrySet().iterator();
		 */
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		/*
		 * map.put("1", 0); map.put("1", 1); map.put("2", 2); map.put("3", 3);
		 */
		
		map.put("1", map.getOrDefault("1", 0)+1);
		map.put("1", map.getOrDefault("1", 0)+1);
		map.put("2", map.getOrDefault("2", 0)+1);
		map.put("3", map.getOrDefault("3", 0)+1);
		
		for(String s : map.keySet()) {
			System.out.print(map.get(s) + " ");
		}
		
		
		
		
		
		
	}
}
