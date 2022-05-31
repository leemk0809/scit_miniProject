package net.scit.vo;

public class UserVO {
	private String usrid;
	private String passwd;
	private String usrname;
	private String address;
	private String amount;
	
	public UserVO(String usrid, String passwd, String usrname, String address, String amount) {
		super();
		this.usrid = usrid;
		this.passwd = passwd;
		this.usrname = usrname;
		this.address = address;
		this.amount = amount;
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UserVO [usrid=" + usrid + ", passwd=" + passwd + ", usrname=" + usrname + ", address=" + address
				+ ", amount=" + amount + "]";
	}
	
	
}
