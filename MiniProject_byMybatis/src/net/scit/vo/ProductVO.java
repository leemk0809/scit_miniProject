package net.scit.vo;

public class ProductVO {
	private int brandnum;
	private int categorynum;
	private int productnum;
	private String productname;
	private int price;

	public ProductVO() {
		super();
	}

	public ProductVO(int brandnum, int categorynum, int productnum, String productname, int price) {
		super();
		this.brandnum = brandnum;
		this.categorynum = categorynum;
		this.productnum = productnum;
		this.productname = productname;
		this.price = price;
	}

	public ProductVO(String productname, int price) {
		super();

		this.productname = productname;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [brandnum=" + brandnum + ", categorynum=" + categorynum + ", productnum=" + productnum
				+ ", productname=" + productname + ", price=" + price + "]";
	}

	public String printList() {
		String temp = String.format("%3d %15s %,9d¿ø", productnum, productname, price);
		return temp;
	}

}
