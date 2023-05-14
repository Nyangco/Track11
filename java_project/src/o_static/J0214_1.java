package o_static;

public class J0214_1 {
	
//	Integer class의 method들은 전부 static이 붙어있다!
//	->별도의 선언 없이도 사용이 가능하다

	public static void main(String[] args) {
		J0214_1_sub sub = new J0214_1_sub();
		
		int total = sub.getTotal(10, 20);

		
	}
}
