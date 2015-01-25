package ln.xujin.dataexch.rule;

public interface RuleRunner<T> {

	public void transform(T rawData, T data);
	
}