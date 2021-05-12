import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoFishHand {
private static int BOOK_SIZE=4;
private Set<Rank> books=new HashSet<Rank>();
private Map<Rank, Set<Card>> cards=new HashMap<Rank, Set<Card>>();
private Map<String, Set<Card>> temp=new HashMap<String, Set<Card>>();
{
	temp.put("1", new HashSet<Card>());
	temp.put("2", new HashSet<Card>());
	temp.put("3", new HashSet<Card>());
	temp.put("4", new HashSet<Card>());
	temp.put("5", new HashSet<Card>());
	temp.put("6", new HashSet<Card>());
	temp.put("7", new HashSet<Card>());
	temp.put("8", new HashSet<Card>());
	temp.put("9", new HashSet<Card>());
	temp.put("10",new HashSet<Card>());
	temp.put("J", new HashSet<Card>());
	temp.put("Q", new HashSet<Card>());
	temp.put("K", new HashSet<Card>());
	temp.put("A", new HashSet<Card>());
}

public GoFishHand(Collection<Card> cards) {

	
	if(cards.isEmpty()) {
		throw new IllegalArgumentException();
	}
	else {
		for (Card e: cards) {
			this.cards.put(e.getRank(), temp.get(e.getRank().toString()));
			this.cards.get(e.getRank()).add(e);
			if(this.cards.get(e.getRank()).size()==BOOK_SIZE) {
				this.cards.remove(e.getRank());
				books.add(e.getRank());
			}
		}

	}
}
public void addCard(Card card) {
	this.cards.put(card.getRank(), temp.get(card.getRank().toString()));
	this.cards.get(card.getRank()).add(card);
	if(this.cards.get(card.getRank()).size()==4) {
		this.cards.remove(card.getRank());
		books.add(card.getRank());
	}
}
public void addCards(Collection<Card> cards) {
	for (Card e: cards) {
		this.cards.put(e.getRank(), temp.get(e.getRank().toString()));
		this.cards.get(e.getRank()).add(e);
		if(this.cards.get(e.getRank()).size()==4) {
			this.cards.remove(e.getRank());
			books.add(e.getRank());
		}
	}
}
public Set<Rank> getBooks(){
	Set<Rank> copyBooks=new HashSet<Rank>();
	copyBooks.addAll(books);
	for(Rank e: books) {
		copyBooks.add(e);
	}
	return copyBooks;
}
public Map<Rank, Set<Card>> getCards(){
	Map<Rank, Set<Card>> copyCards=new HashMap<Rank, Set<Card>>();
	Set<Rank> cardsKey=cards.keySet();
	for(Rank e:cardsKey) {
		Set<Card> copy=new HashSet<Card>();
		for(int i=0;i<cards.get(e).size();i++) {
			for(Card f:cards.get(e)) {
				copy.add(f);
			}
		}
		copyCards.put(e, copy);
	}
	return copyCards;
}
public Map<Rank, Integer> getRankCounts(){
	Map<Rank, Integer> rankCount=new HashMap<Rank, Integer>();
	Set<Rank> cardsKey=cards.keySet();
	for(Rank e:books) {
		rankCount.put(e, 4);
	}
	for(Rank e:cardsKey) {
		rankCount.put(e, cards.get(e).size());
	}
	return rankCount;
}
public Set<Card> removeCards(Rank rank){
	Set<Card> toReturn=new HashSet<Card>();
	if(cards.containsKey(rank)) {
		toReturn=cards.get(rank);
		cards.remove(rank);
		return toReturn;
	}
	else {
		return toReturn;
	}

}
public int size(){
	int count=0;
	Set<Rank> cardsKey=cards.keySet();
	for(Rank e:cardsKey) {
		count+=cards.get(e).size();
	}
	return count;
}
public String toString() {
	String toReturn="CARDS: {";
	Set<Rank> cardsKey=cards.keySet();
	for(Rank e:cardsKey) {
		toReturn=toReturn+e.toString()+"="+cards.get(e).toString();
	}
	toReturn=toReturn+"}"+System.lineSeparator();
	toReturn=toReturn+"BOOKS: [";
	for(Rank e:books) {
		toReturn=toReturn+e.toString();
	}
	return toReturn+"]";
}
}
