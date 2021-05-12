import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> dylanBui=new ArrayList<String>();
		dylanBui.add("a");
		dylanBui.add("cc");
		dylanBui.add("bb");
		dylanBui.add("ddd");
		dylanBui.add("eeee");
		System.out.print(dylanBui);
		
		StringLengthComparator comparator=new StringLengthComparator();
		Collections.sort(dylanBui, comparator);
		System.out.print(dylanBui);
	}

}
