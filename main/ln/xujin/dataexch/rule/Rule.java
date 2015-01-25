package ln.xujin.dataexch.rule;

public class Rule<T> {

	private String name;
	
	private Class<? extends RuleRunner<T>> runnerClazz;
	
	private int priority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<? extends RuleRunner<T>> getRunnerClazz() {
		return runnerClazz;
	}

	public void setRunnerClazz(Class<? extends RuleRunner<T>> runnerClazz) {
		this.runnerClazz = runnerClazz;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}