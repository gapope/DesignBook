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
 * Represents the suit of a playing card.
 */
public enum Suit 
{ 
	NO_SUIT, CLUBS, DIAMONDS, SPADES, HEARTS;
	
	public Color color()
	{
		switch (this)
		{
			case DIAMONDS:
			case HEARTS:
				return Color.RED;
			case CLUBS:
			case SPADES:
				return Color.BLACK;
			default:
				return Color.NO_COLOR;	
		}
	}
}

