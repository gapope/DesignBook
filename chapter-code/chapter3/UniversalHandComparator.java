package chapter3;

import java.util.Comparator;

import chapter3.UniversalComparatorSol.Order;

public class UniversalHandComparator implements Comparator<Hand> {
	public enum Order { ASCENDING, DESCENDING };
	private Order aOrder;
	
	public UniversalHandComparator(Order pOrder) {
		aOrder = pOrder;
	}
	
	public int compare(Hand pHand1, Hand pHand2)
	{
		if (aOrder == Order.ASCENDING)
		{
			return pHand1.size() - pHand2.size();
		}
		else
		{
			return pHand2.size() - pHand1.size();
		}
	}
	
	public void setOrder(Order pOrder)
	{
		aOrder = pOrder; 
	}
	
	public static void main(String[] args)
	{
		Hand hand1 = new Hand(3);
		Hand hand2 = new Hand(3);
		hand1.add(new Card(Rank.ACE, Suit.CLUBS));
		UniversalHandComparator comparator = new UniversalHandComparator(Order.ASCENDING);
		System.out.println(comparator.compare(hand1, hand2));
		comparator.setOrder(Order.DESCENDING);
		System.out.println(comparator.compare(hand1, hand2));
	}
}
