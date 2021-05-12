
public class PrimeList extends IntegerList{
private int FIRST_PRIME=2;
public PrimeList() {
	super();
}
public PrimeList(int upperBound) {
	if(upperBound<=0) {
		throw new IllegalArgumentException("The upper bound must be positive.");
	}
	else {
		for(int i=FIRST_PRIME;i<=upperBound;i++) {
			boolean prime=true;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					prime=false;
					break;
				}
			}
			if(prime==true) {
				super.insert(super.size(),i);
			}
		}
	}
}
public void add(int upperBound) {
	if(super.size()==0 && upperBound<FIRST_PRIME) {
		throw new IllegalArgumentException("The upper bound cannot be less than 2.");
	}
	else if(super.size()!=0) {
		if(upperBound<=super.get(super.size()-1)){
			throw new IllegalArgumentException("The upper bound must be greater than the last prime in the list: "+super.get(super.size()-1)+".");
			}
		}
		int lastPrime;
		if(super.size()==0) {
			lastPrime=0;
		}
		else {
			lastPrime=super.get(super.size()-1);
		}
		for(int i=FIRST_PRIME;i<=upperBound;i++) {
			boolean prime=true;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					prime=false;
					break;
				}
			}
			if(prime==true && i>lastPrime) {
				super.insert(super.size(),i);
			}
		}
	
}
public void insert(int index,int integer) {
	throw new UnsupportedOperationException();
}
public int remove(int index) {
	if (index < 0 || index >= super.size()) {
		String message = "The index is outside the range [0, "
				+ (super.size() - 1) + "].";
		throw new IndexOutOfBoundsException(message);
	}
	int count=0;
	for(int i=super.size()-1;i>=index;i--) {
		super.remove(i);
		count++;
	}
	return count;
	
}
}
