package algorithm.java.reviewcollectionex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> list = new LinkedList<Integer>();
		
		
		//LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		
		/*
		Set
		순서x, 중복x
		HashSet
		Set인터페이스를 구현한 대표적인 컬렉션 클래스 
		순서를 유지하려면 LinkedHashSet을 사용하면 된다.
		TreeSet
		범위 검색과 정렬에 유리한 컬렉션 클래스
		HashSet보다 데이터 추가, 삭제에 시간이 더 소요됨
		
		*/
		
		//생성자
		/* 
		기본 생성자
		public HashSet() {
        map = new HashMap<>();
    	}
		
		지정된 컬렉션 c에 모든 객체를 저장하면서 set 생성
	    public HashSet(Collection<? extends E> c) {
	        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
	        addAll(c);
	    }
	
		loadfactor의 값에 따라 용적을 증가시킨다.
	    public HashSet(int initialCapacity, float loadFactor) {
	        map = new HashMap<>(initialCapacity, loadFactor);
	    }
	
	  	
		초기 용량 설정해서 생성
	    public HashSet(int initialCapacity) {
	        map = new HashMap<>(initialCapacity);
	    }
		*/
		
		//추가 
		/*
		boolean add(Object o)
		boolean addAll(Collection c) 합집합
		boolean remove(Object o)
		boolean removeAll(Collection c) 컬렉션c에 있는 객체와 같은 객체만 삭제, 교집합
		boolean retainAll(Collection c) 조건부삭제. 컬렉션c에 있는 객체만 남기고 삭제. 차집합
		boolean clear() 모두 삭제 
		*/
		
		//검색
		/*
		boolean contains(Object o)
		boolean containsAll(Collections c) //컬렉션 c가 모두 포함되어 있는가?
		Iterator iterator()
		*/
		
		//기타 
		/*
		boolean isEmpty() 비었는지
		int size() 저장된 객체수
		Object[] toArray() 객체배열 반환
		Object[] toArray(Object[] a)
		*/
		
		//예제 1
		/*
		//중복데이터는 set에 추가 되지 않는다. 
		//1은 하나는 문자열, 하나는 integer이므로 둘 다 저장이 됩니다.
		//저장순서는 유지될 수도 안될수도 있지만, 저장 순서를 매번 보장하지 않는다.
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		
		Set hs = new HashSet();
		
		for(int i=0; i<objArr.length;i++) {
			//추가, 삭제 메소드는 정상 수행되면 true, 실패하면 false를 반환한다,
			System.out.println(objArr[i] + "=" +  hs.add(objArr[i])); //HashSet에 있는 objArr의 요소들을 저장한다.
		}
		
		//HashSet에 저장된 요소들을 출력한다.
		System.out.println(hs);
		
		//HashSet에 저장된 요소들을 출력한다.
		Iterator it = hs.iterator();
		
		//읽어올 요소가 남아있다면 반복해라 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		
		
		//예제 2
		/*
		 * Set set = new HashSet();
		 * 
		 * //set의 크기가 6보다 작은동안 1~45의 정수를 출력 for(int i=0; set.size()<6 ; i++) { int num =
		 * (int)(Math.random()*45)+1; set.add(num); }
		 * 
		 * ******List list = new LinkedList(set);//set은 정렬이 안되므로 set의 데이터를 list를 새로만들어서 옮긴다.
		 * Collections.sort(list);//정렬은 리스트만 가능합니다. System.out.println(list);
		 */
		
		//예제 3
		//HashSet은 객체를 저장하기 전에 기존에 같은 객체가 있는지 확인
		//같은 객체가 없으면 저장하고, 있으면 저장하지 않는다.
		//boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출하여 중복인지 확인한다.
		//일반적인 wrapper클래스들의 데이터는 비교기준이 기본적으로 정해져 있지만, 
		//사용자 정의 객체는 비교기준을 직접 명시해주어야 합니다.
		HashSet set = new HashSet();
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		
		System.out.println(set);
		
		HashSet set2 = new HashSet();
		set2.add(3);
		set2.add(6);
		set2.add(6);
		set2.add("aaa");
		set2.add("aaa");
		System.out.println(set2);
		
		HashSet set3 = new HashSet();
		set3.add(new Test3("길동", 12));
		set3.add(new Test3("길동", 12));
		System.out.println(set3);
	}
}
class Test3{
	String name;
	int age;
	
	public Test3(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Person {
	String name; 
	int age;
	
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + ":" + age; 
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Person) {
			Person tmp = (Person)obj;
			return name.equals(tmp.name) && age == tmp.age; 
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		//return (name+age).hashCode();
		return Objects.hash(name, age);
	}
}
