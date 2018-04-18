package com.example.PokerHands;

import java.util.Arrays;

public class PokerHand {
	
	int cardValues[];
	
	public PokerHand(String hand){
		
		cardValues = new int[5];
		
		for(int i = 0; i < 13; i+=3){
			char cardValue = hand.charAt(i);
			cardValues[i/3] = cardValue - '0';
		}
		
		Arrays.sort(cardValues);
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
}
