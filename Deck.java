
import java.util.Random;

/**
 * Class representing a standard 52 card deck. Allows users to shuffle, draw,
 * and add cards to the bottom for the purpose of playing various card games.
 */
public class Deck {
	
	/**
	 * Cards in the deck
	 */
	private Card [] cards;
	
	/**
	 * The number of cards in the physical deck on the table.
	 */
	private int numCardsInDeck;
	
	/**
	 * Create a standard 52 card deck w/ one of each type (Ace, King, Queen...) for each Suit (Hearts, Spades ..)
	 */
	public Deck() {
		
		Card.Suit [] suits = Card.Suit.values(); //creates an array of all of the Suits
		Card.Type [] types = Card.Type.values(); //creates an array of all of the Types
		cards = new Card[suits.length*types.length]; //sets the size of cards to 52 (types & suits)
		numCardsInDeck = 0;
		
		for(int i =0; i<suits.length; i++)
		{
			for(int j = 0; j<types.length; j++)
			{
				//Assigns 52 unique cards to the cards deck
				cards[numCardsInDeck] = new Card(types[j], suits[i]); 
				numCardsInDeck++; //increments the number of cards in the deck
			}
		}	
	}
	/**
	 * Draws card from the top
	 * @return the top card
	 */
	public Card draw() {
		if(numCardsInDeck == 0) {
			System.out.println("No more cards in deck!");
			return null;
		} else {
			int temp = numCardsInDeck;
			numCardsInDeck--;
			return cards[temp-1];
		}
	}

	/**
	 * Swaps card at a with card at b
	 * @param a card to be swapped with b
	 * @param b card to be swapped with a
	 */
	private void swap(int a, int b) {
		if(a <= numCardsInDeck && b<= numCardsInDeck) {
		Card temp = cards[a];
		cards [a] = cards[b];
		cards[b] = temp;
		}
	}
	
	/**
	 * Shifts all the cards in the deck right by one place
	 */
	private void shiftRightOne() {
		if(numCardsInDeck == 52) {
			System.out.println("Deck is full");
		} else {
			for(int i = numCardsInDeck; i > 0; i--) {
				cards[i] = cards[i-1];
			}
		}
		
	}	
	/**
	 * Add c to the bottom of the deck
	 * Print "Deck Full" when count equals the size of the deck
	 * @param c card to add
	 */	
	public void addToBottom(Card c) {
		if(numCardsInDeck == 52) {
			System.out.println("Deck full: bottom");
		} else {
			
			shiftRightOne();
			cards[0] = c;
			numCardsInDeck++;

		}
 	}

	/**
	 * Shuffles the deck by swapping the cards 100 times
	 */
	public void shuffle() {
		Random r = new Random();
		Random r2 = new Random();
		for(int i = 0; i < 100; i++) {
			int first = r.nextInt(numCardsInDeck);
			int second = r2.nextInt(numCardsInDeck);
			swap(first, second);
	}
	}
	/**
	 * Shuffles the deck by swapping cards n times
	 * @param n number of swaps
	 */
	public void shuffle(int n) {
		Random r = new Random();
		Random r2 = new Random();
		for(int i = 0; i < n; i++) {
			int first = r.nextInt(numCardsInDeck);
			int second = r2.nextInt(numCardsInDeck);
			swap(first, second);
		}
	}

}
