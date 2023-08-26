package com.rays.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.TestCase;

public class A extends TestCase{
	
	@Test
	public void junit() {
		int i=1;
		
		assertTrue(1==i);
		
	}

}
