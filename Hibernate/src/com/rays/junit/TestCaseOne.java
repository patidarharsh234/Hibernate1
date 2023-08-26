package com.rays.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.TestCase;

public class TestCaseOne extends TestCase{

	AccountDto dto = null;

	@Test
	public void unitTesting1() throws Exception {
		dto = AccoutService.findByPk(3);
		assertTrue(dto != null);
	}

	@Test
	public void unitTesting2() throws Exception {
		dto = AccoutService.findByPk(3);
		assertFalse(dto == null);
	}

	@Test
	public void unitTesting3() throws Exception {
		dto = AccoutService.findByPk(3);
		assertNotNull(dto);
	}

}
