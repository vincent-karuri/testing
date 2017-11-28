package com.example.Junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort_RandomArray() {
		int[] nums = {1, 7, 4, 2, 5};
		int[] expected = {1, 2, 4, 5, 7};
		
		Arrays.sort(nums);
		assertArrayEquals(expected, nums);
	}
	
	@Test(expected=NullPointerException.class)
	public void testArraySort_NullArray() {
		int[] nums = null;	
		Arrays.sort(nums);
	}
}
