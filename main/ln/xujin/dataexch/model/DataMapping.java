package ln.xujin.dataexch.model;

import java.util.Map;

public class DataMapping {

	private DataNode target;
	
	private DataNode source;
	
	/**
	 * xpath Map<to, from>
	 */
	private Map<String, String> path;

	public DataNode getTarget() {
		return target;
	}

	public void setTarget(DataNode target) {
		this.target = target;
	}

	public DataNode getSource() {
		return source;
	}

	public void setSource(DataNode source) {
		this.source = source;
	}

	public Map<String, String> getPath() {
		return path;
	}

	public void setPath(Map<String, String> path) {
		this.path = path;
	}

}