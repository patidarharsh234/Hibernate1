package com.rays.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import junit.framework.TestCase;

public class TestCaseTwo extends TestCase {

	static int[] i = { 1, 2, 3, 4, 5, 6 };

	@Test
	public void unitTesting1() throws CommanException, Exception {
		assertEquals(6, ArrayClass.findMaxArray(i));
	}

	@Test
	public void unitTesting2() throws CommanException, Exception {

		int i = 110;
		assertSame(110, i);
	}

	@Test
	public void unitTesting3() throws CommanException, Exception {
		assertNotSame(5, ArrayClass.findMaxArray(i));
	}

	

}