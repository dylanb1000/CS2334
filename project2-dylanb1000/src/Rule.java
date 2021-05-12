
public abstract class Rule {
	private int ruleNumber;
	protected String binaryRule;
	protected boolean[] table1= {true,true,true};
	protected boolean[] table2= {true,true,false};
	protected boolean[] table3= {true,false,true};
	protected boolean[] table4= {true,false,false};
	protected boolean[] table5= {false,true,true};
	protected boolean[] table6= {false,true,false};
	protected boolean[] table7= {false,false,true};
	protected boolean[] table8= {false,false,false};
	protected boolean[][] table= {table1,table2,table3,table4,table5,table6,table7,table8};
	protected Rule(int ruleNum){
			this.ruleNumber=ruleNum;
			this.binaryRule=Integer.toBinaryString(ruleNumber);
			while(binaryRule.length()<8) {
				binaryRule="0"+binaryRule;
			}
	}
	public Generation evolve(Generation gen) {
		boolean[] nextGen=new boolean[gen.size()];
		for(int i=0;i<gen.size();i++) {
			nextGen[i]=evolve(getNeighborhood(i,gen));
		}
		return new Generation(nextGen);
	}
	
	public abstract boolean evolve(boolean[] neighborhood);
	
	public abstract boolean[] getNeighborhood(int idx, Generation gen);
	
	public int getRuleNum() {
		return this.ruleNumber;
	}
	public abstract String getRuleTable(char falseSymbol, char trueSymbol);
}










