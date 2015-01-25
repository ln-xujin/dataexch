package ln.xujin.dataexch.model;

import java.io.Serializable;
import java.util.Map;

import ln.xujin.dataexch.context.Config;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class DataNode implements Serializable {
	
	private Long id;

	private String name;
	
	private String desc;
	
	private String type;
	
	private String xpath;
	
	private DataNode parent;
	
	private Map<String, DataNode> children;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isLeaf() {
		return children == null || children.size() == 0 ? true : false;
	}
	
	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public DataNode getParent() {
		return parent;
	}

	public void setParent(DataNode parent) {
		this.parent = parent;
	}

	public Map<String, DataNode> getChildren() {
		return children;
	}

	public void setChildren(Map<String, DataNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, Config.TO_STRING_STYLE);
	}
	
}