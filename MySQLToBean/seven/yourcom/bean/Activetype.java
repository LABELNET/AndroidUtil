package com.yourcom.bean;

	/**
	*此类由MySQLToBean工具自动生成
	*备注(数据表的comment字段)：无备注信息
	*@author childlikeman@gmail.com,http://t.qq.com/lostpig
	*@since 2014-09-28 01:21:24
	*/

	public class Activetype{
	private int id;
	private String name;
	private String addtime;
	private String starttime;
	private String endtime;
	private String discount;
	private String desc;
	private String url;
	private int ispass;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getAddtime(){
		return this.addtime;
	}
	public void setAddtime(String addtime){
		this.addtime=addtime;
	}
	public String getStarttime(){
		return this.starttime;
	}
	public void setStarttime(String starttime){
		this.starttime=starttime;
	}
	public String getEndtime(){
		return this.endtime;
	}
	public void setEndtime(String endtime){
		this.endtime=endtime;
	}
	public String getDiscount(){
		return this.discount;
	}
	public void setDiscount(String discount){
		this.discount=discount;
	}
	public String getDesc(){
		return this.desc;
	}
	public void setDesc(String desc){
		this.desc=desc;
	}
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url=url;
	}
	public int getIspass(){
		return this.ispass;
	}
	public void setIspass(int ispass){
		this.ispass=ispass;
	}

}