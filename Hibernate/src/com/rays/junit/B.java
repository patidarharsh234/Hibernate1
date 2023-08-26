package com.rays.junit;

import org.junit.Test;

import junit.framework.TestCase;

public class B extends TestCase {
	
	
	@Test
	public void unitTesting1() throws Exception {
		int i=1;
		assertTrue(1==i);
	}

}
