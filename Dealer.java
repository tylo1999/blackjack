

/**
 * The Dealer in your game of BlackJack. Draws until he/she gets 17 points or has 5 cards.
 *
 */
public class Dealer {
	/**
	 * The dealers hand
	 */
	Hand hand;
	
	/**
	 * Construct a new dealer with an empty hand
	 */
	public Dealer() {
		hand = new Hand();
	}
	
	/**
	 * Dealer draws a card if his hand is worth less than 17 points and has less than 5 cards in in his hand.
	 * 
	 * @param deck
	 * @return
	 */
	public Card playTurn(Deck deck) {
		if(BlackJack.getValueOfHand(hand) < 17 && hand.size() < 5) {
			Card temp = deck.draw();
			hand.addCard(temp);
			return temp;
		} else {
			return null;
		}
	}
	
	/**
	 * A method to check if the dealer has busted
	 * @return boolean true if the dealer has busted
	 */
	public boolean busted() {
		if(BlackJack.getValueOfHand(hand) > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * A method to check if the dealer will draw a card.
	 * @return
	 */
	public boolean isDone() {
		if(BlackJack.getValueOfHand(hand) < 17 && hand.size() < 5) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns the dealers cards to the deck
	 * @param d Deck to return the cards to
	 */
	public void returnCardstoDeck(Deck d) {
		Card [] temp = hand.getCards();
		for(int i = 0; i < hand.size(); i++) {
		d.addToBottom(temp[i]);
		}
		hand.emptyHand();
	}
	/**
	 * @return Hand the dealer's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
