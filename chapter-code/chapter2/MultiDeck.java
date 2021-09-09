package chapter2;

import java.util.ArrayList;

public class MultiDeck {
	private ArrayList<Deck> aDecks = new ArrayList<>();
	
	/**
	 * Creates a multiDeck, a list of decks.
	 * @param deckCount: number of decks to create
	 * @pre deckCount > 0
	 */
	public MultiDeck(int deckCount)
	{
		assert deckCount > 0;
		
		for (int i = 0; i < deckCount; ++i)
		{
			addDeck();
		}
	}
	
	/**
	 * Create a copy of the multiDeck
	 * @param multiDeck: multiDeck to copy
	 */
	public MultiDeck(MultiDeck multiDeck)
	{
		// Shallow copy
		//this.aDecks = new ArrayList<>(multiDeck.aDecks);
		
		// Deep Copy
		for (Deck deck : multiDeck.aDecks)
		{
			this.aDecks.add(new Deck(deck));
		}
	}
	
	public void addDeck()
	{
		aDecks.add(new Deck());
	}
}
