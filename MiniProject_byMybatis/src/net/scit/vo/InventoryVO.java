package net.scit.vo;

public class InventoryVO {
	private int seq;
	private String productname;
	private int price;	
	private int stock;
	
	public InventoryVO(int seq, String productname, int price, int stock) {
		super();
		this.seq = seq;
		this.productname = productname;
		this.price = price;
		this.stock = stock;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "InventoryVO [seq=" + seq + ", productname=" + productname + ", price=" + price + ", stock=" + stock
				+ "]";
	}
}