
public class UniqueList extends IntegerList{
public UniqueList() {
	super();
}
public UniqueList(int capacity) {
	super(capacity);
}
public void add(int integer) {
	if(super.contains(integer)) {
		throw new IllegalArgumentException("The integer "+ integer+ " is already in the list.");
	}
	super.insert(super.size(), integer);
}
public void insert(int index, int integer) {
	if(super.contains(integer)) {
		throw new IllegalArgumentException("The integer "+ integer+ " is already in the list.");
	}
	super.insert(index, integer);
}
}
