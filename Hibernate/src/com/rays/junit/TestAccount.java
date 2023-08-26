package com.rays.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestAccount {

	@Test
	public void testAdd() throws CommanException, Exception {

		AccountDto dto = new AccountDto();

		/*
		 * dto.setId(5); dto.setName("sivam patidar"); dto.setBalance("8000");
		 * AccoutService.add(dto);
		 */

		dto = AccoutService.findByPk(44);
		
		
   //---->>assert methods
		
		 // fail-method 
		// if (dto == null) { fail("recourd is not add"); }
		 

		
		//assertNull("come green then object is null otherwise come red obje is full", dto);
		
		//assertNotNull("green means object not null,read means object null", dto);
		
	   //  assertTrue("condition true then green", dto==null);
		
	   //assertFalse("condition comes false then given green", dto !=null);
		
		assertSame("obje same then given green", 3, 3);
		
		assertNotSame("object cane note same then given green", 4, 5);
		
	}
	
	
	
	
	
	
	
	
	

	/*
	 * public static void main(String[] args) throws CommanException, Exception {
	 * testAdd();
	 * 
	 * }
	 * 
	 * public static void testAdd() throws CommanException, Exception {
	 * 
	 * AccountDto dto = new AccountDto();
	 * 
	 * long id = 0; dto.setId(id); dto.setName("yash patidar");
	 * dto.setBalance("10000");
	 * 
	 * // AccoutService.add(dto);
	 * 
	 * // AccoutService.update(dto);
	 * 
	 * // AccoutService.delete(dto); // AccountDto dto1 =
	 * AccoutService.findByPk(id); if (dto != null) {
	 * System.out.println(dto.getId()); }
	 * 
	 * }
	 */

}
