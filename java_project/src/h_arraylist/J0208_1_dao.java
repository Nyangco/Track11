package h_arraylist;

import java.util.ArrayList;

public class J0208_1_dao {
	
	void getRank(ArrayList<J0208_1_dto> arr) {
		int temp1 = 0;
		int[] num = new int[arr.size()];
		
		for(int k=0; k<arr.size(); k++) {
			for(int i=0; i<arr.size(); i++) {
				if(arr.get(k).getTotal()>arr.get(i).getTotal()) {
					num[k]++;
				}
			}
		}

		
		for(int k=0; k<arr.size(); k++) {
			arr.get(k).setRank(num.length-num[k]);
		}
		
	}
	
	void printIndex() {
		System.out.println("===================================================================");
		System.out.println("학년\t반\t번호\t성명\t국어\t영어\t수학\t평균\t석차");
		System.out.println("===================================================================");
	}
	
	void printDto(J0208_1_dto dto) {
		System.out.print(dto.getGrade()+"학년\t");
		System.out.print(dto.getBan()+"반\t");
		System.out.print(dto.getNumber()+"번\t");
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getKor()+"점\t");
		System.out.print(dto.getEng()+"점\t");
		System.out.print(dto.getMat()+"점\t");
		System.out.print(dto.getTotal()+"점\t");
		System.out.println(dto.getRank()+"등");
	}

	void printArrList(ArrayList<J0208_1_dto> arr) {
		int totalKor=0, totalEng=0, totalMat=0;
		double aveKor=0.0, aveEng=0.0, aveMat=0.0;
		printIndex();
		for(int k=0; k<arr.size(); k++) {
			printDto(arr.get(k));
			totalKor+=arr.get(k).getKor();
			totalEng+=arr.get(k).getEng();
			totalMat+=arr.get(k).getMat();
		}
		aveKor=(double)totalKor/3.0;
		aveKor=(Math.round(aveKor*100))/100.0;
		aveEng=(double)totalEng/3.0;
		aveEng=(Math.round(aveEng*100))/100.0;
		aveMat=(double)totalMat/3.0;
		aveMat=(Math.round(aveMat*100))/100.0;
		System.out.println("===================================================================");
		System.out.println("총 "+arr.size()+"명\t\t\t\t"+totalKor+"점\t"+totalEng+"점\t"+totalMat+"점");
		System.out.println("===================================================================");
		System.out.println("평균\t\t\t\t"+aveKor+"\t"+aveEng+"\t"+aveMat+"\t");
		System.out.println("===================================================================");
	}
	
	
}
