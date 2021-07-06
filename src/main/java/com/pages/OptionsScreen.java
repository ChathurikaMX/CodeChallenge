package com.pages;

import org.testng.annotations.Test;

import com.code.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OptionsScreen extends BaseClass {
	//Event option element and the click method
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
     		+ "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout"
     		+ "/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.ImageView") private MobileElement btn_Event;

	
	public CreateEvent clickEventButton() {
		click(btn_Event);
		return new CreateEvent();
		
	}
}
