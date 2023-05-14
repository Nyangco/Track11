package e_배열;

public class J0113_1 {

	public static void main(String[] args) {
		
		int[] aa = new int[4];
		for (int k=0; k<=3;k++) aa[k]=(k+1)*10;
		
		String[] bb = new String[3];
		bb[0] = "가가가";
		bb[1] = "나나나";
		bb[2] = "다다다";
		
		for (int i=0; i<bb.length; i++) System.out.println(bb[i]);
		// blank 와 null은 다르다 - 출력시에 blank는 빈칸이 생기지만 null은 아무 값도 입력되지 않는다.
		
	}
}
