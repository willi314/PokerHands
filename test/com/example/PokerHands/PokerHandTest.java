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
	PokerHand hand8;
	PokerHand hand9;
	PokerHand hand10;
	PokerHand hand11;
	PokerHand hand12;
	PokerHand hand13;
	PokerHand hand14;
	
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
		hand8 = new PokerHand("7S 3S 5S 4S 6S");
		hand9 = new PokerHand("QH QD 5S AH AD");
		hand10 = new PokerHand("9H 9D 9S 8H 8D");
		hand11 = new PokerHand("8H 8D 8S 8C AD");
		hand12 = new PokerHand("JH JD AS KH KD");
		hand13 = new PokerHand("8H 8D 2S 5C 7D");
		hand14 = new PokerHand("9H 9D 2S 5H 7D");
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
	
	@Test
	public void compareHandsOfDifferentLevels(){
		assertEquals(1, hand0.compareTo(hand1));
		assertEquals(-1, hand2.compareTo(hand3));
		assertEquals(1, hand5.compareTo(hand6));
	}
	
	@Test
	public void compareHandsOfSameLevels(){
		assertEquals(1, hand6.compareTo(hand7));
		assertEquals(1, hand14.compareTo(hand13));
		assertEquals(1, hand9.compareTo(hand1));
		//assertEquals(1, hand10.compareTo(hand2));
		//assertEquals(1, hand11.compareTo(hand3));
		//assertEquals(1, hand12.compareTo(hand1));
		
		//assertEquals(0, hand4.compareTo(hand0));
		//assertEquals(1, hand8.compareTo(hand0));
	}

}
