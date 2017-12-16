package com.example.Junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {
	
	StringHelper helper;
	private String input;
	private String expectedOutput;
	
	
	public StringHelperParametrizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String[][] expectedOutputs = {
									   	{"AACD", "CD"},
									   	{"ACD", "CD"}
								  	 };
		
		return Arrays.asList(expectedOutputs);
	}
	
	@Before
	public void setup() {
		helper = new StringHelper();
	}
	
	@Test
	public void testTruncateAinFirst2Positions_AinFirst2Positions() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}
	
	@Test
	public void testTruncateAinFirst2Positions_AinFirstPosition() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
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
