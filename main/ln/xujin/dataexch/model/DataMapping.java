package ln.xujin.dataexch.model;

public class DataMapping {

	private String targetXpath;
	
	private String sourceXpath;
	
	public DataMapping(String targetXpath, String sourceXpath) {
		this.targetXpath = targetXpath;
		this.sourceXpath = sourceXpath;
	}

	public String getTargetXpath() {
		return targetXpath;
	}

	public void setTargetXpath(String targetXpath) {
		this.targetXpath = targetXpath;
	}

	public String getSourceXpath() {
		return sourceXpath;
	}

	public void setSourceXpath(String sourceXpath) {
		this.sourceXpath = sourceXpath;
	}
	
}