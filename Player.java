
/**
 * A player in a blackJack game
*
*/
public class Player {
	/**
	 * The players hand
	 */
	private Hand hand;
	
	/**
	 * Instantiates the hand instance variable.
	 */
	public Player() {
		hand = new Hand();
	}
	
	/**
	 * @return true if the player has bused
	 */
	public boolean busted() {
		if(BlackJack.getValueOfHand(hand) > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * empty the player hand into the cards
	 * @param d deck that receives the cards
	 */
	public void returnCardstoDeck(Deck d) {
		Card [] temp = hand.getCards();
		for(int i = 0; i < hand.size(); i++) {
		d.addToBottom(temp[i]);
		}
		hand.emptyHand();
	}
	/**
	 * @return the player's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
