
public class SortedList extends IntegerList{
public SortedList() {
	super();
}
public SortedList(int capacity) {
	super(capacity);
}
public void add(int integer) {
if(super.size()==0) {
	super.insert(super.size(), integer);
}
else{
for(int i=0;i<super.size();i++) {
	if(integer<super.get(0)) {
		super.insert(i, integer);
		break;
			}
	else if(integer>super.get(i) && integer<super.get(i+1)) {
		super.insert(i+1, integer);
		break;
			}
	else if(integer==super.get(i)) {
		super.insert(i, integer);
		break;
	}
	else if(integer>super.get(super.size()-1)) {
		super.insert(super.size(), integer);
		break;
			}
		}
	}

}
public void insert(int index, int integer) {
	throw new UnsupportedOperationException();
}
}
