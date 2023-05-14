package n_exception;

public class J0213_1 {
//	NumberFormatException -> 클래스파일.
//	여러 exception들은 대체로 java.lang package-> class 파일을 만들 때 자동으로 import된다.
//	try{} catch() {} -> try 영역 안에서 () 안의 조건에 해당하는 오류가 발생하면, catch{}에 해당하는 실행문이 실행된다. 
//	try안에서 catch()에 해당하는 오류가 실행될 경우, 차후의 실행문은 무시하고 곧바로 catch{}로 넘어간다.
//	특정 오류를 shooting할땐 ()()Exception 으로 지정해줘야 하지만, 모든 Exception을 표현하고자 할 땐 catch(Exception e) 같은 식으로 사용가능하다.
//	==> 모든 Exception들의 부모클래스가 Exception으로 연결되어있음.
//	finally => 오류의 발생여부를 떠나서 무조건 실행하는 명령어.
//	Querry문의 오류가 있을 때, 어디서 문제가 있는지 확인하고자 사용하는 명령어단

	public static void main(String[] args) {
		System.out.println("시스템 시작");
		String kor = "백";

		int korNum = 0;
		try {
			System.out.println("Error site 1");
			korNum = Integer.parseInt(kor);
			System.out.println("Error site 2");
		}catch(Exception e) {
			System.out.println("오류");
		}finally {
			System.out.println("finally");
		}
		
		System.out.println(korNum);
		
		System.out.println("시스템 종료");
	}
}
