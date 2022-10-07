package com.guess.word;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordTests {
	Word word = null;
	
	@Test
	void randomiseWordTest() {
		word = new Word();
		assertThat(word.getRemaining() == 3);
	}
	

}
