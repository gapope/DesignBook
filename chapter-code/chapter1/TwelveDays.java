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
package chapter1;

/**
 * Outputs the text of the poem "The Twelve Days of Christmas"
 * to the console. The code leverages the natural recursion in 
 * the structure of the poem.
 */
public class TwelveDays
{
	private static boolean digits = false;
	public static void main(String[] args)
	{
		digits = (args != null && args.length > 0 && args[0].equals("digits"));
		System.out.println(poem());
	}
	
	static String[] DAYS_WRITTEN = {"first", "second", "third", "fourth",
							"fifth", "sixth", "seventh", "eighth",
							"ninth", "tenth", "eleventh", "twelfth"};
	
	static String[] DAYS_DIGIT = {"1st", "2nd", "3rd", "4th",
			"5th", "6th", "7th", "8th",
			"9th", "10th", "11th", "12th"};
	
	static String[] GIFTS = {
			"a partridge in a pear tree",
			"two turtle doves",
			"three French Hens",
			"four Calling Birds",
			"five Golden Rings",
			"six Geese a Laying",
			"seven Swans a Swimming",
			"eight Maids a Milking",
			"nine Ladies Dancing",
			"ten Lords a Leaping",
			"eleven Pipers Piping",
			"twelve Drummers Drumming"
	};
	
	/*
	 * Returns the days string depending on if the argument to print days with digits was given
	 */
	static String dayString(int day)
	{
		return (digits) ? DAYS_DIGIT[day] : DAYS_WRITTEN[day];
	}
	
	/*
     * Returns the first line in the verse for a given day.
	 */
	static String firstLine(int day)
	{
	  return "On the " + dayString(day) +
	    " day of Christmas my true love sent to me:\n";
	}
	
	/*
     * Returns a string that lists all the gifts received on a given
     * day.
	 */
	static String allGifts(int day)
	{
		/*
		if( day == 0 ) 
		{ 
			return "and " + GIFTS[0]; 
		}
		else 
		{ 
			return GIFTS[day] + "\n" + allGifts(day-1);	
		}
		*/
		
		String giftList = "";
		
		for (int i = day; i > 0; --i)
		{
			giftList += GIFTS[i] + "\n";
		}

		return giftList + "and " + GIFTS[0];
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem()
	{
		String poem = firstLine(0) + GIFTS[0] + "\n\n";
		for( int day = 1; day < 12; day++ )
		{ 
			poem += firstLine(day) + allGifts(day) + "\n\n"; 
		}
		return poem;
	}
}
