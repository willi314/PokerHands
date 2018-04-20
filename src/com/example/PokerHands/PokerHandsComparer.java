package com.example.PokerHands;

public class PokerHandsComparer {

	static PokerHand hand0;
	static PokerHand hand1;
	
	public static void main(String[] args) {
		String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
		createPokerHands(input);
		System.out.println(createOutputString(hand0.compareTo(hand1)));
		
		input = "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S";
		createPokerHands(input);
		System.out.println(createOutputString(hand0.compareTo(hand1)));
		
		input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH";
		createPokerHands(input);
		System.out.println(createOutputString(hand0.compareTo(hand1)));
		
		input = "Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH";
		createPokerHands(input);
		System.out.println(createOutputString(hand0.compareTo(hand1)));
	}
	
	private static String createOutputString(int pokerHandComparisonResult){
		if(pokerHandComparisonResult == 1) return "Black wins. - with " + hand0.toString();
		else if(pokerHandComparisonResult == -1) return "White wins. - with " + hand1.toString();
		else if(pokerHandComparisonResult == 0) return "Tie.";
		return "Error";
	}
	
	private static void createPokerHands(String input){
		hand0 = new PokerHand(input.substring(7, 21));
		hand1 = new PokerHand(input.substring(30, 44));
	}

}
