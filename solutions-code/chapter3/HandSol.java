/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */
public class HandSol implements Iterable<Card>, Comparable<HandSol>
{
	private final List<Card> aCards = new ArrayList<>();
	private final int aMaxCards;
	
	/**
	 * Creates a new, empty hand, which can hold
	 * a maximum of pMaxCards.
	 * 
	 * @param pMaxCards The maximum number of cards allowed in this hand.
	 * @pre pMaxCards > 0;
	 */
	public HandSol(int pMaxCards)
	{
		assert pMaxCards > 0;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * Add pCards to the hand.
	 * @param pCard The card to add.
	 * @pre !isFull()
	 * @pre pCard != null;
	 */
	public void add(Card pCard)
	{
		assert pCard != null;
		assert !isFull();
		aCards.add(pCard);
	}
	
	/**
	 * @return True if the number of cards in the hand
	 * is the maximum number of cards allowable, as specified
	 * in the constructor.
	 */
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}
	
	/**
	 * @return True if there are no cards in this hand.
	 */
	public boolean isEmpty()
	{
		return aCards.size() == 0;
	}
	
	/**
	 * Removes pCards if it is in the hand. If it is not in the
	 * hand, does nothing. 
	 * 
	 * @param pCard The card to remove.
	 * @pre pCards != null;
	 */
	public void remove(Card pCard)
	{
		assert pCard != null;
		aCards.remove(pCard);
	}
	
	/**
	 * @param pCard A card to check for containment.
	 * @return True if pCard is a card in this hand.
	 * @pre pCard != null
	 */
	public boolean contains(Card pCard)
	{
		assert pCard != null;
		return aCards.contains(pCard);
	}

	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

	@Override
	public int compareTo(HandSol pHand)
	{
		return aCards.size() - pHand.aCards.size();
	}
	
	public static Comparator<HandSol> createAscendingComparator()
	{
		return new Comparator<HandSol>() {

			@Override
			public int compare(HandSol pHand1, HandSol pHand2)
			{
				return pHand1.aCards.size() - pHand2.aCards.size();
			}};
	}
	
	public static Comparator<HandSol> createDescendingComparator()
	{
		return new Comparator<HandSol>() {

			@Override
			public int compare(HandSol pHand1, HandSol pHand2)
			{
				return pHand2.aCards.size() - pHand1.aCards.size();
			}};
	}
	
	/**
	 * @return The number of cards currently in the hand.
	 */
	public int size()
	{
		return aCards.size();
	}
	
	/**
	 * Creates a comparator that compares hands in terms of ascending number
	 * of cards of rank pRank in the hand.
	 * 
	 * @param pRank The rank to test against.
	 * @return A new Comparator instance that can compare by number
	 * of cards of the specified rank.
	 */
	public static Comparator<HandSol> createByRankComparator(Rank pRank)
	{
		return new Comparator<HandSol>()
		{
			@Override
			public int compare(HandSol pHand1, HandSol pHand2)
			{
				return countCards(pHand1, pRank) - countCards(pHand2, pRank);
			}
			
			private int countCards(HandSol pHand, Rank pRank)
			{
				int total = 0;
				for( Card card : pHand)
				{
					if( card.getRank() == pRank )
					{
						total++;
					}
				}
				return total;
			}
		};
	}
	
	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		HandSol hand1 = new HandSol(5);
		HandSol hand2 = new HandSol(5);
		Deck deck = new Deck();
		deck.shuffle();
		hand1.add(deck.draw());
		hand2.add(deck.draw());
		hand2.add(deck.draw());
		System.out.println(hand1.compareTo(hand2));
		System.out.println(hand2.compareTo(hand1));
		System.out.println(HandSol.createAscendingComparator().compare(hand1, hand2));
		System.out.println(HandSol.createDescendingComparator().compare(hand1, hand2));
	}
}
