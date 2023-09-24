package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	// 1.
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {//uses assertion statements to ensure that the correct values or exceptions are thrown when the addPositive method is called 
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {//the above test is parameterized meaning it takes parameters. This provides the parameters for testing. 
		// @formatter:off
		return Stream.of(//this series of parameters is tested in the assertThatTwoPositiveNumbersAreAddedCorrectly test 
			arguments(2,4,6,false),
			arguments(0,0,0,true),  
			arguments(0,-1,-1,true), 
			arguments(-1,-1,-2,true), 
			arguments(-1,0,-1,true), 
			arguments(2,0,2,true), 
			arguments(0,2,2,true),
			arguments(-1,2,1,true),
			arguments(2,-1,1,true)
			);
		// @formatter:on
	}

	// 2.
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {//uses assertThat, assertThatThrownBy, and lambda statements to test the addPositive method 
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(101, 202)).isEqualTo(303);
		assertThatThrownBy(() -> testDemo.addPositive(0, 0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.addPositive(1, -1)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.addPositive(-1, 1)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.addPositive(1, 0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.addPositive(0, 1)).isInstanceOf(IllegalArgumentException.class);
	}

	// 3.
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForFixNameCapitalization")
	void assertThatNameCapitalizationIsFixed(String input, String expected, boolean expectException) {//a parameterized test that uses assertion statements to test that the correct name case is returned 
		if (!expectException) {
			assertThat(testDemo.fixNameCapitalization(input)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.fixNameCapitalization(input))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForFixNameCapitalization() {//provides parameters for the assertThatNameCapitalizationIsFixed test 
		// @formatter:off
		return Stream.of(
				arguments("sally","Sally", false),
				arguments("nICK","Nick", false),
				arguments("g3Orge","",true), 
				arguments("321", "", true)
				);
		// @formatter:on
	}
	
	// 4. 
	@Test 
	void assertThatNumberSquaredIsCorrect(){ //uses Mockito soy and Mockito do return statements to mock the randomInt method that is called in the randomNumberSquared method 
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25); //asserts that the mocked number 5 input returns 25 as expected 
	}
}
// end of class
