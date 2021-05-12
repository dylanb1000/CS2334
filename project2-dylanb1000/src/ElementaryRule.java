
public class ElementaryRule extends Rule{
	
	public ElementaryRule(int ruleNum) throws RuleNumException {
		super(ruleNum);
		if(ruleNum>255 || ruleNum<0) {
			throw new RuleNumException(0,255);
		}
		
	}
	//checks specified cell and neighboring cells that are contained in a boolean array. checks preset table contained in parent class to find what the next generation should be.
	public boolean evolve(boolean[] neighborhood) {
		for(int i=0;i<9;i++) {
			if(neighborhood[0]==super.table[i][0] && neighborhood[1]==super.table[i][1] && neighborhood[2]==table[i][2]) {
				if(super.binaryRule.charAt(i)=='1') {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean[] getNeighborhood(int idx,Generation gen) {
		boolean[] neighborhood= {gen.getState((idx+gen.size()-1)%gen.size()),gen.getState(idx%gen.size()),gen.getState((idx+1)%gen.size())};
		return neighborhood;
	}
	//creates string representation of elementary rule table using preset rule table in parent class as well as defined rule when class is created.
	public String getRuleTable(char falseSymbol, char trueSymbol) {
		String finalString = "";
		for(int i=0;i<super.table.length;i++) {
			for(int j=0;j<super.table[i].length;j++) {
				if(super.table[i][j]==false) {
					finalString=finalString+falseSymbol;
				}
				else {
					finalString=finalString+trueSymbol;
				}
			}
			finalString=finalString+" ";
		}
		finalString=finalString+System.lineSeparator();
		for(int i=0;i<super.binaryRule.length();i++) {
			String toAdd="";
			if(super.binaryRule.charAt(i)=='1') {
				toAdd=String.format(" %s  ",trueSymbol);
				finalString=finalString+toAdd;
			}
			else {
				toAdd=String.format(" %s  ",falseSymbol);
				finalString=finalString+toAdd;
			}
		}
		String newS=finalString.substring(0, 31)+System.lineSeparator()+" "+finalString.substring(34,64);
		System.out.println(newS);
		return newS;
	}
}
