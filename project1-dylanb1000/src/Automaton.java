import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Automaton class encapsulates a Rule and an Array list of generations to represent an elementary cellular automata.Class also provides methods to modify the elementary cellular automata.
 * 
 * 
 * @author Dylan Bui
 *
 */
public class Automaton {
private Rule rule;
private ArrayList<Generation> generations=new ArrayList<Generation>();
public char falseSymbol='0';
public char trueSymbol='1';
/**
 * Explicit constructor, Creates an automaton with the rule number and initial generation given
 * 
 * @param ruleNum	Integer used to represent the rule number that will used in the class(range 1-256)
 * @param initial 	Generation that will represent the first row in the ECA
 */
public Automaton(int ruleNum, Generation initial) {
	this.rule=new Rule(ruleNum);
	this.generations.add(initial);
	
}
/**
 * Constructor, creates an automaton from a text file that is formatted as follows{rule number,falseSymbol,trueSymbol,generationString}
 * 
 * @param filename	String used to locate file that will be parsed to obtain data for the Automaton class construction
 * 
 * @throws IOException if stream to file cannot be read or closed.
 */
public Automaton(String filename) throws IOException{
	BufferedReader br=new BufferedReader(new FileReader(filename));
	String content="";
	content=br.readLine();
	this.rule=new Rule(Integer.parseInt(content));
	content=br.readLine();
	falseSymbol=content.charAt(0);
	trueSymbol=content.charAt(2);
	System.out.println(trueSymbol);
	System.out.println(falseSymbol);
	content=br.readLine();
	this.generations.add(new Generation(content,trueSymbol));
	
}
/**
 * Accessor method for the rule field
 * @return rule number of the class as an Integer
 */
public int getRuleNum() {
	return this.rule.getRuleNum();
}
/**
 * Method used to apply the rule stored on the generation array for a given amount of steps
 * @param numSteps Integer used to evolve the generation array by a number of steps
 */
public void evolve(int numSteps) {
	if(numSteps<=0) {
		return;
	}
	else {
		for(int i=0;i<numSteps;i++) {
			Generation nextGen=rule.evolve(generations.get(generations.size()-1));
			generations.add(nextGen);
		}
	}
}
/**
 * Accessor method for the generations field
 * @param numSteps Integer used to retrieve the generation equal to the integer in the generation array
 * @return the generation at the step number indicated
 */
public Generation getGeneration(int stepNum) {
	if(getTotalSteps()<stepNum) {
		evolve(stepNum-getTotalSteps());
		return generations.get(stepNum);
	}
	else {
		return generations.get(stepNum);
	}
}
/**
 * Method used to retrieve the number if steps generations has gone through
 * @return Integer equal to the amount of steps the generations have evolved
 */
public int getTotalSteps(){
	return generations.size() -1;
}
/**
 * Method used to convert the generation array into a readable string
 * @return String representation of the generation array
 */
public String toString() {
	String ECA="";
	for(int i=0;i<generations.size()-1;i++) {
		ECA=ECA+generations.get(i).getStates(falseSymbol,trueSymbol);
		ECA=ECA+System.lineSeparator();
	}
	ECA=ECA+generations.get(generations.size()-1).getStates(falseSymbol,trueSymbol);
	return ECA;
}
/**
 * Method used to save the string representation of the generation array to a specified file name
 * 
 * @param filename	String used to name the file in which the string representation of the generation array will be saved
 * 
 * @throws IOException if stream to file cannot be written to or closed.
 */
public void saveEvolution(String filename) throws IOException {
	BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
	bw.write(this.toString());
	bw.close();
}
}

