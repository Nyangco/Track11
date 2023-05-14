package g_생성자;

import java.util.Scanner;

public class J0201_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		J0201_student[] stu = new J0201_student[2];
		
		for(int k=0; k<stu.length; k++) {
			System.out.print("이름? :");
			String name = sc.next();
			System.out.print("id? :");
			String id = sc.next();
			
			J0201_student temp = new J0201_student(name,id);
			stu[k] = temp;
//			J0201_student temp = new J0201_student();
//			stu[k].setId(id);
//			stu[k].setName(name);
			
		}
		
		for(int k=0; k<stu.length; k++) {
			System.out.println((k+1)+"번째 학생 이름 :"+stu[k].getName());
			System.out.println((k+1)+"번째 학생 id :"+stu[k].getId());
		}
	}
}
