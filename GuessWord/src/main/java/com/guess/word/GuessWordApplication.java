package com.guess.word;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuessWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessWordApplication.class, args);

		System.out.println("Welcome to Guess the word!");
		System.out.println("Guess the word in 3 goes.");
		System.out.println("Only lowercase letters allowed.");

		playGame();

	}

	private static void playGame() {
		Word word = new Word();

		Scanner kb = new Scanner(System.in);
		while (true) {

			if (word.isValid(kb.next())) {
				word.processLetter();
				word.displayMessage();	
			}
		}
	}

}
