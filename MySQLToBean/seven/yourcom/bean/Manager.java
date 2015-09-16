package com.yourcom.bean;

	/**
	*此类由MySQLToBean工具自动生成
	*备注(数据表的comment字段)：无备注信息
	*@author childlikeman@gmail.com,http://t.qq.com/lostpig
	*@since 2014-09-28 01:21:24
	*/

	public class Manager{
	private String username;
	private String password;
	private int type;
	private String ip;
	private String addtime;
	private String lastload;
	private int ispass;
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getIp(){
		return this.ip;
	}
	public void setIp(String ip){
		this.ip=ip;
	}
	public String getAddtime(){
		return this.addtime;
	}
	public void setAddtime(String addtime){
		this.addtime=addtime;
	}
	public String getLastload(){
		return this.lastload;
	}
	public void setLastload(String lastload){
		this.lastload=lastload;
	}
	public int getIspass(){
		return this.ispass;
	}
	public void setIspass(int ispass){
		this.ispass=ispass;
	}

}