package algorithm.java.reviewcollectionex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapEx {
	
	public static void main(String[] args) {

		HashMap map = new HashMap();
		
		//예제 1 - > 회원가입
		/*
		 * map.put("myID", "1234"); map.put("asdf", "1111"); map.put("asdf", "1234");
		 * System.out.println(map);
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * while (true) { System.out.println("id와 password를 입력하세요.");
		 * System.out.print("id : "); String id = sc.nextLine().trim();
		 * 
		 * System.out.print("id : "); String pwd = sc.nextLine().trim();
		 * System.out.println();
		 * 
		 * if(!map.containsKey(id)) {
		 * System.out.println("입력하신 id는 존재하지 않습니다. 다시입력해주세요."); continue; }
		 * 
		 * if(!map.get(id).equals(pwd)) {
		 * System.out.println("비밀번호가 일치하지 않습니다. 다시입력해주세요."); continue; }else {
		 * System.out.println("아이디와 비밀번호가 일치합니다."); break; } }
		 */
		
		
		//예제 2 -> 성적정보 구하기
		/*
		 * map.put("김자바", new Integer(90)); map.put("김자바", new Integer(100));
		 * map.put("이자바", new Integer(100)); map.put("강자바", new Integer(80));
		 * map.put("안자바", new Integer(90));
		 * 
		 * //맵은 이터레이터 사용불가 Set set = map.entrySet(); Iterator it = set.iterator();
		 * 
		 * while(it.hasNext()) { //Map : 인터페이스, Entry : Map의 내부 인터페이스. 하나의 객체 타입이다.
		 * Map.Entry e = (Map.Entry)it.next(); //object타입을 반환(외우자)하므로 형변환
		 * System.out.println("이름 : " + e.getKey() + ", 점수 " + e.getValue()); }
		 * 
		 * set = map.keySet(); System.out.println("참가자 명단 : " + set);
		 * 
		 * Collection values = map.values(); //반환타입 Collection it = values.iterator();
		 * 
		 * int total = 0;
		 * 
		 * while(it.hasNext()) { int i = (int) it.next(); //Integer, int 둘 다 가능 total +=
		 * i; }
		 * 
		 * System.out.println("총점 : " + total); System.out.println("평균 : " +
		 * (float)total/set.size()); System.out.println("최고점수 : " +
		 * Collections.max(values)); System.out.println("최저점수 : " +
		 * Collections.min(values));
		 */
		
		
		
		//예제 3 -> 빈도수 구하기 
		String data[] = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		
		for(int i=0; i< data.length; i++) {
			if(map.containsKey(data[i])) {
				int value = (int)map.get(data[i]);
				map.put(data[i], value + 1);
			} else {
				map.put(data[i], 1);
			}
		}
		
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String str = (String)it.next();
			int value = (int)map.get(str);
			System.out.println(str + " : " + printBar("#", value) + " " + value);
		}
		
		
		
		  Map<Integer, String> Tmap = new TreeMap<>(); 
		  Map<Integer, String> Hmap = new HashMap<>();
		  
		  Tmap.put(3, "val"); //[3,"val"];
		  Tmap.put(5, "val"); //[5,"val"]
		  Tmap.put(7, "val"); 
		  Tmap.put(9,"val"); 
		  Tmap.put(12, "val"); 
		  Tmap.put(141, "val"); 
		  Tmap.put(167, "val");
		  Tmap.put(1242, "val"); 
		  Tmap.put(12983, "val");
		  
		  Hmap.put(3, "val"); 
		  Hmap.put(5, "val"); 
		  Hmap.put(7, "val"); 
		  Hmap.put(9, "val"); 
		  Hmap.put(12, "val"); 
		  Hmap.put(141, "val"); 
		  Hmap.put(167, "val");
		  Hmap.put(1242, "val"); 
		  Hmap.put(12983, "val");
		  
		  System.out.println("TreeMap = " + Tmap.keySet().toString());
		  System.out.println("HashMap = " + Hmap.keySet().toString());
		  
		  // Map을 전체 순회하는 방법
		  
		/*  map에는 iterator가 없다. 가장 조상 collection인터페이스를 상속받는 것은 list, queue, set이다. 그래서
		  map을 컬렉션으로 안보는 거임 따라서 map을 iterator로 조회할 때는, keyset, entryset, values처럼 반환값이
		  set인 메소드를 사용해서 iterator를 사용해야 함*/
		  
		  
		  
		  //import java.util.Map.Entry; 
		  // 0. System.out.println()
		  System.out.println(Tmap); 
		  System.out.println(Hmap); 
		  // 1. EntrySet()
		  System.out.println("개선루프 엔트리셋(Tmap)"); 
		  for (Entry<Integer, String> entry :Tmap.entrySet()) { 
			  System.out.println("[Key] : " + entry.getKey() +"[value] : " + entry.getValue()); 
		  } 
		  
		  // 2. KeySet()
		  System.out.println("개선루프 키셋(Hmap)"); 
		  for(Integer i : Hmap.keySet()) {
			  System.out.println("[Key] : " + i + "[value] : " + Hmap.get(i)); 
		  }
		  
		  // 3.Iteraotor(1회성) 
		  System.out.println("이터레이터 엔트리셋(Tmap)");
		  Iterator<Entry<Integer, String>> entries = Tmap.entrySet().iterator();
		  while(entries.hasNext()) { 
			  Map.Entry<Integer, String> entry = entries.next();
			  System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue()); 
		  }
		  
		  //3-2 System.out.println("이터레이터 키셋(Hmap)"); 
		  Iterator<Integer> keys = Hmap.keySet().iterator(); 
		  while(keys.hasNext()) { 
			  int key = keys.next();
			  System.out.println("[Key] : " + key + " [Value] : " + Hmap.get(key));
		  }
		  
		  
		}

	private static String printBar(String string, int value) {

		String str = "";
		for (int i = 0; i < value; i++) {
			str += string;
		}
		return str;
	}

}
