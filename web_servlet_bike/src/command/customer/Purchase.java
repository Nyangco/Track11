package command.customer;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import common.MailContentSend;
import dao.CustomerDao;
import dto.CustomerDto;

public class Purchase implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String email = request.getParameter("t_email");
		String shipping_method = request.getParameter("t_shipping_method");
		String shipping_method_name = "";
		if(shipping_method.equals("byhand")) shipping_method_name="직접 수령";
		else shipping_method_name="택배 배송";
		String address = request.getParameter("t_address");
		String comment = request.getParameter("t_comment");
		String buy_method = request.getParameter("t_buy_method");
		String buy_method_name = "";
		if(buy_method.equals("cash")) buy_method_name = "현금 결제";
		else buy_method_name="카드 결제";
		String credit_1 = request.getParameter("t_credit_1");
		String credit_2 = request.getParameter("t_credit_2");
		String credit_3 = request.getParameter("t_credit_3");
		String credit_4 = request.getParameter("t_credit_4");
		String cvc = request.getParameter("t_cvc");
		String transfer_name = request.getParameter("t_transfer_name");
		String p_no = request.getParameter("t_p_no");
		String p_name = request.getParameter("t_p_name");
		String cPrice = request.getParameter("t_total_fee");
		String price = cPrice.replaceAll(",", "").trim();
		String today = CommonUtil.getToday();
		today = today.substring(2).replaceAll("-", "").trim();
		String purchase_number = dao.getMaxNo(today);
		String purchase_date = CommonUtil.getTodayTime();
		String status = null;
		if(buy_method.equals("cash")) status="1";
		else status="2";
		String mailing = request.getParameter("t_mailing");
		String header = "<legend style=\"width:140px;margin-left:456px;\">JSL 산악자전거협회</legend><table width=\"600\">" + 
				"<colgroup><col width=\"20%\"/><col width=\"80%\"/></colgroup>" + 
				"<tr style=\"border:none; padding:30px 0; margin-bottom:20px; display:inline-block; width:596px; height:40px;\">" + 
				"<th colspan=\"2\" style=\"font-size:23px; padding-bottom:30px; width:596px; border:none; text-align:center; display:block;\">" + 
				"JSL 산악자전거협회에서 구매하신 상품의 영수증입니다" + 
				"</th></tr><tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">주문 번호</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+purchase_number+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">구매 일자</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+purchase_date+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">주문 상품</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+p_name+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">배송 방법</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+shipping_method_name+"</td></tr>";
		String body ="<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">받는분 성함</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+name+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">받는분 연락처</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+mobile_1+"-"+mobile_2+"-"+mobile_3+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">받는분 주소</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+address+"</td></tr>";
		String tail ="<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">요청 사항</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+comment+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">결제 수단</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+buy_method_name+"</td></tr>" + 
				"<tr style=\"border-bottom:solid 1px black; margin-bottom:20px; display:inline-block; width:596px;height:40px;\">" + 
				"<th style=\"width:120px;text-align:center;display:block;border-right:solid black 1px;float:left;\">가격</th>" + 
				"<td style=\"display:block;width:465px;float:right;\">"+cPrice+"</td></tr></table></fieldset>";
		if(mailing!=null) {
			try {
				String mailSet_Server="smtp.mail.nate.com"; // 보내는 메일 server
				String mailSet_ID="ysm951204";        // 보내는 메일 ID
				String mailSet_PW="tjrah124";        // 보내는 메일 비밀번호
				
				
				
				String mailFromName ="JSL 산악자전거협회";            // 보내는 사람 이름
				String mailFromAddress ="ysm951204@nate.com"; // 보내는 메일 주소
				
				String mailTo    = email;           // 받는  메일 주소
				String mailTitle ="JSL 산악자전거협회 구매 영수증";   // 메일 제목
				String content = header;                     // 메일내용
				if(shipping_method.equals("shipping")) content+=body;
				content+=tail;
				
				MailContentSend mail = new MailContentSend();
				mail.setMail(mailSet_Server, mailSet_ID, mailSet_PW);
				mail.sendMail(mailFromName, mailFromAddress, mailTo, mailTitle, content);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		CustomerDto dto = new CustomerDto(id, name, mobile_1, mobile_2, mobile_3, email, shipping_method, address, comment, buy_method, credit_1, credit_2, credit_3, credit_4, cvc, transfer_name, purchase_number, p_no, status, price, purchase_date);
		int k = dao.insertDB(dto);
		String msg = "상품 구매에 실패하였습니다."; String url = "Customer"; String nextPage="list";
		if(k==1) {
			msg = "상품 구매에 성공하였습니다.";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
		
		
	}

}
