package com.rays.junit;

import junit.framework.TestSuite;

public class SuiteForCase{
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(getSuite());
	}

	public static TestSuite getSuite() {

		TestSuite suite = new TestSuite("TestAll");

		suite.addTestSuite(A.class);
		suite.addTestSuite(B.class);

		return suite;

	}

}
