package ln.xujin.dataexch.rule;

import java.util.List;

public class RuleEngine {

	public static <T> Session<T> newSession(List<Rule<T>> rules) {
		if (rules != null && rules.size() > 0) {
			return new Session<T>(rules);
		}
		
		return null;
	}
	
}