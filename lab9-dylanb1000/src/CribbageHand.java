import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CribbageHand {
public final static Map<Rank, Integer> CARD_VALUES=Map.ofEntries(
		Map.entry(Rank.ACE, 1),
		Map.entry(Rank.TWO, 2),
		Map.entry(Rank.THREE, 3),
		Map.entry(Rank.FOUR, 4),
		Map.entry(Rank.FIVE, 5),
		Map.entry(Rank.SIX, 6),
		Map.entry(Rank.SEVEN, 7),
		Map.entry(Rank.EIGHT, 8),
		Map.entry(Rank.NINE, 9),
		Map.entry(Rank.TEN, 10),
		Map.entry(Rank.JACK, 10),
		Map.entry(Rank.QUEEN, 10),
		Map.entry(Rank.KING, 10));
public final List<Card> cards; 
public CribbageHand(Card c1,Card c2,Card c3,Card c4) {
	if(c1==null || c2==null ||c3==null ||c4==null ) {
		throw new NullPointerException();
	}
	else {
		this.cards=List.of(c1,c2,c3,c4);
	}
}
public Set<Set<Card>> fifteens(Card starter){
	Set<Set<Card>> Sets=new HashSet<Set<Card>>();
	List<Card> cards=new ArrayList<Card>();
	for(Card card:this.cards) {
		cards.add(card);
	}
	cards.add(starter);
	Set<Set<Card>> powerSet=powerSet(cards);
	for(Set<Card> sets:powerSet) {
		int cardValues=0;
		for(Card card:sets) {
			cardValues+=CARD_VALUES.get(card.getRank());
		}
		if(cardValues==15) {
			Sets.add(sets);
		}
	}
	return Sets;
	
}
//iterative not recursive
public static Set<Set<Card>> powerSet(List<Card> cards){
	Set<Set<Card>> powerSet = new HashSet<Set<Card>>();
	powerSet.add(new HashSet<Card>());
	  for (Card item : cards) {
	    Set<Set<Card>> newPowerSet = new HashSet<Set<Card>>();
	    for (Set<Card> subset : powerSet) {
	      newPowerSet.add(subset);
	      Set<Card> newSubset = new HashSet<Card>(subset);
	      newSubset.add(item);
	      newPowerSet.add(newSubset);
	    }
	    powerSet = newPowerSet;
	  }
	  return powerSet;
}
}
