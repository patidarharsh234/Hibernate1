package com.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestLifeCycleMethods {
	
	@BeforeClass 
	public static void beforeclass() {
		
		System.out.println("beforeclass");
	}
	
	@Before
	public  void before() {
		
		System.out.println("before");
	}
	
	
	@Test
	public  void max() {
		int[] i= {1,2,3,4,5,6};
		assertEquals(4,ArrayClass.findMaxArray(i));
	//	assertEquals("not maching then comes read(false)=1",6,ArrayClass.findMaxArray(i));
		System.out.println("test=1");
		
	}
	
	@Test
	public  void min() {
		
		int[] i= {1,2,3,4,5,6};
		assertEquals(1,ArrayClass.findMinArray((i)));
	//	assertEquals("not maching then comes read(false)=2",3,ArrayClass.findMinArray((i)));
		System.out.println("test=2");
	}
	
	@After
	public  void after() {
		
		System.out.println("after");
	}
	
	@AfterClass
	public static void afterClass() {
		
		System.out.println("AfterClass");
	}
	
	
	
	
	

}
