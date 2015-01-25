package ln.xujin.dataexch.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Session<T> {
	
	private List<RuleRunner<T>> runners;
	
	public Session(List<Rule<T>> rules) {
		List<Rule<T>> _rules = rules.stream()
				.sorted((r1, r2) -> r2.getPriority() - r1.getPriority())
				.collect(Collectors.toList());
		
		runners = new ArrayList<RuleRunner<T>>(_rules.size());
		
		try {
			for (Rule<T> rule : _rules) {
				RuleRunner<T> runner = (RuleRunner<T>) rule.getRunnerClazz().newInstance();
				runners.add(runner);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void fireRules(T data) {
		// deep clone
		T rawData = data;
		System.out.println(rawData.getClass());
		
		for (RuleRunner<T> runner : runners) {
			runner.transform(rawData, data);
		}
	}

}