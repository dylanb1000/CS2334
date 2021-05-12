
public class TotalisticRule extends Rule{
	public TotalisticRule(int ruleNum) throws RuleNumException {
		super(ruleNum);
		if(ruleNum>63 || ruleNum<0) {
			throw new RuleNumException(0,63);
		}
	}
	//checks specified cell and two neighboring cells on each side that are contained in a boolean array.Evolves cell on the amount of true boolean values in the boolean array.
	public boolean evolve(boolean[] neighborhood) {
		int trueCount=0;
		for(int i=0;i<neighborhood.length;i++) {
			if(neighborhood[i]==true) {
				trueCount++;
			}
		}
		if(super.binaryRule.charAt(7-trueCount)=='1') {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean[] getNeighborhood(int idx,Generation gen)  {
		boolean[] neighborhood= {gen.getState((idx+gen.size()-2)%gen.size()),gen.getState((idx+gen.size()-1)%gen.size()),gen.getState(idx%gen.size()),gen.getState((idx+1)%gen.size()),gen.getState((idx+gen.size()+2)%gen.size())};
		return neighborhood;
	}
	//creates string representation of totalistic rule table using binary representation of the rule number.
	public String getRuleTable(char falseSymbol, char trueSymbol) {
		String finalString="5 4 3 2 1 0"+System.lineSeparator();
		for(int i=2;i<super.binaryRule.length();i++) {
			if(super.binaryRule.charAt(i)=='1') {
			finalString=finalString+trueSymbol+" ";
			}
			else {
			finalString=finalString+falseSymbol+" ";
			}
		}
		return finalString.substring(0,finalString.length()-1);
	}
}
