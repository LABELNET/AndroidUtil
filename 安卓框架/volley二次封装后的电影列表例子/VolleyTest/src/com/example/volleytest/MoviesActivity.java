package com.example.volleytest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.model.shared;
import com.example.volley.VolleyHttpPath;
import com.example.volley.VolleyHttpRequest;
import com.example.volley.VolleyHandler;
import com.example.volley.VolleyApplication;
import com.example.volleytest.MovieActivity.MovieListAdapter;

public class MoviesActivity extends Activity {

	private ListView move_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movies);
		move_list=(ListView)findViewById(R.id.move_list);
		getMovieList();
		
	}
	
	/**
	 * 执行网络请求和适配listview
	 */
	private void getMovieList(){
		
		String url=VolleyHttpPath.getSharedAll();
		VolleyHandler<JSONObject> volleyRequest=new VolleyHandler<JSONObject>() {
			
			@Override
			public void reqSuccess(JSONObject response) {
				// 成功后的解析
				List<shared> list=new ArrayList<shared>();
				String str="网络错误";
				try {
					if(response.getString("msg").equals("success")&&response.getInt("code")==1){
						
						//json解析 为 List<shared> 
						JSONArray array=new JSONArray(response.getString("data"));
						for(int i=0;i<array.length();i++){
							JSONObject object=(JSONObject) array.get(i);
							shared s=new shared();
							s.setId(object.getInt("id"));
							s.setName(object.getString("name"));
							s.setPic(object.getString("pic"));
							s.setTotol(object.getString("totol"));
							list.add(s);
						}
						if(list.size()>0){
							//解析完毕 ，适配 listview
							MovieListAdapter adapter=new MovieListAdapter(list);
							move_list.setAdapter(adapter);
						}else{
							str="没有解析出来"+response.toString();
							Show(str);
						}
						
					}else{
						Show(response.getString("msg"));
					}
				} catch (JSONException e) {
					// 发生异常
					Show(e.getMessage());
				}
				
	
			}
			
			@Override
			public void reqError(String error) {
				// 失败
				Show("JsonObject error："+error);
				
			}
		};
		//网络请求
	   VolleyHttpRequest.JsonObject_Request(url, volleyRequest);
		
	}
	
	/**
	 * toast 
	 * @param msg
	 */
	private void Show(String msg){
		Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
	}
	
	
	/**
	 * 继承baseAdapter 准备适配给listview
	 * @author yuan
	 * 
	 */
	class MovieListAdapter extends BaseAdapter{

		List<shared> mlist=null;
		private ImageView imageView;
		public MovieListAdapter(List<shared> list) {
			//初始化 List<shared> 列表
			this.mlist=list;
		}
		
		@Override
		public int getCount() {
			return mlist.size();
		}

		@Override
		public Object getItem(int position) {
			return mlist.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//初始化 控件
			convertView=View.inflate(getApplicationContext(), R.layout.list_item,null);
			
			imageView=(ImageView)convertView.findViewById(R.id.img_movie);
			TextView movie_name=(TextView)convertView.findViewById(R.id.movie_name);
			TextView movie_totol=(TextView)convertView.findViewById(R.id.movie_totol);
		    
			//设置 背景为 灰色
			if(position%2==0){
			  convertView.setBackgroundColor(Color.GRAY);
			}
			
			//设置参数
			shared s=mlist.get(position);
			movie_name.setText(s.getName());
			movie_totol.setText(s.getTotol());
			//设置图片
			String url=VolleyHttpPath.getBasicPath()+"/"+s.getPic();
			
			
			//实现ImageListener
			ImageListener imageListener = ImageLoader.getImageListener(imageView,
					R.drawable.ic_launcher, R.drawable.ic_launcher);
		    //请求 图片 设置图片
			VolleyHttpRequest.Image_Loader(url, imageListener);
			
			return convertView;
	  }
		
	}
	
	
}

