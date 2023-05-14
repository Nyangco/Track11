package g_생성자;

import java.util.Scanner;

public class J0130_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0130_student stu = new J0130_student();
		J0130_1_dao dao = new J0130_1_dao();
//		이름, 국어점수, 영어점수, 수학점수 Question -> 총점, 평균 dao로 구한 뒤 dto 생성(기본)해서 setter로 값 저장 - 출력
		
		String name ="";
		int kor = 0, eng = 0, mat = 0, total = 0, ave = 0;
		
		System.out.print("성함 :");
		name = sc.next();
		System.out.print("국어 점수 :");
		kor = sc.nextInt();
		System.out.print("영어 점수 :");
		eng = sc.nextInt();
		System.out.print("수학 점수:");
		mat = sc.nextInt();
		
//		total = dao.getTotal(kor, eng, mat);
//		ave = dao.getAve(total, 3);
		
		stu.setName(name);
		stu.setKor(kor);
		stu.setEng(eng);
		stu.setMat(mat);

		total = dao.getTotal(stu);
		stu.setTotal(total);
		ave = dao.getAve(stu);
		stu.setAve(ave);
		
		System.out.println(ave);
		
		
		
//		dao.getSetTotal(stu);
//		dao.getSetAve(stu);
//		매개변수로 넘길 수 있는 값에는 특정 힙영역 값의 주소도 가능하다! - object 타입
//		이렇게 넘기게 되면, 해당 인스턴스의 필드값 뿐 아니라 여러 method에도 접근이 가능해진다.
//		stu.setAve(ave);
		
		System.out.println("name :"+stu.getName());
		System.out.println("kor :"+stu.getKor());
		System.out.println("eng :"+stu.getEng());
		System.out.println("mat :"+stu.getMat());
		System.out.println("total :"+stu.getTotal());
		System.out.println("ave :"+stu.getAve());
		
		
		
		
		
		
	}
}
