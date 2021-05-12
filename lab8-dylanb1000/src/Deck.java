import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
private List<Card> cards=new ArrayList<Card>();
public Deck() {
	System.out.println("Deck");
	Rank[] allRanks=Rank.values();
	Suit[] allSuits=Suit.values();
	for(int i=0;i<allSuits.length;i++) {
		for(int j=0;j<allRanks.length;j++) {
			this.cards.add(new Card(allRanks[j],allSuits[i]));
		}
	}
}
public Card draw() {
	System.out.println("draw");
	if(cards.isEmpty()) {
		return null;
	}
	else if(cards.get(0)==null) {
		return null;
	}
	else {
		Card frontCard=cards.get(0);
		cards.remove(0);
		return frontCard;
	}
}
public List<Card> draw(int count){
	System.out.println("decksize="+cards.size()+" draw_count="+count);
	List<Card> toReturn=new ArrayList<Card>();
	if(count<=0 || cards.size()==0) {
		return List.of();
	}
	else if(count>cards.size()) {
		for(int i=0;i<=cards.size()+1;i++) {
			toReturn.addAll(cards);
			cards=new ArrayList<Card>();
		}
		return toReturn;
	}
	else{
	for(int i=0;i<count;i++) {
		toReturn.add(cards.get(0));
		cards.remove(0);
	}
	return toReturn;
	}
}
public void shuffle() {
	System.out.println("shuffle");
	Collections.shuffle(cards);
}
public int size() {
	System.out.println("size");
	return cards.size();
}
public String toString() {
	System.out.println("toString");
	if(cards.isEmpty()) {
		return "[]";
	}
	else {
	String finalString="[";
	for(int i=0;i<cards.size()-1;i++) {
		finalString=finalString+cards.get(i).toString()+", ";
		
	}
	finalString=finalString+cards.get(cards.size()-1).toString()+"]";
	return finalString;
	}
}
}
