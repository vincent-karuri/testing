package com.example.Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper;
	
	@Before
	public void setup() {
		helper = new StringHelper();
	}
	
	@Test
	public void testTruncateAinFirst2Positions_AinFirst2Positions() {
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAinFirst2Positions_AinFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD")); 
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_SingleCharacterNegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A")); 
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB")); 
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TwoCharacterPositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB")); 
	}
}
