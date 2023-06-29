package command.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;
import dao.ProductDao;
import dto.MemberDto;
import dto.ProductDto;

public class Buy implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao pDao = new ProductDao();
		MemberDao mDao = new MemberDao();
		HttpSession session = request.getSession();
		
		String p_no = request.getParameter("t_p_no");
		if(p_no==null || p_no.equals("")) {
			System.out.println("Catched");
			p_no = (String)request.getAttribute("t_p_no");
		}
		System.out.println(p_no);
		ProductDto pDto = pDao.productBuy(p_no);
		request.setAttribute("t_pDto", pDto);
		
		String pnc = pDto.getPrice().replaceAll(",", "");
		request.setAttribute("t_pnc", pnc);
		
		String sId = (String)session.getAttribute("sId");
		MemberDto mDto = mDao.memberBuy(sId);
		request.setAttribute("t_mDto", mDto);
		
	}

}
