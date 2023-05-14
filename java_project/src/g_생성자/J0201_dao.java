package g_생성자;

public class J0201_dao {
	
	void dtoPrint(J0201_dto[] dto) {
		for(int k=0; k<dto.length; k++) {
		System.out.println((k+1)+"번째 분의 성함 :"+dto[k].name);
		System.out.println((k+1)+"번째 분의 지역:"+dto[k].area);
		System.out.println((k+1)+"번째 분의 나이:"+dto[k].age);
		System.out.println((k+1)+"번째 분의 학력:"+dto[k].edu);
		System.out.println();
		}
	}
		
	
	J0201_dto getDto (String name, String area, String edu, int age) {
		J0201_dto dto = new J0201_dto(name, area, edu, age);
		return dto;
	}
	
	String getAreaName(String fString) {
		String area = "";
		switch (fString) {
		case "S" : case "s" :
			area = "서울";
			break;
		case "D" : case "d" :
			area = "대전";
			break;
		case "C" : case "c" :
			area = "청주";
			break;
		case "B" : case "b" :
			area = "부산";
			break;
		default :
			area = "지역없음";
		}		
		return area;
	}
	
	String getEduName(String fString) {
		String edu = "";
		switch (fString) {
		case "M" : case "m" :
			edu = "중졸";
			break;
		case "H" : case "h" :
			edu = "고졸";
			break;
		case "U" : case "u" :
			edu = "대졸";
			break;
		default :
			edu = "그 외의 학력";
			break;
		}
		return edu;
	}
	
	
}
