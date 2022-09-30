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
			if (word.displayEndMessage()) {
				word = new Word();
			} else {
				word.displayLetterMessage();
			}

		}
	}
	
	private void static playGame() {
		
	}
	
	private static boolean playAgain() {
		//TODO - allow user to play again.
		return true;
	}
}
