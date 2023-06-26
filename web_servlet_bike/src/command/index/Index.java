package command.index;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.NoticeDao;
import dao.ProductDao;
import dto.NoticeDto;

public class Index implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao pDao = new ProductDao();
		ArrayList<String[]> pArr = pDao.getMainImage();
		request.setAttribute("t_pArr", pArr);
		
		NoticeDao nDao = new NoticeDao();
		ArrayList<String[]> nArr = nDao.indexDB();
		request.setAttribute("t_nArr", nArr);
		
		
	}

}
