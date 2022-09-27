package com.guess.word;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuessWordApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GuessWordApplication.class, args);

		System.out.println("Welcome to Guess the word!");

		Word word = new Word();

		Scanner kb = new Scanner(System.in);
		while (true) {

			char letterGuessed = kb.nextLine().charAt(0);

			word.processLetter(letterGuessed);
			String censoredWord = word.getCensoredWord();
					
			boolean matched = censoredWord.equals(word.getWord());
			if (matched || word.getRemaining() == 0) {
				if (matched) {
					System.out.println("You have won yhe game, the word was " + censoredWord);
				} else {
					System.out.println("You lost, word is " + word.getWord());

				}
				word = new Word();
			} else {
				if (word.isFound()) {
					System.out.println("Correct. " + censoredWord);
				} else {
					System.out.println("Incorrect 1 life lost. " + word.getRemaining() + " remaining. the current word is " + censoredWord);
				}
			}

		}
	}
	
	private static boolean playAgain() {
		//TODO - allow user to play again.
		return true;
	}
}
