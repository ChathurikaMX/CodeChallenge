package com.pages;

import org.testng.annotations.Test;

import com.code.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashSceen extends BaseClass {
   //First screen when the app loadin contains add button
     @AndroidFindBy (accessibility = "com.google.android.calendar:id/floating_action_button") private MobileElement btn_Add;
     @AndroidFindBy (accessibility = "next page") private MobileElement btn_next;
   

public OptionsScreen clickAddButton() {
	for(int y = 0;y<=3;y++) {
	click(btn_next);
	}
	click(btn_Add);
	return new OptionsScreen();
	
	
}
}
 