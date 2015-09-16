package cn.labelnet.util;

import com.nineoldandroids.view.ViewHelper;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class RoatePageTransformer implements PageTransformer {

	   private static final float MIN_ROATE =20f;
	   //旋转角度的变化
	   private float roate;
	   
	@Override
	public void transformPage(View view, float position) {
		
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            ViewHelper.setRotation(view, 0);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
        	
        	roate=MIN_ROATE*position;
        	
        	ViewHelper.setPivotX(view, pageWidth/2);
        	ViewHelper.setPivotY(view, view.getMeasuredHeight());
        	
        	ViewHelper.setRotation(view, roate);
         

        } else if (position <= 1) { // (0,1]
        	roate=MIN_ROATE*position;
        	
        	ViewHelper.setPivotX(view, pageWidth/2);
        	ViewHelper.setPivotY(view, view.getMeasuredHeight());
        	
        	ViewHelper.setRotation(view, roate);

        } else { // (1,+Infinity]
            ViewHelper.setRotation(view, 0);
        }

	}
	
	
	  

}
