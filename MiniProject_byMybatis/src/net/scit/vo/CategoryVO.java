package net.scit.vo;

public class CategoryVO {
	private int categorynum;
	private String categoryname;

	public CategoryVO() {
		super();
	}

	public CategoryVO(int categorynum, String categoryname) {
		super();
		this.categorynum = categorynum;
		this.categoryname = categoryname;
	}

	public CategoryVO(String categoryname) {
		this.categoryname = categoryname;
	}


	public void setCategorynum(int categorynum) {
		this.categorynum = categorynum;
	}
	

	public int getCategorynum(int i) {
		return categorynum;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "CategoryVO [categorynum=" + categorynum + ", categoryname=" + categoryname + "]";
	}

}
