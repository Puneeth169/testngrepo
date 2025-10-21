package com.selenium.testng.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practise1 {
	@Test(dependsOnGroups = "database")
	public void assertion() {
		Assert.assertFalse(false);
		
	}
}
