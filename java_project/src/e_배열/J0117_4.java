package e_배열;

public class J0117_4 {

	public static void main(String[] args) {
		String[] str = {"홍길동", "50", "60", "70"};
		//출력 : 홍길동 총점 180
		
		int total = 0;
		
		for(int k=1; k<str.length; k++) {
			total += Integer.parseInt(str[k]);
		}
		System.out.println(str[0]+" 총점 "+total);
		total = 0;
		
		String[] score = new String[str.length+1];
		for(int k=0; k<str.length; k++) {
			score[k] = str[k];
			if(k>=1) total += Integer.parseInt(score[k]);
		}
		score[str.length] = Integer.toString(total);
		
		for(int k=0; k<score.length;k++) System.out.print(score[k]+"\t");
	}
}
