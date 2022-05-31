package net.scit.vo;

public class BrandVO {
	private int brandnum;
	private String brandname;
	private String managername;
	private String email;

	public BrandVO() {
		super();
	}

	public BrandVO(int brandnum, String brandname, String managername, String email) {
		super();
		this.brandnum = brandnum;
		this.brandname = brandname;
		this.managername = managername;
		this.email = email;
	}

	public int getBrandnum() {
		return brandnum;
	}

	public void setBrandnum(int brandnum) {
		this.brandnum = brandnum;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BrandVO [brandnum=" + brandnum + ", brandname=" + brandname + ", managername=" + managername
				+ ", email=" + email + "]";
	}

}
