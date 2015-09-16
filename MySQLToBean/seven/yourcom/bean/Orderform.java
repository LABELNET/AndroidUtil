package com.yourcom.bean;

	/**
	*此类由MySQLToBean工具自动生成
	*备注(数据表的comment字段)：无备注信息
	*@author childlikeman@gmail.com,http://t.qq.com/lostpig
	*@since 2014-09-28 01:21:24
	*/

	public class Orderform{
	private int id;
	private String orderid;
	private String address;
	private String addtime;
	private String sendtime;
	private int judge;
	private String finishtime;
	private int paytime;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getOrderid(){
		return this.orderid;
	}
	public void setOrderid(String orderid){
		this.orderid=orderid;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddtime(){
		return this.addtime;
	}
	public void setAddtime(String addtime){
		this.addtime=addtime;
	}
	public String getSendtime(){
		return this.sendtime;
	}
	public void setSendtime(String sendtime){
		this.sendtime=sendtime;
	}
	public int getJudge(){
		return this.judge;
	}
	public void setJudge(int judge){
		this.judge=judge;
	}
	public String getFinishtime(){
		return this.finishtime;
	}
	public void setFinishtime(String finishtime){
		this.finishtime=finishtime;
	}
	public int getPaytime(){
		return this.paytime;
	}
	public void setPaytime(int paytime){
		this.paytime=paytime;
	}

}