import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		int c1=o1.length();
		int c2=o2.length();
		if(c1<c2) {
			return 1;
		}
		if(c1>c2) {
			return -1;
		}
		
		
		return 0;
	}
	

}