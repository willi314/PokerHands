package com.example.PokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokerHandTest {

	@Test
	public void highCardTest() {
		PokerHand hand = new PokerHand("2S 3S 4S 5S 6S");
		assertEquals(6, hand.highCard());
	}

}
