package com.yourcom.bean;

	/**
	*此类由MySQLToBean工具自动生成
	*备注(数据表的comment字段)：无备注信息
	*@author childlikeman@gmail.com,http://t.qq.com/lostpig
	*@since 2014-09-29 21:47:41
	*/

	public class Users{
	private int userid;
	private String userphone;
	private String userpass;
	private String username;
	private String address;
	private int label;
	private String userimg;
	private int userfen;
	public int getUserid(){
		return this.userid;
	}
	public void setUserid(int userid){
		this.userid=userid;
	}
	public String getUserphone(){
		return this.userphone;
	}
	public void setUserphone(String userphone){
		this.userphone=userphone;
	}
	public String getUserpass(){
		return this.userpass;
	}
	public void setUserpass(String userpass){
		this.userpass=userpass;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public int getLabel(){
		return this.label;
	}
	public void setLabel(int label){
		this.label=label;
	}
	public String getUserimg(){
		return this.userimg;
	}
	public void setUserimg(String userimg){
		this.userimg=userimg;
	}
	public int getUserfen(){
		return this.userfen;
	}
	public void setUserfen(int userfen){
		this.userfen=userfen;
	}

}