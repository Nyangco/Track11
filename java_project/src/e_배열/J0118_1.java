package e_배열;

public class J0118_1 {

	public static void main(String[] args) {
		String[] aa = {"홍길동","대전","25"};
		
		String[][] str ={
						{"홍길동","대전","25"}, 
						{"이상화","서울","30"}
						};
		//다중배열에선 중괄호로 차원구분, 쉼표로 다음으로 넘어가는 기능을 넣는다.
		
		int[][] score = {
							{10,20,30,40,50},
							{100,200,300,400}
						};
		
		int[] sum = new int[2];
		for(int k=0; k<score.length;k++) {
			for(int i=0; i<score[k].length;i++) {
				System.out.print(score[k][i]+"\t");
				sum[k]+=score[k][i];
			}
			System.out.print(sum[k]);
			System.out.println("");
		}
		// 배열로 만들지 말고 1차 반복문 안에 정수형 변수로 선언하면 최적화가 좋을듯
		
	}
	
}
	

