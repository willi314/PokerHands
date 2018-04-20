package com.example.PokerHands;

import java.util.Arrays;

public class PokerHand implements Comparable<PokerHand>{
	
	private int cardValues[];
	private boolean hasFlush;
	private int powerLevel;
	
	public PokerHand(String hand){
		
		cardValues = new int[5];
		
		for(int i = 0; i < 13; i+=3){
			char cardValue = hand.charAt(i);
			if(cardValue == 'J')
				cardValues[i/3] = 11;
			else if(cardValue == 'Q')
				cardValues[i/3] = 12;
			else if(cardValue == 'K')
				cardValues[i/3] = 13;
			else if(cardValue == 'A')
				cardValues[i/3] = 14;
			else
				cardValues[i/3] = cardValue - '0';
		}
		
		Arrays.sort(cardValues);
		
		hasFlush = hand.charAt(1) == hand.charAt(4) && hand.charAt(1) == hand.charAt(7) && hand.charAt(1) == hand.charAt(10) && hand.charAt(1) == hand.charAt(13);
		
		powerLevel = this.getInitialPowerLevel();
	}
	
	private int getInitialPowerLevel(){
		if(hasFlush && this.hasStraight()) return 8;
		if(this.hasQuad()) return 7;
		if(this.hasFullHouse()) return 6;
		if(hasFlush) return 5;
		if(this.hasStraight()) return 4;
		if(this.hasTriple()) return 3;
		if(this.hasPairs() == 2) return 2;
		if(this.hasPairs() == 1) return 1;
		return 0;
	}
	
	public int getPowerLevel(){
		return this.powerLevel;
	}
	
	public int highCard(){
		return cardValues[4];
	}
	
	protected int[] cardValues(){
		return cardValues;
	}
	
	public int hasPairs(){
		int numberOfPairs = 0;
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 5; j++){
				if(cardValues[i] == cardValues[j]) numberOfPairs++;
			}
		}
		return numberOfPairs;
	}
	
	public boolean hasTriple(){
		for(int i = 0; i < 3; i++){
			for(int j = i + 1; j < 5; j++){
				if(cardValues[i] == cardValues[j] && cardValues[i] == cardValues[j + 1]) return true;
			}
		}
		return false;
	}
	
	public boolean hasStraight(){
		for(int i = 0; i < 4; i++){
			if((cardValues[i] + 1) != cardValues[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public boolean hasFullHouse(){
		return this.hasTriple() && cardValues[0] == cardValues[1] && cardValues[3] == cardValues[4];
	}
	
	public boolean hasQuad(){
		return (cardValues[0] == cardValues[1] && cardValues[0] == cardValues[2] && cardValues[0] == cardValues[3]) || 
				(cardValues[1] == cardValues[2] && cardValues[1] == cardValues[3] && cardValues[1] == cardValues[4]);
	}
	
	public boolean hasFlush(){
		return this.hasFlush;
	}

	@Override
	public int compareTo(PokerHand hand1) {
		if(this.powerLevel > hand1.getPowerLevel()) return 1;
		if(this.powerLevel < hand1.getPowerLevel()) return -1;
		if(this.powerLevel == 0) return this.compareHighCards(hand1);
		if(this.powerLevel == 1) return this.compareSinglePairs(hand1);
		if(this.powerLevel == 2) return this.compareDoublePairs(hand1);
		if(this.powerLevel == 3) return this.compareTriples(hand1);
		if(this.powerLevel == 4) return this.compareStraights(hand1);
		return 0;
	}
	
	private int compareHighCards(PokerHand hand1){
		int hand1CardValues[] = hand1.cardValues();
		if(this.highCard() > hand1.highCard()) return 1;
		if(this.highCard() < hand1.highCard()) return -1;
		if(this.cardValues[3] > hand1CardValues[3]) return 1;
		if(this.cardValues[3] < hand1CardValues[3]) return -1;
		if(this.cardValues[2] > hand1CardValues[2]) return 1;
		if(this.cardValues[2] < hand1CardValues[2]) return -1;
		if(this.cardValues[1] > hand1CardValues[1]) return 1;
		if(this.cardValues[1] < hand1CardValues[1]) return -1;
		if(this.cardValues[0] > hand1CardValues[0]) return 1;
		if(this.cardValues[0] < hand1CardValues[0]) return -1;
		return 0;
	}
	
	private int compareSinglePairs(PokerHand hand1){
		int hand1CardValues[] = hand1.cardValues();
		int pairValue0 = 0;
		int pairValue1 = 0;
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 5; j++){
				if(cardValues[i] == cardValues[j]) pairValue0 = cardValues[i];
			}
		}
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 5; j++){
				if(hand1CardValues[i] == hand1CardValues[j]) pairValue1 = hand1CardValues[i];
			}
		}
		if(pairValue0 > pairValue1) return 1;
		if(pairValue0 < pairValue1) return -1;
		return compareHighCards(hand1);
	}
	
	private int compareDoublePairs(PokerHand hand1){
		int hand1CardValues[] = hand1.cardValues();
		if(this.cardValues[3] > hand1CardValues[3]) return 1;
		if(this.cardValues[3] < hand1CardValues[3]) return -1;
		if(this.cardValues[1] > hand1CardValues[1]) return 1;
		if(this.cardValues[1] < hand1CardValues[1]) return -1;
		if(this.cardValues[5] > hand1CardValues[5]) return 1;
		if(this.cardValues[5] < hand1CardValues[5]) return -1;
		if(this.cardValues[2] > hand1CardValues[2]) return 1;
		if(this.cardValues[2] < hand1CardValues[2]) return -1;
		if(this.cardValues[0] > hand1CardValues[0]) return 1;
		if(this.cardValues[0] < hand1CardValues[0]) return -1;
		return 0;
	}
	
	private int compareTriples(PokerHand hand1){
		int hand1CardValues[] = hand1.cardValues();
		if(this.cardValues[2] > hand1CardValues[2]) return 1;
		return -1;
	}
	
	private int compareStraights(PokerHand hand1){
		if(this.highCard() > hand1.highCard()) return 1;
		if(this.highCard() < hand1.highCard()) return -1;
		return 0;
	}
	
}
