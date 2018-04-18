package com.example.PokerHands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerHandTest {

	PokerHand hand0;
	PokerHand hand1;
	
	@Before
    public void init() {
		hand0 = new PokerHand("2S 3S 4S 5S 6S");
		hand1 = new PokerHand("2H 3H 3D 5H 6H");
    }
	
	@Test
	public void highCardTest() {
		assertEquals(6, hand0.highCard());
	}
	
	@Test
	public void pairTest(){
		assertFalse(hand0.hasPair());
		assertTrue(hand1.hasPair());
	}

}
