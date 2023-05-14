package g_생성자;

public class J0203_dao {
	void searchDto(J0203_dto[] dto,String str) {
		int cSum = 0;
		for(int k=0; k<dto.length; k++) {
			if(dto[k].getName().indexOf(str)!=-1) {
				printSingle(dto[k]);
				cSum++;
			}
		}
		if(cSum == 0) {
			System.out.println("찾고자 하는 문자열을 포함한 이름이 없습니다.");
		}
		
	}
	
	void printDto(J0203_dto[] arr) {
		for(int k=0; k<arr.length; k++) {
			printSingle(arr[k]);
		}
	}
	
	void printSingle(J0203_dto dto) {
		System.out.println("성함  : "+dto.getName());
		System.out.println("성별  : "+dto.getGender());
		System.out.println("나이  : "+dto.getAge());
		System.out.println("용돈  : "+dto.getMoney());
		System.out.println();
	}
	
	String getGenderName(String str) {
		String result="";
		switch (str) {
		case "m": case "M": case "ㅡ":
			result = "남자";
			break;
		case "f": case "F": case "ㄹ":
			result = "여자";
			break;
		default :
			result = "제 3의성";
		}
		return result;
	}
	
	int getMoney(String gender, int age) {
		int result = 0;
		int cSum = 0;
		
		switch (gender) {
		case "남자" :
			result+=100000;
			cSum++;
			break;
		case "여자" :
			result+=120000;
			cSum++;
			break;
		}
		
		if(age>=0 && age<=19) {
			result+=30000;
			cSum++;
		}
		else if(age>=20 && age<=24) {
			result+=50000;
			cSum++;
		}
		else if(age>=25) {
			result +=100000;
			cSum++;
		}
		
		if(cSum != 2) result = 0;
		return result;
	}

}
