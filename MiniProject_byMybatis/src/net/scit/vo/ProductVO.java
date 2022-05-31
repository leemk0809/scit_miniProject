package net.scit.vo;

public class ProductVO {
	private int brandnum;
	private int categorynum;
	private int productnum;
	private String productname;

	public ProductVO() {
		super();
	}

	public ProductVO(int brandnum, int categorynum, int productnum, String productname) {
		super();
		this.brandnum = brandnum;
		this.categorynum = categorynum;
		this.productnum = productnum;
		this.productname = productname;
	}

	public int getBrandnum() {
		return brandnum;
	}

	public void setBrandnum(int brandnum) {
		this.brandnum = brandnum;
	}

	public int getCategorynum() {
		return categorynum;
	}

	public void setCategorynum(int categorynum) {
		this.categorynum = categorynum;
	}

	public int getProductnum() {
		return productnum;
	}

	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Override
	public String toString() {
		return "ProductVO [brandnum=" + brandnum + ", categorynum=" + categorynum + ", productnum=" + productnum
				+ ", productname=" + productname + "]";
	}

}
