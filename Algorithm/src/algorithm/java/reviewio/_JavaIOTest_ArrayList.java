package algorithm.java.reviewio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class _JavaIOTest_ArrayList {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		PersonVo p = new PersonVo("홍길동", 20, "서울시 마포구 서교동");
		
		
		List<PersonVo> list = new ArrayList<>();
		
		//직렬화 -> ArrayList저장 (ArrayList도 직렬화대상이 됨)
		list.add(new PersonVo("홍길동", 25, "서울시 마포구 서교1동"));
		list.add(new PersonVo("일길동", 24, "서울시 마포구 서교1동"));
		list.add(new PersonVo("이길동", 23, "서울시 마포구 서교1동"));
		list.add(new PersonVo("삼길동", 22, "서울시 마포구 서교1동"));
		list.add(new PersonVo("사길동", 21, "서울시 마포구 서교1동"));
		
		OutputStream os = new FileOutputStream("list.dat"); //1
		
		///직렬화할 때, 객체에 대한 정보, 객체 타입(분해), 객체를 복원시키기위한 데이터... 모두 저장
		//직렬화 처리객체로 연결
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//직렬화 -> 데이터 분해
		oos.writeObject(list);
		
		
		//열린 역순으로 닫아야함
		os.close();
		oos.close();
		
		
		//읽어들일 때는 objectinputstream으로 읽어야한다. -> outputstream으로 분해한 데이터느 사람이 못 읽음
		//input으로 데이터 조립해서 봐야 우리가 읽을 수 있음 -> 분해된 데이터 우리가 임의로 수정하면, 데이터가 파손되서 나중에 조립할 때 오류 생김
		
		//파일을 읽어들이는 객체 생성
		InputStream is = new FileInputStream("person_arr.dat");
		
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//역직렬화 -> 데이터 조립
		//읽어올 때는 해당 자료형으로 캐스팅
		//object는 최상위클래스이기때문에, 읽어들일 데이터의 타입으로 다운캐스팅(영역확장)을 해야 오류 안 뜸
		List<PersonVo> list2 = (List<PersonVo>)ois.readObject();
		
		
		System.out.println("---데이터 복원 : 역직렬화---");
		
		for(PersonVo v : list2) {
			System.out.println(v);
		}
		
		ois.close();
		is.close();
		
	}
}