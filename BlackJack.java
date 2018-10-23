/*
* BlackJack.java
* Author: Anthony Logan Bryant
* Submission Date: 12/4/2017
*
* Purpose: This game simulates a game of blackjack. It uses multiple classes to break
* the tasks up into different parts. When it is running, a screen will show the game. 
* The user can interact with it and press hit if they want another card or stay if they dont.
* After each hand, the score will increment based on who wins the game. 
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science.
*/

/**
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		deck = new Deck();
		dealer = new Dealer();
		player = new Player();
		deck.shuffle();
		player.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		
	}
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		deck = new Deck();
		dealer.getHand().emptyHand();
		player.getHand().emptyHand();
		deck.shuffle();
		player.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
	}
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		int result = 0;
		switch (c.getType()) {
		case ACE:
			result = 1;
			break;
		case TWO:
			result = 2;
			break;
		case THREE:
			result = 3;
			break;
		case FOUR:
			result = 4;
			break;
		case FIVE:
			result = 5;
			break;
		case SIX:
			result = 6;
			break;
		case SEVEN:
			result = 7;
			break;
		case EIGHT:
			result = 8;
			break;
		case NINE:
			result = 9;
			break;
		default:
			result = 10;
			break;
		}
		return result;
	}
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		Card [] temp = h.getCards();
		int sum = 0;
		int aceCount = 0;
		for(int i = 0; i < h.size(); i++) {
			if(getValueOfCard(temp[i]) != 1) {
				sum += getValueOfCard(temp[i]);
			}
			if(getValueOfCard(temp[i]) == 1) {
				aceCount++;
			}
		}
		if((sum + (aceCount * 11)) <= 21) {
			sum += (aceCount * 11);
		} else {
			sum += aceCount;
		}
		return sum;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
