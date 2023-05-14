package a_basic;

public class J0104_3 {
	public static void main(String[] args) {
		int kor = 85, eng = 70, mat = 60;
		int total = kor + eng + mat;
		System.out.println("총점은 "+total+"점 입니다.");
		
		double avg = total/3.0;
		System.out.println("평균은 "+avg+"점 입니다.");
		System.out.println("소숫점은 무조건 버려진다");
		System.out.println("double연산은 적어도 한쪽이 실수여야 한다.");
		
		
	}
}
