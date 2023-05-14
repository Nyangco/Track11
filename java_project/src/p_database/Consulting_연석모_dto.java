package p_database;

public class Consulting_연석모_dto {

	private String no, sId, sName, mId, mName, cDate, cContent;
	private int sAge;
	
	public Consulting_연석모_dto(String no, String sId, String sName, String mId, String mName, String cDate,
			String cContent, int sAge) {
		super();
		this.no = no;
		this.sId = sId;
		this.sName = sName;
		this.mId = mId;
		this.mName = mName;
		this.cDate = cDate;
		this.cContent = cContent;
		this.sAge = sAge;
	}
	

	public Consulting_연석모_dto(String no, String sId, String mId, String cDate, String cContent) {
		super();
		this.no = no;
		this.sId = sId;
		this.mId = mId;
		this.cDate = cDate;
		this.cContent = cContent;
	}



	public String getNo() {
		return no;
	}

	public String getsId() {
		return sId;
	}

	public String getsName() {
		return sName;
	}

	public String getmId() {
		return mId;
	}

	public String getmName() {
		return mName;
	}

	public String getcDate() {
		return cDate;
	}

	public String getcContent() {
		return cContent;
	}

	public int getsAge() {
		return sAge;
	}
	
	
}
