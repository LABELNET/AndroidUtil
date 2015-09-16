package com.example.model;

public class shared {
    
	private int id;
	@Override
	public String toString() {
		return "shared [id=" + id + ", tname=" + tname + ", addtime=" + addtime
				+ ", name=" + name + ", note=" + note + ", pic=" + pic
				+ ", url=" + url + "]";
	}
	private String tname;
	private String addtime;
	private String name;
	private String note;
	private String pic;
	private String url;
	public String getTotol() {
		return totol;
	}
	public void setTotol(String totol) {
		this.totol = totol;
	}
	private String totol;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
