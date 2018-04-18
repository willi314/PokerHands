package com.example.PokerHands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerHandTest {

	PokerHand hand0;
	PokerHand hand1;
	PokerHand hand2;
	PokerHand hand3;
	PokerHand hand4;
	PokerHand hand5;
	PokerHand hand6;
	PokerHand hand7;
	
	@Before
    public void init() {
		hand0 = new PokerHand("2S 3S 5S 4S 6S");
		hand1 = new PokerHand("QH QD JS KH KD");
		hand2 = new PokerHand("7H 7D 7S 8H 8D");
		hand3 = new PokerHand("7H 7D 7S 7C AD");
		hand4 = new PokerHand("2H 3H 4H 6H 5H");
		hand5 = new PokerHand("QH QD AS KH KD");
		hand6 = new PokerHand("2H 5D 7H 9H AH");
		hand7 = new PokerHand("2D 5C 7D 9H KD");
    }
	
	@Test
	public void highCardTest() {
		assertEquals(6, hand0.highCard());
		assertEquals(13, hand1.highCard());
		assertEquals(14, hand3.highCard());
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
	
	
	@Test
	public void flushCheck(){
		assertTrue(hand0.hasFlush());
		assertFalse(hand1.hasFlush());
	}
	
	public void compareHandsOfDifferentLevels(){
		assertEquals(1, hand0.compareTo(hand1));
		assertEquals(-1, hand2.compareTo(hand3));
		assertEquals(0, hand4.compareTo(hand0));
		assertEquals(1, hand6.compareTo(hand7));
	}

}
