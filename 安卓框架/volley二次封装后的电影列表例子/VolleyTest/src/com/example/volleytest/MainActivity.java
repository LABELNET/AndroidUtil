package com.example.volleytest;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.example.model.shared;
import com.example.model.sharedIfo;
import com.example.volley.GsonRequest;
import com.example.volley.VolleyBitmapCache;
import com.example.volley.VolleyHttpPath;
import com.example.volley.VolleyHttpRequest;
import com.example.volley.VolleyHandler;
import com.example.volley.VolleyApplication;

public class MainActivity extends Activity {

	private Button btn;
	private TextView tv;
	private ImageView imageView1;
	private NetworkImageView network_image_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		btn.setOnClickListener(new btnclick());

	}

	private void initView() {
		btn = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.textView1);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		network_image_view = (NetworkImageView) findViewById(R.id.network_image_view);

	}
	
	/**
	 * JsonObject 回调实现
	 */
	VolleyHandler<JSONObject> json_Req=new VolleyHandler<JSONObject>() {
		
		@Override
		public void reqSuccess(JSONObject response) {
			// 成功的回调
			try {
				tv.setText(response.getString("data"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				tv.setText(e.getMessage());
			}
		}
		
		@Override
		public void reqError(String error) {
			// 失败的回调
			tv.setText(error);
		}
	};

	
	/**
	 * 图片的回调
	 * ImageRequest 可以用于请求一张图片
	 * ImageLoader 可以请求多张图片
	 */
	VolleyHandler<Bitmap> bitmap_req=new VolleyHandler<Bitmap>() {
		
		@Override
		public void reqSuccess(Bitmap response) {
			// 成功
			imageView1.setImageBitmap(response);
			
		}
		
		@Override
		public void reqError(String error) {
			//出错
			Toast.makeText(getApplicationContext(), "出错"+error,Toast.LENGTH_LONG).show();
		}
	};
	
	class btnclick implements OnClickListener {

		@Override
		public void onClick(View v) {
			
			startActivity(new Intent(MainActivity.this, MoviesActivity.class));
			
			//VolleyHttpRequest.Image_request(VolleyHttpPath.getPic(), bitmap_req);
			
			//执行网络请求
			//VolleyHttpRequest.JsonObject_Request(HttpPath.getSharedIfo(1),json_Req);
			
			//startActivity(new Intent(MainActivity.this, MovieActivity.class));
			//volleyRequest_jsonobject();
			//volleyRequest_String();
			// gsonRequset_get();
			// networkImageview_get();
			// imageLoader_cache();
			// imageLoader_get();
			// imageRequest_get();
			// jsonRequest_post();
			// strRequest_post();
			// jsonRequest_get();
			// strRequest_get();
		}
	}
	

	
	
	
	
	
	
	/**
	 * 7.测试 jsonObjectRequest 
	 */
	private void volleyRequest_jsonobject(){
		
		VolleyHandler<JSONObject> volleyRequest=new VolleyHandler<JSONObject>() {
			
			@Override
			public void reqSuccess(JSONObject response) {
				// 成功的回调
				try {
					tv.setText(response.getString("data"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					tv.setText(e.getMessage());
				}
			}
			
			@Override
			public void reqError(String error) {
				//失败的回调
				tv.setText(error);
			}
		};
		JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Method.GET,VolleyHttpPath.getSharedIfo(1),null
				,volleyRequest.reqLis,volleyRequest.reqErr);
		VolleyApplication.getQueue().add(jsonObjectRequest);
		
	}

	/**
	 * 6. 自己封装 volleyRequest 方法 进行回调使用
	 */

	private void volleyRequest_String() {
		
		VolleyHandler<String> request=new VolleyHandler<String>() {
			
			@Override
			public void reqSuccess(String response) {
				// 成功的回调
				tv.setText(response);
			}
			
			@Override
			public void reqError(String error) {
				// 失败的回调
				tv.setText("失败的回调"+error);
			}
		};
		
		//StringRequest请求
		StringRequest stringRequest=new StringRequest(Method.GET,VolleyHttpPath.getSharedIfo(1),
				request.reqLis,request.reqErr);
		stringRequest.setTag("stringrequest");
		VolleyApplication.getQueue().add(stringRequest);
	}

	/**
	 * 5 . 自定义Request :使用 gson 直接将 json转换为对象 //使用自定义Request 的方式 来请求数据
	 */
	private void gsonRequset_get() {

		GsonRequest<sharedIfo> gsonRequest = new GsonRequest<sharedIfo>(
				Method.GET, VolleyHttpPath.getSharedIfo(1), sharedIfo.class,
				new Listener<sharedIfo>() {

					@Override
					public void onResponse(sharedIfo response) {
						// 成功 ，开始 获得sharedIfo对象
						// 直接转 成 shared对象
						shared ifo = response.getData();

						tv.setText(response.getCode() + " | "
								+ response.getMsg() + " | " + ifo.toString());

						networkImageview_get(ifo.getPic());

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						tv.setText(error.getMessage());

					}
				});

		gsonRequest.setTag("gsonRequset");
		VolleyApplication.getQueue().add(gsonRequest);

	}

	/**
	 * 4.3 使用networkImageView 加载图片
	 */
	private void networkImageview_get(String pic) {

		ImageLoader imageLoader = new ImageLoader(VolleyApplication.getQueue(),
				new VolleyBitmapCache());

		network_image_view.setDefaultImageResId(R.drawable.ic_launcher);
		network_image_view.setErrorImageResId(R.drawable.ic_launcher);
		network_image_view.setImageUrl(VolleyHttpPath.getBasicPath() + "/" + pic,
				imageLoader);

	}

	/**
	 * 4.2 将 imageLoader和 缓存联系在一起！
	 */
	private void imageLoader_cache() {

		// 设置 图片缓存 :体现 imageLoader的优势
		// 使用 LruBitmap + ImageCache 实现
		// 实例化对象
		ImageLoader imageLoader = new ImageLoader(VolleyApplication.getQueue(),
				new VolleyBitmapCache());
		// 图片监听 （默认图片，错误图片） 和 imageView
		ImageListener imageListener = ImageLoader.getImageListener(imageView1,
				R.drawable.ic_launcher, R.drawable.ic_launcher);

		// 加载图片
		imageLoader.get(VolleyHttpPath.getPic(), imageListener, 0, 0);

	}

	/**
	 * 4.imageloader ，无缓存的 优点是：图片缓存技术
	 */
	private void imageLoader_get() {

		// 设置 图片缓存 这里为 空的，没有使用 缓存
		ImageCache cache = new ImageCache() {

			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				// 没有

			}

			@Override
			public Bitmap getBitmap(String url) {
				// 没有
				return null;
			}
		};
		// 实例化对象
		ImageLoader imageLoader = new ImageLoader(VolleyApplication.getQueue(),
				cache);
		// 图片监听 （默认图片，错误图片） 和 imageView
		ImageListener imageListener = ImageLoader.getImageListener(imageView1,
				R.drawable.ic_launcher, R.drawable.ic_launcher);

		// 加载图片
		imageLoader.get(VolleyHttpPath.getPic(), imageListener, 0, 0);

	}

	/**
	 * 03. imageRequest 请求一张图片
	 */
	private void imageRequest_get() {
		ImageRequest imageRequest = new ImageRequest(VolleyHttpPath.getPic(),
				new Response.Listener<Bitmap>() {

					@Override
					public void onResponse(Bitmap response) {
						// TODO Auto-generated method stub
						imageView1.setImageBitmap(response);
					}
				}, 0, 0, Config.RGB_565, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						tv.setText(error.getMessage());
					}
				});
		imageRequest.setTag("iamgerequest");
		VolleyApplication.getQueue().add(imageRequest);

	}

	/**
	 * 02.2 jsonObjectRequest post的方式 请求
	 */
	private void jsonRequest_post() {

		// 封装请求参数
		JSONObject jsonStr = new JSONObject();
		try {
			jsonStr.put("id", "2");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
				Method.POST, VolleyHttpPath.getSharedIfo_post(), jsonStr,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						JSONObject jsonObject;
						try {
							jsonObject = new JSONObject(
									response.getString("data"));
							tv.setText(jsonObject.getString("note"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						tv.setText(error.getMessage());
					}
				});
		jsonObjectRequest.setTag("jsonPost");
		VolleyApplication.getQueue().add(jsonObjectRequest);

	}

	/**
	 * 02.jsonobjectRequert get请求
	 */
	private void jsonRequest_get() {
		JsonObjectRequest objectRequest = new JsonObjectRequest(Method.GET,
				VolleyHttpPath.getSharedIfo(1), null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// 直接进行 json解析
						try {
							JSONObject jsonObject = new JSONObject(
									response.getString("data"));
							tv.setText(jsonObject.getString("note"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							tv.setText(e.getMessage());
						}
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// 请求失败返回的信息
						tv.setText(error.getMessage());
					}
				});
		objectRequest.setTag("jsonRequest");
		VolleyApplication.getQueue().add(objectRequest);
	}

	/**
	 * 01.2 String Requset post 提交数据
	 */
	private void strRequest_post() {
		StringRequest stringRequest = new StringRequest(Method.POST,
				VolleyHttpPath.getSharedIfo_post(), new Listener<String>() {

					@Override
					public void onResponse(String response) {
						// 成功返回数据
						tv.setText(response);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// 出错
						Toast.makeText(getApplicationContext(),
								error.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// post 提交 重写参数 ，将自动 提交参数
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", "2");
				return map;
			}
		};

		stringRequest.setTag("strPost");
		VolleyApplication.getQueue().add(stringRequest);

	}

	/**
	 * 01 StringRequest 通过get 方式 请求数据
	 */

	private void strRequest_get() {
		StringRequest request = new StringRequest(Method.GET,
				VolleyHttpPath.getSharedIfo(1), new Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), response,
								Toast.LENGTH_SHORT).show();
						tv.setText(response);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(getApplicationContext(),
								error.getMessage(), Toast.LENGTH_SHORT).show();
					}
				});

		request.setTag("strReqGet");
		VolleyApplication.getQueue().add(request);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		VolleyApplication.getQueue().cancelAll("strReqGet");
		super.onStop();
	}

}
