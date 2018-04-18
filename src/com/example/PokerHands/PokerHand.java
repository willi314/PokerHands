package com.example.PokerHands;

import java.util.Arrays;

public class PokerHand {
	
	private int cardValues[];
	private boolean hasFlush;
	
	public PokerHand(String hand){
		
		cardValues = new int[5];
		
		for(int i = 0; i < 13; i+=3){
			char cardValue = hand.charAt(i);
			cardValues[i/3] = cardValue - '0';
		}
		
		Arrays.sort(cardValues);
		
		hasFlush = hand.charAt(1) == hand.charAt(4) && hand.charAt(1) == hand.charAt(7) && hand.charAt(1) == hand.charAt(10) && hand.charAt(1) == hand.charAt(13); 
	}
	
	public int highCard(){
		return cardValues[4];
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
}
