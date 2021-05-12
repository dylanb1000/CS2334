import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
//worked with nathan bui for this method only
	/**
	 * Search a sorted list of strings using binary search. Return a list of
	 * the indices of the strings checked during the search in the order they
	 * are checked. If the target string is not found, append -1 to the end of
	 * the list. Otherwise, the last element is the index of the target.
	 *
	 * @param strings  the list to be searched
	 * @param target  the string to be searched for
	 * @param fromIdx  the index of the first string in the range of strings to
	 *                 be searched (inclusive)
	 * @param toIdx  the index of the last string in the range of strings to be
	 *               searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         If the target is not in the list, the last element is -1.
	 */
	public static List<Integer> binarySearch(List<String> strings,
			String target, int fromIdx, int toIdx) {
		int midIdx=(fromIdx+toIdx)/2;
		if(fromIdx>toIdx) {
			List<Integer> toReturn=new ArrayList<Integer>();
			System.out.println(-1);
			toReturn.add(0,-1);
			return toReturn;
		}
		int compareString=target.compareTo(strings.get(midIdx));
		if(compareString>0) {
			System.out.println(midIdx);
			fromIdx=midIdx+1;
			List<Integer> toReturn=binarySearch(strings,target,fromIdx,toIdx);
			toReturn.add(0, midIdx);
			return toReturn;
		}
		else if(compareString<0){
			System.out.println(midIdx);
			toIdx=midIdx-1;
			List<Integer> toReturn=binarySearch(strings,target,fromIdx,toIdx);
			toReturn.add(0, midIdx);
			return toReturn;
		}
		else if(compareString==0) {
			List<Integer> toReturn=new ArrayList<Integer>();
			toReturn.add(0, midIdx);
			System.out.println(midIdx);
			return toReturn;
		}
		List<Integer> toReturn=new ArrayList<Integer>();
		return toReturn;
	}
}
