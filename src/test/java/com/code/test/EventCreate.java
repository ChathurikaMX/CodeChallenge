package com.code.test;

import org.testng.annotations.Test;

import com.code.BaseClass;
import com.pages.CreateEvent;
import com.pages.OptionsScreen;
import com.pages.SplashSceen;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;

public class EventCreate extends BaseClass {
	
	CreateEvent createevent;
	OptionsScreen optionsscreen;
	SplashSceen splashscreen;
	
	@BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  @BeforeMethod
	  
	  
	  public void beforeMethod(Method m) {
		  splashscreen = new SplashSceen();
		  System.out.println("\n"+"*******Starting Test:"+m.getName()+"******"+"\n");
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }

	
      @Test
      public void ClickThePlusButton() {
    	  splashscreen.clickAddButton();
    	    
      }
      
      @Test
      public void SelectTheEvent() {
    	  optionsscreen.clickEventButton();
    	  
      }
      
      @Test
      public void CreateTheMeeting() {
    	  createevent.createNewEvent("New Recurring Meeting");
    	  createevent.getTitle();
      }
      
      
  
  

}
