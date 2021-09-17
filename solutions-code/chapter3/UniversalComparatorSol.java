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

import java.util.Comparator;

/**
 * Can compare hands in either increasing or decreasing number of 
 * cards. This is not an example of good design, but the idea of the 
 * exercise is to think about why that may be.
 */
public class UniversalComparatorSol implements Comparator<HandSol>
{
	public enum Order { ASCENDING, DESCENDING }
	
	private Order aOrder = Order.ASCENDING;
	
	/**
	 * Creates a comparator that compares in increasing size by default
	 */
	public UniversalComparatorSol() {}
	
	/**
	 * @param pOrder Specifies the order
	 */
	public UniversalComparatorSol(Order pOrder)
	{
		aOrder = pOrder;
	}

	@Override
	public int compare(HandSol pHand1, HandSol pHand2)
	{
		if( aOrder == Order.ASCENDING )
		{
			return pHand1.size() - pHand2.size();
		}
		else
		{
			return pHand2.size() - pHand1.size();
		}
	}
	
	/**
	 * @param pOrder The comparison order.
	 * @pre pOrder != null
	 */
	public void setOrder(Order pOrder)
	{
		aOrder = pOrder;
	}
	
	/**
	 * Driver program.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		HandSol hand1 = new HandSol(3);
		HandSol hand2 = new HandSol(3);
		hand1.add(new Card(Rank.ACE, Suit.CLUBS));
		UniversalComparatorSol comparator = new UniversalComparatorSol();
		System.out.println(comparator.compare(hand1, hand2));
		comparator.setOrder(Order.DESCENDING);
		System.out.println(comparator.compare(hand1, hand2));
	}
}
