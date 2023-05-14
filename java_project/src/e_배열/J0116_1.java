package e_배열;

import java.util.Scanner;

public class J0116_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0; 
		String inputName = "";
		String[] name = { "이상민", "박만수", "이찬우", "김성식", "김지우", 
                 "김인수", "안상수", "이미옥", "백현수", "이찬우", 
                 "허상수", "김이우", "김미순",   "허정우", "임민수", 
                 "윤석민", "안태정", "최순실", "송민수", "강유현", 
                 "강민기", "신강식", "허준용", "김형수", "안강현" };
//		
//		System.out.print("성함을 입력해주세요");
//		inputName = sc.next();

		for(int k=0; k<name.length; k++) {
			if(name[k]=="최순실") num1 = k;
		}
		
		System.out.println("최순실 은  "+(num1+1)+"번째에 있습니다.");
		
		for(int k=0; k<name.length; k++) {
			if(name[k].indexOf("최순실") != -1) num1 = k;
		}
		
		System.out.println("최순실 은  "+(num1+1)+"번째에 있습니다.");

		num1 = 0;
		for(int k=0; k<name.length; k++) {
			if(name[k].indexOf("김") != -1) num1++;
		}
		
		System.out.println("김 은 "+(num1)+"명 있습니다");
		
		System.out.print("이름을 입력해주세요");
		inputName = sc.next();
		
		num1=0;
		for(int k=0; k<name.length; k++) {
			if(name[k].indexOf(inputName)!=-1) num1++; 
		}
		System.out.println(inputName+" 은  "+(num1)+"명 있습니다.");
		
	}
}
