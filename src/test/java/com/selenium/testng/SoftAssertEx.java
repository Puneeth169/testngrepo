package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	@Test
	public void test() {
		SoftAssert soft=new SoftAssert();
		soft.assertFalse(false);
		soft.assertAll();
	}
}
