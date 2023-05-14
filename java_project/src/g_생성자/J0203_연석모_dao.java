package g_생성자;

public class J0203_연석모_dao {
	
	String getPass(double dou) {
		if(dou>=80) return "합격";
		else return "불합격";
	}
	
	void printDto(J0203_연석모_dto dto) {
		System.out.println(dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMat()+"\t"+dto.getAve()+"\t"+dto.getPass());
	}
	
	void printArr(J0203_연석모_dto[] arr) {
		System.out.println("---------------------------------------------");
		System.out.println("성명\t국어\t영어\t수학\t평균\t결과");
		for(int k=0; k<arr.length; k++) {
			System.out.println("---------------------------------------------");
			printDto(arr[k]);
		}
		System.out.println("---------------------------------------------");
	}
	
	double getAve(int a, int b, int c) {
		double result = (a+b+c)/3.0;
		return (double)Math.round(result*100)/100.0;
	}
	
	boolean checkScore(int k) {
		if(k<0 || k>100) {
			System.out.println("점수를 잘못 입력하셨습니다.");
			return true;
		}
		
		else return false;
	}

	public void searchDto(J0203_연석모_dto[] arr, String str) {
		System.out.println("---------------------------------------------");
		System.out.println("성명\t국어\t영어\t수학\t평균\t결과");
		System.out.println("---------------------------------------------");
		for(int k=0; k<arr.length; k++) {
			if(arr[k].getName().indexOf(str)!=-1) {
				printDto(arr[k]);
			}else {
				System.out.print("결과 없음");
				System.out.println("---------------------------------------------");
			}
		}
		
	}

}
