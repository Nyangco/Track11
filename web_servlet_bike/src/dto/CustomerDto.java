package dto;

public class CustomerDto {
	private String id, name, mobile_1, mobile_2, mobile_3, email, shipping_method, address, comment, buy_method;
	private String credit_1, credit_2, credit_3, credit_4, cvc, transfer_name, purchase_number, product_number;
	private String status, price, purchase_date;
	
	
	//purchase_list 조회용
	public CustomerDto(String purchase_number, String product_number, String status, String price,
			String purchase_date) {
		super();
		this.purchase_number = purchase_number;
		this.product_number = product_number;
		this.status = status;
		this.price = price;
		this.purchase_date = purchase_date;
	}

	public CustomerDto(String id, String name, String mobile_1, String mobile_2, String mobile_3, String email,
			String shipping_method, String address, String comment, String buy_method, String credit_1, String credit_2,
			String credit_3, String credit_4, String cvc, String transfer_name, String purchase_number,
			String product_number, String status, String price, String purchase_date) {
		super();
		this.id = id;
		this.name = name;
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.mobile_3 = mobile_3;
		this.email = email;
		this.shipping_method = shipping_method;
		this.address = address;
		this.comment = comment;
		this.buy_method = buy_method;
		this.credit_1 = credit_1;
		this.credit_2 = credit_2;
		this.credit_3 = credit_3;
		this.credit_4 = credit_4;
		this.cvc = cvc;
		this.transfer_name = transfer_name;
		this.purchase_number = purchase_number;
		this.product_number = product_number;
		this.status = status;
		this.price = price;
		this.purchase_date = purchase_date;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobile_1() {
		return mobile_1;
	}

	public String getMobile_2() {
		return mobile_2;
	}

	public String getMobile_3() {
		return mobile_3;
	}

	public String getEmail() {
		return email;
	}

	public String getShipping_method() {
		return shipping_method;
	}

	public String getAddress() {
		return address;
	}

	public String getComment() {
		return comment;
	}

	public String getBuy_method() {
		return buy_method;
	}

	public String getCredit_1() {
		return credit_1;
	}

	public String getCredit_2() {
		return credit_2;
	}

	public String getCredit_3() {
		return credit_3;
	}

	public String getCredit_4() {
		return credit_4;
	}

	public String getCvc() {
		return cvc;
	}

	public String getTransfer_name() {
		return transfer_name;
	}

	public String getPurchase_number() {
		return purchase_number;
	}

	public String getProduct_number() {
		return product_number;
	}

	public String getStatus() {
		return status;
	}

	public String getPrice() {
		return price;
	}

	public String getPurchase_date() {
		return purchase_date;
	}
	
	
	
	
	
	
}
