
public class ImmutableList extends IntegerList{
public ImmutableList(int... integers){
	for(int i=0;i<integers.length;i++) {
		super.insert(i, integers[i]);
	}
}
public void add(int integer) {
	throw new UnsupportedOperationException("");
}
public void insert(int index, int integer) {
	throw new UnsupportedOperationException("");
}
public int remove(int index) {
	throw new UnsupportedOperationException("");
}
}
