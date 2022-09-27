package com.guess.word;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordTests {
	Word word = null;
	
	@Test
	void randomiseWordTest() {
		word = new Word();
		assertThat(word.getWord() != null);
		assertThat(word.getCountGuess() == 0);
		assertThat(word.getRemaining() == 3);
	}
	
	@Test
	void processLetterTest() {
		word = new Word();
		word.processLetter('a');
		if (word.isFound()) {
			assertThat(word.getRemaining() == 3);
		} else {
			assertThat(word.getRemaining() == 2);
		}
		
	}
}
