import java.util.Comparator;

public class ShapeIDComparator implements Comparator<Shape>{
	@Override
	public int compare(Shape o1, Shape o2) {
		int c1=o1.getID();
		int c2=o2.getID();
		if(c1<c2) {
			return -1;
		}
		if(c1>c2) {
			return 1;
		}
		
		
		return 0;
	}
}
