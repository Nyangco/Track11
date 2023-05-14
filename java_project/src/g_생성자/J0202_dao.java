package g_생성자;

public class J0202_dao {
	
	void searchData(J0202_dto[] dto, String str){
		for(int k=0; k<dto.length; k++) {
			if(dto[k].getName().indexOf(str)!=-1) {
				System.out.println();
				System.out.println("사번 : "+dto[k].getIdNum());
				System.out.println("성명 : "+dto[k].getName());
				System.out.println("부서 : "+dto[k].getDepart());
				System.out.println("직위 : "+dto[k].getRank());
				System.out.println("급여 : "+dto[k].getPay());
				System.out.println();
			}
		}
		
		
	}

	void setPrint (J0202_dto[] dto) {
		for(int k=0; k<dto.length; k++) {
		System.out.println();
		System.out.println("사번 : "+dto[k].getIdNum());
		System.out.println("성명 : "+dto[k].getName());
		System.out.println("부서 : "+dto[k].getDepart());
		System.out.println("직위 : "+dto[k].getRank());
		System.out.println("급여 : "+dto[k].getPay());
		System.out.println();
		}
	}
	
	String getDepartName (String str) {
		switch (str) {
			case "C": case "c": case "ㅊ":
				return "총무";
			case "J": case "j": case "ㅓ":
				return "재무";
			case "Y": case "y": case "ㅛ":
				return "영업";
			default :
				return "타 부서";
		}
	}
	
	String getRankName (String str) {
		switch (str) {
			case "10":
				return "사원";
			case "20":
				return "대리";
			case "30":
				return "과장";
			default :
				return "기타 직위";
		}
	}
	
	int getPay (String depart, String rank) {
		int pay = 0;
		
		switch (depart){
		case "총무":
			pay+=1000000;
			break;
		case "재무":
			pay+=900000;
			break;
		case "영업":
			pay+=1200000;
			break;
		default:
		}
		
		switch (rank) {
		case "사원":
			pay+=200000;
			break;
		case "대리":
			pay+=300000;
			break;
		case "과장":
			pay+=400000;
			break;
		default:
		}
		
		if(depart.equals("타 부서") || rank.equals("기타 직위")) pay = 0;
		
		return pay;
	}

}
