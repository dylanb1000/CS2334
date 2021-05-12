import java.io.IOException;

public class TotalisticAutomaton extends Automaton{
	public TotalisticAutomaton(int ruleNum,Generation initial) throws RuleNumException {
		super(ruleNum,initial);
	}
	public TotalisticAutomaton(String filename) throws NumberFormatException, IOException, RuleNumException {
		super(filename);
	}
	protected Rule createRule(int ruleNum) throws RuleNumException {
		Rule rule=new TotalisticRule(ruleNum);
		return rule;
	}
}
