package com.util;

import java.util.Random;

public class UtilsMethods {

//	public WebDriver driver = null;
//
//	public UtilsMethods(WebDriver driver) {
//		this.driver = driver;
//
//	}

	public int RandomSelect(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}




}
