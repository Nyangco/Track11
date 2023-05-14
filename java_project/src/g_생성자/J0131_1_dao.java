package g_생성자;

public class J0131_1_dao {

	J0131_1_dto getDto(String name, int kor, int eng, int mat) {
		J0131_1_dto dto = new J0131_1_dto(name, kor, eng, mat);
//		return 타입이 class이면 객체 생성자를 통해 생성된 맞는 class type의 주소를 return 해야한다.
//		dto.setName(name);
//		dto.setKor(kor);
//		dto.setEng(eng);
//		dto.setMat(mat);
		
		
		
		return dto; 
	}
	
	void setTotal(J0131_1_dto dto) {
		int total = dto.getEng()+dto.getKor()+dto.getMat();
		dto.setTotal(total);
	}
	
	void setAve(J0131_1_dto dto) {
		int ave = (dto.eng+dto.kor+dto.mat)/3;
		dto.setAve(ave);
	}
	
	void dtoPrint(J0131_1_dto dto) {
		System.out.println("성명 : "+dto.name);
		System.out.println("국어 점수 : "+dto.kor);
		System.out.println("영어 점수: "+dto.eng);
		System.out.println("수학 점수: "+dto.mat);
		System.out.println("총점: "+dto.total);
		System.out.println("평균: "+dto.ave);
	}
	
	void dtoArrPrint(J0131_1_dto[] arr) {
		for(int k=0; k<arr.length; k++) {
			System.out.println((k+1)+"번째 name : "+arr[k].name);
			System.out.println((k+1)+"번째 total : "+arr[k].total);
			System.out.println((k+1)+"번째 ave : "+arr[k].ave);
		}
	}
}
