import java.util.List;

public class Test {
	public static void main(String[] args){
		List<String> strings = List.of("b", "d", "f", "h", "j", "l", "n");
		System.out.println(BinarySearch.binarySearch(strings, "e", 0, 6));
     
  }
}
