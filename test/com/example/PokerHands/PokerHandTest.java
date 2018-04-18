package com.example.PokerHands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerHandTest {

	PokerHand hand0;
	PokerHand hand1;
	PokerHand hand2;
	PokerHand hand3;
	
	@Before
    public void init() {
		hand0 = new PokerHand("2S 3S 5S 4S 6S");
		hand1 = new PokerHand("7H 7D 9S 8H 8D");
		hand2 = new PokerHand("7H 7D 7S 8H 8D");
		hand3 = new PokerHand("7H 7D 7S 7C 8D");
    }
	
	@Test
	public void highCardTest() {
		assertEquals(6, hand0.highCard());
	}
	
	@Test
	public void pairsTest(){
		assertEquals(0, hand0.hasPairs());
		assertEquals(2, hand1.hasPairs());
	}
	
	@Test
	public void threeOfAKindTest(){
		assertFalse(hand0.hasTriple());
		assertTrue(hand2.hasTriple());
	}
	
	@Test
	public void straightCheck(){
		assertTrue(hand0.hasStraight());
		assertFalse(hand1.hasStraight());
	}
	
	@Test
	public void fullHouseCheck(){
		assertTrue(hand2.hasFullHouse());
		assertFalse(hand1.hasFullHouse());
	}
	
	@Test
	public void fourOfAKindTest(){
		assertTrue(hand3.hasQuad());
		assertFalse(hand2.hasQuad());
	}

}
