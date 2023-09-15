package com.saucedemo.tests.endtoend;

import org.apache.hc.core5.http.Method;
import org.testng.annotations.Test;

import com.saucedemo.utils.CommonUtils;
import com.saucedemo.utils.ExtentUtils;

public class OrderDispatchedTest extends CommonUtils {
	
	@Test
	public void OrderDispatchedJourney() {
		System.out.println("Order dispatched");
	}

}
