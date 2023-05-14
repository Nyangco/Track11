package n_exception;

public class J0213_4_sub {

	int getTotal(String a, String b) {
		int total = 0;
		try {
			total=Integer.parseInt(a)+Integer.parseInt(b);
		} catch(Exception e) {
			System.out.println("오류 발생");
		}
		return total;
	}
	
	int getAve(int a, String b) throws Exception{
		int ave = 0;
//		try {
		ave = a/Integer.parseInt(b);
//		} catch(Exception e) {
			System.out.println("타입 변환 에러");
//		}
		return ave;
	}
}
