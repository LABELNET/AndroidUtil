package com.example.volley;

public class VolleyHttpPath {
   
	
	//地址
	private static final String IP="192.168.75.1:8081";
	
	//get提交封装 参数
	public static String getSharedIfo(int id){
		return "http://"+IP+"/GoodsServers/app/getSharedIfo.php?id="+id;
	}
	//post提交只封装 地址 url
	public static String getSharedIfo_post(){
		return "http://"+IP+"/GoodsServers/app/getSharedIfo.php";
	}
	//一张图片的地址
	public static String getPic(){
		return "http://"+IP+"/GoodsServers/image/201508171125128512.jpg";
	}
	
	//基本地址
	public static String getBasicPath(){
		return "http://"+IP+"/GoodsServers";
	}
	
	public static String getSharedAll(int ps,int pg){
		return "http://"+IP+"/GoodsServers/app/getAllIfo.php?pg="+pg+"& ps="+ps;
	}
	
	public static String getSharedAll(){
		return "http://"+IP+"/GoodsServers/app/getAllIfo.php?ps=10&pg=1";
	}
	
}
