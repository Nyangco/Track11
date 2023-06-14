package command.news;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;

public class Write implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("t_today", CommonUtil.getToday());
	}

}
