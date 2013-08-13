/****************************************************************************
Copyright (c) 2010-2012 cocos2d-x.org

http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package jp.basicinc.sample.cocos2dx;

import jp.basicinc.gamefeat.android.sdk.controller.GameFeatIconAdLoader;
import jp.basicinc.gamefeat.android.sdk.view.GameFeatIconView;

import org.cocos2dx.lib.Cocos2dxActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class Cocos2dxSample extends Cocos2dxActivity{
	
	private static Cocos2dxSample me = null;
	
    static final int bannerViewId = 0x661ad306;
    static GameFeatIconAdLoader myIconAdLoader;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		me = this;
		myIconAdLoader = new GameFeatIconAdLoader();
		
		DisplayMetrics metrics = new DisplayMetrics();  
		me.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		
		// アイコン広告のサイズ（解像度に合わせて調整）
		int width = (int) (114 * metrics.density);
		int height = (int) (114 * metrics.density);

    	GameFeatIconView iconView = (GameFeatIconView)me.findViewById(bannerViewId);
    	if (iconView == null) {
    		RelativeLayout layout = new RelativeLayout(me);
    		me.addContentView(layout, new LayoutParams(width, height));
            
            iconView = new GameFeatIconView(me);
            iconView.addLoader(myIconAdLoader);
            iconView.setId(bannerViewId);
            
            layout.addView(iconView);
            
    	}
    	
    	// アイコン広告の表示
        myIconAdLoader.loadAd(me);
	}
	
    static {
         System.loadLibrary("game");
    }
}
