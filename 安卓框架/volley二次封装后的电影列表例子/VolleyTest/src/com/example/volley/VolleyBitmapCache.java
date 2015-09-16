package com.example.volley;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;

@SuppressLint("NewApi")
public class VolleyBitmapCache implements ImageCache{

	//使用LruCache 实现图片缓存 ：
	//使用地址：


	private LruCache<String,Bitmap> cache;
	//设置最大的 尺寸值
	
	public VolleyBitmapCache() {
		//构造方法 实现 LruCache 缓存 图片
		
		int maxSize=10*1024*1024;
		cache=new LruCache<String,Bitmap>(maxSize){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes()*value.getHeight();
			}
		};
		
	}
	
	@Override
	public Bitmap getBitmap(String url) {
		// 得到
		return cache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// 设置
		cache.put(url, bitmap);
	}

}
