package algorithm.java.reviewcollection;

import java.util.LinkedList;
import java.util.Queue;

public class _Queue {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		//Queue에 값을 추가한다 add() / offer()
		q.add(1);
		q.add(2);
		q.add(3);
		q.offer(4);
		q.offer(5);
		
		
		//peek()
		//Queue의 가장 첫번 째로 저장된 값을 반환한다.
		System.out.println(q.peek());
		//결과 : 1
		
		//peek() 메소드를 사용하면, 가장 첫번 째로 저장된 값을 반환만 할 뿐, 삭제되지않는다.
		System.out.println(q);
		
		//값 삭제
		// poll() / remove()
		
		//poll() : 첫번째 값 반환 후 제거 / Queue가 비어있으면 null반환
		q.poll();
		System.out.println(q);
		//결과 : [2, 3, 4, 5]
		
		//remove() : 첫번쨰 값 제거
		q.remove();
		System.out.println(q);
		
		
		//clear() : Queue의 모든 값 초기화(삭제)
		q.clear();
		System.out.println(q);
		
		
		
	}
}