package common;

import dao.NewsDao;
import dao.QnaDao;
import dto.NewsDto;
import dto.QnaDto;

public class temp {

	public static void main(String[] args) {
		QnaDao dao = new QnaDao();
		for(int k=0; k<60; k++) {
			String no = dao.getMaxNo();
			String title = Integer.toString(k);
			String content = Integer.toString(k);
			String reg_id = "pakgildong";
			String reg_date = CommonUtil.getTodayTime();
			QnaDto dto = new QnaDto(no,"",reg_id,title,content,"",reg_date,"","",0);
			dao.insertDB(dto);
		}
	}

}
