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
package chapter2;

/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class Card
{
	public static void main(String[] args)
	{
		// Test all values
		for( Rank rank : Rank.values() )
		{
			for( Suit suit : Suit.values() )
			{
				Card card = new Card(rank, suit);
				assert card.getRank() == rank;
				assert card.getSuit() == suit;
				
				if (suit == Suit.DIAMONDS || suit == Suit.HEARTS)
				{
					assert suit.color() == Color.RED;
				}
				else
				{
					assert suit.color() == Color.BLACK;
				}
			}
		}
		
		System.out.println("Success");
	}
	
	//private Rank aRank;
	//private Suit aSuit;
	
	private Boolean[] aSuitBool = new Boolean[2];
	private Boolean[] aRankBool = new Boolean[4];
	
	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;

		//aRank = pRank;
		//aSuit = pSuit;
		
		int suitValue = pSuit.ordinal();
		valToBinaryBoolArr(suitValue, aSuitBool);
		
		int rankValue = pRank.ordinal();
		valToBinaryBoolArr(rankValue, aRankBool);
	}
	
	/*
	 * Represent an integer value with an array of bools where each bool is a bit
	 */
	private void valToBinaryBoolArr(int val, Boolean[] boolArr)
	{
		// TODO assert binary array large enough for value
		
		for (int i = 0; i < boolArr.length; ++i)
		{
			boolArr[i] = (val % 2) == 1;
			val /= 2;
		}
	}
	
	/*
	 * Take a bool array which represents a number in binary and compute the decimal value
	 */
	private int binaryBoolArrToVal(Boolean[] boolArr)
	{
		int val = 0;
		
		// TODO assert/handle sign, assert <= 32 bits
		
		for (int i = boolArr.length - 1; i >= 0; --i)
		{
			val *= 2;

			if (boolArr[i])
			{
				val++;
			}
			
		}
		
		return val;
	}
	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank()
	{
		//return aRank;
		return Rank.values()[binaryBoolArrToVal(aRankBool)];
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		//return aSuit;
		return Suit.values()[binaryBoolArrToVal(aSuitBool)];
	}
}
