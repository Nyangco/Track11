package g_생성자;

public class J0206_2_dao {
	
	void printDto(J0206_2_dto dto) {
		System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMat()+"\t"+dto.getAve()+"\t"+dto.getResult());
	}
	
	void indexArr() {
		System.out.println("---------------------------------------------------");
		System.out.println("ID\t성함\t국어 점수\t영어 점수\t수학 점수\t평균\t결과");
		System.out.println("---------------------------------------------------");
	}
	
	void printArr(J0206_2_dto[] arr) {
		indexArr();
		for(int k=0; k<arr.length; k++) printDto(arr[k]);
		System.out.println("---------------------------------------------------");
	}
	
	String getResult(int a, int b, int c) {
		double ave = getAve(a,b,c);
		if(ave>=80 && a>=60 && b>=60 && c>=60) return "합격";
		else return "불합격";
	}
	
	double getAve(int a, int b, int c) {
		double temp = (a+b+c)/3.0;
		return Math.round(temp*100)/100.0;
	}

}
