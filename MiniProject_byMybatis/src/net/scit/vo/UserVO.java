package net.scit.vo;

public class UserVO {
	private String usrid;
	private String passwd;
	private String usrname;
	private String address;
	private int amount;
	
	public UserVO() {
		super();
	}
	
	public UserVO(String usrid, String passwd, String usrname, String address, int amount) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UserVO [usrid=" + usrid + ", passwd=" + passwd + ", usrname=" + usrname + ", address=" + address
				+ ", amount=" + amount + "]";
	}
	
	
}
