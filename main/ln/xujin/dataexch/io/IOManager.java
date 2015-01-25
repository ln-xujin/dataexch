package ln.xujin.dataexch.io;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ln.xujin.dataexch.model.DataNode;

public class IOManager {

	private static final Map<String, DataNode> metaMap = new ConcurrentHashMap<String, DataNode>();
	
	public static final boolean register(Class<?> clazz) {
		String clazzName = clazz.getName();
		
		if (metaMap.get(clazzName) != null) {
			return true;
		}
		
		try {
			DataNode node = ClassParser.parse(clazz);
			metaMap.put(clazzName, node);
			
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}