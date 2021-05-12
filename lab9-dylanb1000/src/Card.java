import java.util.Objects;

public class Card{
private Rank rank;
private Suit suit;
public Card(Rank rank,Suit suit) {
	if(rank==null || suit==null) {
		throw new NullPointerException();
	}
	else {
	this.rank=rank;
	this.suit=suit;
	}
}
public int compareTo(Card card) {
	if(this.suit.compareTo(card.suit)==card.suit.compareTo(this.suit)) {
		return this.rank.compareTo(card.rank);
	}
	else {
		return this.suit.compareTo(card.suit);
	}
}
public boolean equals(Object obj) {
	if(obj==null) {
		return false;
	}
	else {
	if(obj.getClass()==this.getClass()) {
		Card o=(Card)obj;
		if(o.suit==this.suit && o.rank==this.rank) {
			return true;
		}
		else {
			return false;
		}
	}
	else {
		return false;
		}
	}
}
public Rank getRank() {
	return rank;
}
public Suit getSuit() {
	return suit;
}
public int hashCode() {
	return Objects.hash(rank,suit);
}
public String toString() {
	return rank.toString()+suit.toString();
}
}
