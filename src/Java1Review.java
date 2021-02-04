/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
//used internet to search up syntax
public class Java1Review {

	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
		
	}
	public static  String main(String string) {
		return "Overloaded main method was passed \""+string+ "\".";
	}
	public static double divide(double num1, double num2) {
		double num3=num1/num2;
		return num3;
	}
	public static int divide(int num1,int num2) {
		int num3=num1/num2;
		return num3;
	}
	
	public static boolean isDivisibleBy7(int num1) {
		if(num1%7==0){
			return true;}
		return false;
	}
	public static int findMin(int[] intArray) {
		int min=100000;
		for(int i=0;i<intArray.length;i++) {
			if(intArray[i]<min) {
				min=intArray[i];
			}
		}
		return min;
	}
	public static int findMin(int num1,int num2, int num3) {
		if(num1<num2 && num1<num3) {
			return num1;
		}
		else if(num2<num1 && num2<num3) {
			return num2;
		}
		else {
			return num3;
		}
		
	}
	public static double average(int[] intArray) {
		double all=0;
		for(int i=0;i<intArray.length;i++) {
			all+=intArray[i];
		}
		return (all/intArray.length);
	}
	public static String[] toLowerCase(String[] strings) {
		for(int i=0;i<strings.length;i++) {
			strings[i]=strings[i].toLowerCase();
		}
		return strings;
	}
	public static String[] toLowerCaseCopy(String[] strings) {
		String[] finalString=new String[strings.length];
		for(int i=0;i<strings.length;i++) {
			finalString[i]=strings[i].toLowerCase();
		}
		return finalString;
	}
	public static int[] removeDuplicates(int[] array) {
		if(array.length==1) {
			return array;
		}
		for(int i=0;i<array.length;i++) {
			int current=array[i];
			for(int j=i+1;j<array.length;j++) {
				if(array[j]==current) {
					array[j]=0;
					array[i]=0;
				}
				
			}
		}
		
		return array;
	}

}
