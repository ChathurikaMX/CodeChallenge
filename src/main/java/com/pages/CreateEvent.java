package com.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.code.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateEvent extends BaseClass {
	//These are some elements on the create event screen
	@AndroidFindBy (accessibility = "com.google.android.calendar:id/title") private MobileElement txt_Title;
	@AndroidFindBy( xpath = "//android.widget.TextView[@content-desc=\"End date: Mon, Jul 5, 2021\"]")private MobileElement lbl_EndDate;
    @AndroidFindBy (accessibility = "Start time: 9:00 PM") private MobileElement lbl_time;

	public void getTitle() {
		String actualtext= txt_Title.getAttribute("text");
		String expectedtext = "Add Title";
		Assert.assertEquals(actualtext, expectedtext);
	} 
	
	public CreateEvent createNewEvent(String Title) {
		 sendKeys(txt_Title,"text");
		return this;
	}
}
