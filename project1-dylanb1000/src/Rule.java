/**
 * Rule class represents 1 of the 256 rules defined by Wolfram. This class provides methods to develop the generation and automaton class.
 * 
 * 
 * @author Dylan Bui
 *
 */
public class Rule {
private int ruleNumber;
private String binaryRule;
private boolean[] table1= {true,true,true};
private boolean[] table2= {true,true,false};
private boolean[] table3= {true,false,true};
private boolean[] table4= {true,false,false};
private boolean[] table5= {false,true,true};
private boolean[] table6= {false,true,false};
private boolean[] table7= {false,false,true};
private boolean[] table8= {false,false,false};
private boolean[][] table= {table1,table2,table3,table4,table5,table6,table7,table8};
/**
 * Explicit constructor, creates a rule based on the rule number provided
 * 
 * @param ruleNum	Integer used to represent the rule number that will be set to the class(range 1-256)

 */
public Rule(int ruleNum) {
	if(ruleNum<=0) {
		this.ruleNumber=0;
		this.binaryRule="00000000";
		
	}
	else if(ruleNum>=255){
		this.ruleNumber=255;
		this.binaryRule=Integer.toBinaryString(ruleNumber);
	}
	else {
		this.ruleNumber=ruleNum;
		this.binaryRule=Integer.toBinaryString(ruleNumber);
		while(binaryRule.length()<8) {
			binaryRule="0"+binaryRule;
		}
	}
}
/**
 * Accessor method for the rule number field
 * @return the rule number as an Integer
 */
public int getRuleNum() {
	return this.ruleNumber;
}
/**
 * Method used to retrieve the state of a cell in the cellStates array as well as its neighbors.
 * @param idx Integer index used to retrieve the state of a cell and its neighbors.
 * @param gen Generation that will be used to retrieve the cell States.
 * @return boolean array of a cell State and its neighbors.
 */
public static boolean[] getNeighborhood(int idx, Generation gen) {
	boolean[] neighborhood= {gen.getState((idx+gen.size()-1)%gen.size()),gen.getState(idx%gen.size()),gen.getState((idx+1)%gen.size())};
	return neighborhood;
}
/**
 * Method used to retrieve the next state of the middle cell given a neighborhood of cell states using the rule assigned
 * @param neighborhood boolean array containing the cell states that will be used
 * @return boolean value of the next state of the middle cell State in the neighborhood
 */
public boolean evolve(boolean[] neighborhood){
	for(int i=0;i<9;i++) {
		if(neighborhood[0]==table[i][0] && neighborhood[1]==table[i][1] && neighborhood[2]==table[i][2]) {
			if(binaryRule.charAt(i)=='1') {
				return true;
			}
			else {
				return false;
			}
		}
	}
	return true;
}
/**
 * Method used to apply the assigned rule to a generation and create the next generation
 * @param gen Generation that the assigned rule will be used on to create the next generation
 * @return Generation that was created from the rule being applied to the given generation
 */
public Generation evolve(Generation gen) {
	boolean[] nextGen=new boolean[gen.size()];
	for(int i=0;i<gen.size();i++) {
		nextGen[i]=evolve(getNeighborhood(i,gen));
	}
	return new Generation(nextGen);
}
}
