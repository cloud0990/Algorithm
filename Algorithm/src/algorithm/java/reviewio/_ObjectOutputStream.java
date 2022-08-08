package algorithm.java.reviewio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class _ObjectOutputStream {

	public static void main(String[] args) throws Exception {
		
		/*//직렬화 -> 저장
		PersonVo p = new PersonVo("홍길동", 20, "서울시 관악구 봉천동");
		
		//                                     PersonVo를 person.dat이라는 이름으로 저장
		OutputStream os = new FileOutputStream("person.dat");
		
		//직렬화 처리객체로 연걸(필터링)
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//직렬화
		oos.writeObject(p);
		
		//닫기는 열린 역순으로 닫는다
		oos.close();
		os.close();
		*/
		
		
		//역질렬화 -> 읽기(복원)
		//ObjectOutputStream으로 직렬화한 객체는, 반드시 ObjectInputStream으로 읽어야한다
		InputStream is = new FileInputStream("person.dat");
		
		//역직렬화 객체 -> ObjectInputStream
		//파일을 is로 읽고, ois를 사용해서 객체로 필터링함
		ObjectInputStream ois = new ObjectInputStream(is);
		
		
		//읽어오기           읽어올 때 분해되어 저장된 데이터가 무슨 타입인지 모르니까, 반환할 때 object타입으로 반환한다   
		PersonVo p1 = (PersonVo)ois.readObject();
		//             readObject가 Object로 반환하는데, object는 최상위 클래스이기때문에, 역직렬화할 데이터의 타입으로 다운캐스팅(영역확장)을 해줘야한다
		
		System.out.println(p1);
		
		
		//닫기 -> 열린역손
		ois.close();
		is.close();
		
		
		
		
		
		
	}
}