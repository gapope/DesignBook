package chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand implements Comparable<Hand> {

	private final int aCardCount;
	private final List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new hand of cards
	 * @param pCardCount: maximum number of cards this hand can contain
	 * @pre pCardCount > 0
	 */
	public Hand(int pCardCount)
	{
		assert pCardCount > 0;
		aCardCount = pCardCount;
	}
	
	/**
	 * Adds a card to the hand
	 * @param pCard: card to be added to the hand
	 * @pre pCard != null
	 * @pre hand cannot be full
	 */
	public void add(Card pCard)
	{
		assert pCard != null;
		assert !isFull();
		
		aCards.add(pCard);
	}
	
	/**
	 * Removes a specific card from the hand, 
	 * if card is not in the hand nothing is done
	 * @param pCard: card to be removed from the hand
	 * @pre pCard != null
	 */
	public void remove(Card pCard)
	{
		assert pCard != null;
		
		aCards.remove(pCard);
	}
	
	/**
	 * Check for the presence of a card in the hand
	 * @param pCard: card to be found in the deck
	 * @return whether or not the card is contained in the hand
	 * @pre pCard != null
	 */
	public boolean contains(Card pCard)
	{
		assert pCard != null;
		return aCards.contains(pCard);
	}
	
	/**
	 * @return the number of cards in the hand
	 */
	public int size()
	{
		return aCards.size();
	}
	
	/**
	 * @return True if there are no cards in the hand
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return True if the number of cards in the hand is the limit set in the constructor
	 */
	public boolean isFull()
	{
		return aCards.size() == aCardCount;
	}
	
	/**
	 * Factory method for a comparator which prefers larger hand sizes
	 * @return Comparator function object
	 */
	public static Comparator<Hand> createLargerSizeComparator()
	{
		return new Comparator<Hand>()
		{
			public int compare(Hand pHand1, Hand pHand2)
			{ return pHand1.size() - pHand2.size(); }
		};
	}
	
	/**
	 * Factory method for a comparator which prefers smaller hand sizes
	 * @return Comparator function object
	 */
	public static Comparator<Hand> createSmallerSizeComparator()
	{
		return new Comparator<Hand>()
		{
			public int compare(Hand pHand1, Hand pHand2)
			{ return pHand2.size() - pHand1.size(); }
		};
	}
	
	@Override
	public int compareTo(Hand pHand)
	{
		return size() - pHand.size();
	}
	
	public static void main(String[] args)
	{
		Hand hand1 = new Hand(5);
		Hand hand2 = new Hand(5);
		Deck deck = new Deck();
		deck.shuffle();
		hand1.add(deck.draw());
		hand2.add(deck.draw());
		hand2.add(deck.draw());
		System.out.println(hand1.compareTo(hand2));
		System.out.println(hand2.compareTo(hand1));
		System.out.println(Hand.createLargerSizeComparator().compare(hand1, hand2));
		System.out.println(Hand.createSmallerSizeComparator().compare(hand1, hand2));
	}
}
