
public class RuleNumException extends Exception{
	private static final long serialVersionUID = 1L;
	//exception is thrown when rule number is outside range
	public RuleNumException(int min, int max) {
		super("ruleNum is outside the range ["+min+", "+max+"].");
	}
}
