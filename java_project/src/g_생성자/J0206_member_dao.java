package g_생성자;

public class J0206_member_dao {

	//몸무게 <= (키-100) * 0.9
	
	void confirmStr(J0206_member_dto[] arr, String str) {
		indexArr();
		for(int k=0; k<arr.length; k++) {
			if(arr[k].getName().indexOf(str)!=-1) {
				printDto(arr[k]);
			} else System.out.println("검색 결과 없음");
			System.out.println("-----------------------------------");
		}
	}
	
	void printDto(J0206_member_dto dto) {
		System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getHeight()+"\t"+dto.getWeight()+"\t"+dto.getResult());
	}
	
	void indexArr() {
		System.out.println("-----------------------------------");
		System.out.println("ID\t성함\t키\t몸무게\t결과");
		System.out.println("-----------------------------------");
	}
	
	void printArr(J0206_member_dto[] arr) {
		indexArr();
		for(int k=0; k<arr.length; k++) printDto(arr[k]);
		System.out.println("-----------------------------------");
	}
	
	String getResult(double height, double weight) {
		double temp = (height-100)*0.9;
		if(weight >= temp) return "비만";
		else return "정상";
	}
	
	double confirmDouble(double a) {
		if(a<0.0) {
			System.out.println("음수를 입력하셨습니다.");
			return 0.0;
		}
		else return a;
	}
}
