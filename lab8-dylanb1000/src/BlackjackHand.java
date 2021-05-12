import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
private static Map<Rank, Integer> CARD_VALUES=new HashMap<Rank, Integer>();
private static int MAX_VALUE=21;
private List<Card> cards=new ArrayList<Card>();
static {
	CARD_VALUES.put(Rank.TWO, 2);
	CARD_VALUES.put(Rank.THREE, 3);
	CARD_VALUES.put(Rank.FOUR, 4);
	CARD_VALUES.put(Rank.FIVE, 5);
	CARD_VALUES.put(Rank.SIX, 6);
	CARD_VALUES.put(Rank.SEVEN, 7);
	CARD_VALUES.put(Rank.EIGHT, 8);
	CARD_VALUES.put(Rank.NINE, 9);
	CARD_VALUES.put(Rank.TEN, 10);
	CARD_VALUES.put(Rank.JACK, 10);
	CARD_VALUES.put(Rank.QUEEN, 10);
	CARD_VALUES.put(Rank.KING, 10);
	CARD_VALUES.put(Rank.ACE, 11);
}
public BlackjackHand(Card c1,Card c2) {
	this.cards.add(c1);
	this.cards.add(c2);
}
public void addCard(Card card) {
	int HandValue=getValue();
	
	if(HandValue<MAX_VALUE) {
		cards.add(card);
	}
}
public static Map<Rank, Integer> getCardValues(){
	Map<Rank, Integer> cardValue=new HashMap<Rank, Integer>();
	cardValue.putAll(CARD_VALUES);
	return cardValue;
	
}
public List<Card> getCards(){
	List<Card> toReturn=new ArrayList<Card>();
	for(int i=0;i<cards.size();i++) {
		toReturn.add(cards.get(i));
	}
	return toReturn;
	
}
public int getValue() {
	int HandValue=0;
	int Aces=0;
	for(int i=0;i<cards.size();i++) {
		if(cards.get(i).getRank()==Rank.ACE) {
			Aces+=1;
			HandValue+=CARD_VALUES.get(cards.get(i).getRank());
			}
		else {
			HandValue+=CARD_VALUES.get(cards.get(i).getRank());
			}
		}
	for(int i=0;i<Aces;i++) {
		if(HandValue>MAX_VALUE) {
			HandValue-=10;
		}
	}
	return HandValue;
	}
public int size() {
	return cards.size();
}
public String toString() {
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
