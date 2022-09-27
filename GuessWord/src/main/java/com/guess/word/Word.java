package com.guess.word;

import java.util.Random;

public class Word {
	private final static int LIMIT_GUESS = 3;
	private String[] words = { "cow", "deer", "cat", "dog" };
	
	private String censoredWord = "";
	private String word = "";
	private boolean found = false;
	private int countGuess = 0;
	private String[] inputLetters = {};  //TODO - save entered letters
	
	public Word() 
	{
		countGuess = 0;
		randomizeWord();
	}
	
	public boolean isFound() {
		return found;
	}

	public int getCountGuess() {
		return countGuess;
	}

	public int getRemaining()
	{
		return LIMIT_GUESS - countGuess;
	}
	
	public String getWord() {
		return word;
	}

	public String getCensoredWord() {
		return censoredWord;
	}

	private void randomizeWord() {
		Random rand = new Random();
		int randNum = rand.nextInt(words.length);
		word = words[randNum];
		for (int i = 0; i < word.length(); i++) {
			censoredWord = censoredWord + "*";
		}

		System.out.println("Guess the word " + censoredWord);
	}

	public void processLetter(char letter) {
		found = false;
		char[] wordArray = word.toCharArray();
		char[] censoredWordArray = censoredWord.toCharArray();
		for (int i = 0; i < wordArray.length; i++) {
			char ichar = wordArray[i];
			if (letter == ichar) {
				censoredWordArray[i] = ichar;
				found = true;
			}
		}
		
		if (!found) {
			countGuess++;
		}
		
		censoredWord = String.valueOf(censoredWordArray);
	}

	private void validate() {
		//TODO - validate character
	}
}