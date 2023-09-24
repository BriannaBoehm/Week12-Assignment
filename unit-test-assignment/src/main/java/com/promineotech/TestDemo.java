package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			int sum = a + b;
			return sum;
		} else {
	//		System.out.println("Both parameters must be positive!");
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

//3. 

	public String fixNameCapitalization(String name) { //this method fixes the input string name to have a capital first letter and lower case letters after that 

		StringBuilder fixedName = new StringBuilder();
		if (Character.isLetter(name.charAt(0))) {//checks to see if the first letter is a letter 
			fixedName.append(Character.toUpperCase(name.charAt(0)));//adds the now upper case letter to the string builder
		} else {
			throw new IllegalArgumentException("Please only input letters in your name.");//any other character besides a letter will throw an exception 
		}
		for (int position = 1; position < name.length(); position++) {//for loop iterates through the characters in the word 
			if (Character.isLetter(name.charAt(position))) {//checks to see if each character is a letter 
				fixedName.append(Character.toLowerCase(name.charAt(position)));//adds the now lower case letter to the string builder 
			} else {
				System.out.println("Please only input letters in your name.");
				throw new IllegalArgumentException("Please only input letters in your name.");//any other character besides a letter will throw an exception 
			}
		}
	//	System.out.println(fixedName);
		return fixedName.toString();//changes the string builder to string and returns it 

	}

	// 4.

	public int randomNumberSquared() {//returns the square of a random number 
		int random = getRandomInt();
		return random*random;
	}

	int getRandomInt() {//returns a random number 
		Random random = new Random();

		return random.nextInt(10) + 1;
	}
}// end of class
