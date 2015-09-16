package com.yourcom.bean;

	/**
	*此类由MySQLToBean工具自动生成
	*备注(数据表的comment字段)：无备注信息
	*@author childlikeman@gmail.com,http://t.qq.com/lostpig
	*@since 2014-09-28 01:21:24
	*/

	public class Active{
	private int id;
	private int type;
	private int pid;
	private int weight;
	private int count;
	private String addtime;
	private int sellout;
	private String selltime;
	private int ispass;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getPid(){
		return this.pid;
	}
	public void setPid(int pid){
		this.pid=pid;
	}
	public int getWeight(){
		return this.weight;
	}
	public void setWeight(int weight){
		this.weight=weight;
	}
	public int getCount(){
		return this.count;
	}
	public void setCount(int count){
		this.count=count;
	}
	public String getAddtime(){
		return this.addtime;
	}
	public void setAddtime(String addtime){
		this.addtime=addtime;
	}
	public int getSellout(){
		return this.sellout;
	}
	public void setSellout(int sellout){
		this.sellout=sellout;
	}
	public String getSelltime(){
		return this.selltime;
	}
	public void setSelltime(String selltime){
		this.selltime=selltime;
	}
	public int getIspass(){
		return this.ispass;
	}
	public void setIspass(int ispass){
		this.ispass=ispass;
	}

}