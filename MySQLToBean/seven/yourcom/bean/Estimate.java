package com.yourcom.bean;

	/**
	*此类由MySQLToBean工具自动生成
	*备注(数据表的comment字段)：无备注信息
	*@author childlikeman@gmail.com,http://t.qq.com/lostpig
	*@since 2014-09-28 01:21:24
	*/

	public class Estimate{
	private int id;
	private int orderid;
	private int pid;
	private int points;
	private String addman;
	private String addtime;
	private String replay;
	private String replaytime;
	private String mark;
	private int ispass;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getOrderid(){
		return this.orderid;
	}
	public void setOrderid(int orderid){
		this.orderid=orderid;
	}
	public int getPid(){
		return this.pid;
	}
	public void setPid(int pid){
		this.pid=pid;
	}
	public int getPoints(){
		return this.points;
	}
	public void setPoints(int points){
		this.points=points;
	}
	public String getAddman(){
		return this.addman;
	}
	public void setAddman(String addman){
		this.addman=addman;
	}
	public String getAddtime(){
		return this.addtime;
	}
	public void setAddtime(String addtime){
		this.addtime=addtime;
	}
	public String getReplay(){
		return this.replay;
	}
	public void setReplay(String replay){
		this.replay=replay;
	}
	public String getReplaytime(){
		return this.replaytime;
	}
	public void setReplaytime(String replaytime){
		this.replaytime=replaytime;
	}
	public String getMark(){
		return this.mark;
	}
	public void setMark(String mark){
		this.mark=mark;
	}
	public int getIspass(){
		return this.ispass;
	}
	public void setIspass(int ispass){
		this.ispass=ispass;
	}

}