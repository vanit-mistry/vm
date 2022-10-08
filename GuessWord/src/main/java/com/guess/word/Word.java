package com.guess.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {
	private final static int LIMIT_GUESS = 3;
	private String[] words = { "cow", "deer", "cat", "dog" };

	private String censoredWord = "";
	private String secretWord = "";
	private boolean found = false;
	private int countGuess = 0;
	
	private Character guessedLetter;
	private List<Character> inputLetters;


	public Word() {
		init();
	}

	private void init() {
		countGuess = 0;
		randomizeWord();
		inputLetters = new ArrayList<>();
	}

	public int getRemaining() {
		return LIMIT_GUESS - countGuess;
	}

	public boolean isMatched() {
		return censoredWord.equals(secretWord);
	}

	private void randomizeWord() {
		Random rand = new Random();
		int randNum = rand.nextInt(words.length);
		secretWord = words[randNum];
		for (int i = 0; i < secretWord.length(); i++) {
			censoredWord = censoredWord + "*";
		}

		System.out.println("Guess the word " + censoredWord);
	}

	public void processLetter() {
		found = false;
		char[] wordArray = secretWord.toCharArray();
		char[] censoredWordArray = censoredWord.toCharArray();
		for (int i = 0; i < wordArray.length; i++) {
			char ichar = wordArray[i];
			if (guessedLetter.equals(ichar)) {
				censoredWordArray[i] = ichar;
				found = true;
			}
		}

		if (!found) {
			countGuess++;
		}

		censoredWord = String.valueOf(censoredWordArray);
	}

	public void displayEndMessage() {
		if (isMatched()) {
			System.out.println("You have won the game, the word was " + censoredWord);
		} else {
			System.out.println("You lost, word is " + secretWord);
		}
	}

	public void displayLetterMessage() {
		if (found) {
			System.out.println("Correct. " + censoredWord);
		} else {
			System.out.println(
					"Incorrect 1 life lost. " + getRemaining() + " remaining. the current word is " + censoredWord);
		}
	}

	public boolean isValid(String userInput) {
		if (userInput.isBlank()) {
			System.out.println("Please enter a letter");
			return false;
		}
		
		
//		if (userInput < 'a' || userInput > 'z') {
//			System.out.println("Please enter a lowercase letter");
//			return false;
//		}
		
		if (inputLetters.contains(userInput.charAt(0))) {
			System.out.println("Duplicate, Please enter a lowercase letter");
			return false;
		}
		
		guessedLetter = userInput.charAt(0);
		inputLetters.add(guessedLetter);
		
		return true;
	}

	public void displayMessage() {
		if (isMatched() || getRemaining() == 0) {
			displayEndMessage();
			init();
		} else {
			displayLetterMessage();
		}
	}

	public void saveLetter() {
		inputLetters.add(guessedLetter);		
	}
}
