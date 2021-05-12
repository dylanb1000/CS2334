import java.io.FileNotFoundException;
import java.util.Arrays;
/**
 * Generation class stores and modifies boolean values in a boolean array named cellStates
 * 
 * 
 * @author Dylan Bui
 *
 */
public class Generation {
private final boolean[] cellStates; 
/**
 * Explicit constructor, takes any number of boolean values and will create a boolean array of those values
 * @param states		an arbitrary number of boolean values that will be stored 
 */
public Generation(boolean... states) {
	if(states==null || states.length==0) {
		this.cellStates=new boolean[1];
		this.cellStates[0]=false;
		}
	else {
		boolean[] copy=Arrays.copyOf(states, states.length);
		this.cellStates=new boolean[copy.length];
	for(int i=0;i<copy.length;i++) {
		this.cellStates[i]=copy[i];
		}
	}
	}
/**
 * Constructor, creates a generation with cells equal to the length of the string. Cell will be true if string character matches trueSymbol
 * @param states A String containing only two different characters
 * @param trueSymbol Will create a true cellState if trueSymbol matches a character in the states string
 */
public Generation(String states, char trueSymbol) {
	
	if(states==null|| states.length()==0) {
		this.cellStates=new boolean[1];
		this.cellStates[0]=false;
		
	}
	else {
		this.cellStates=new boolean[states.length()];
		for(int i=0;i<states.length();i++) {
			if(states.charAt(i)==trueSymbol) {
				this.cellStates[i]=true;
			}
			else {
				this.cellStates[i]=false;
			}
		}
	}
}
/**
 * Accessor method for the cellStates field
 * @param index Integer used to specify the index of the cellState that will be returned
 * @return cell State boolean value
 */
public boolean getState(int idx) {
	boolean[] copy=Arrays.copyOf(this.cellStates, this.cellStates.length);
	return copy[idx];
}
/**
 * Accessor method for the cellStates field
 * @return entire cellStates boolean array
 */
public boolean[] getStates() {
	boolean[] copy=Arrays.copyOf(this.cellStates, this.cellStates.length);
	return copy;
}
/**
 * Method to return a String representation of the cellStates with defined symbols
 * @param falseSymbol symbol to be used for the false states in the cellStates array
 * @param trueSymbol symbol to be used for the true states in the cellStates array
 * @return A String representation of the cellStates boolean array with true states replaced with trueSymbol and false states being replaced with falseSymbols
 */
public String getStates(char falseSymbol, char trueSymbol) {
	String cellStatesString="";
	for(int i=0;i<this.cellStates.length;i++) {
		if(this.cellStates[i]==true) {
			cellStatesString=cellStatesString+trueSymbol;
		}
		else if(this.cellStates[i]==false){
			cellStatesString=cellStatesString+falseSymbol;
		}
	}
	return cellStatesString;
}
/**
 * Method used to find the length of the boolean array
 * @return length of the cellStates boolean array as an Integer
 */
public int size() {
	return this.cellStates.length;
}
}