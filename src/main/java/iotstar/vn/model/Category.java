package iotstar.vn.model;

public class Category {
	private int cateid;
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Category() {
		super();
		this.cateid = cateid;
		this.catename = catename;
		this.icon = icon;
	}
	private String catename;
	private String icon;
	//Tạo constructor, getters/setters
	
}
