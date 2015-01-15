package ln.xujin.dataexch.io;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ln.xujin.dataexch.context.Config;
import ln.xujin.dataexch.model.DataNode;
import ln.xujin.dataexch.model.DownOrder;
import ln.xujin.dataexch.model.Order;

import org.apache.log4j.Logger;

public class ClassParser {
	
	private static final Logger logger = Logger.getLogger(ClassParser.class);
	
	private static final String EXCLUDE_PACKAGE_PREFIX = "java.";
	
	private static final String LIST_TYPE_PREFIX = "java.util.List<";
	
	private static final ClassLoader classLoader = ClassParser.class.getClassLoader();
	
	public static DataNode parse(Class<?> clazz) throws ClassNotFoundException {
		DataNode root = new DataNode();
		root.setName(clazz.getName());
		root.setDesc(clazz.getSimpleName());
		root.setType(clazz.getTypeName());
		
		doParse(clazz, root, 1);
		
		return root;
	}
	
	private static void doParse(Class<?> clazz, DataNode node, int layer) throws ClassNotFoundException {
		if (layer > Config.DATA_MAX_LAYER) {
			return;
		}
		
		List<Field> list = getFields(clazz);
		if (list.size() > 0) {
			final Map<String, DataNode> children = new LinkedHashMap<String, DataNode>();
			node.setChildren(children);
			
			for (Field f : list) {
				logger.debug(f.getName() + "  " + f.getGenericType().getTypeName());
				
				DataNode child = new DataNode();
				child.setName(f.getName());
				child.setDesc(f.getName());
				child.setType(f.getGenericType().getTypeName());
				child.setParent(node);
				children.put(child.getName(), child);
				
				if (!child.getType().startsWith(EXCLUDE_PACKAGE_PREFIX)) {
					doParse(classLoader.loadClass(child.getType()), child, layer + 1);
					
				} else if (child.getType().startsWith(LIST_TYPE_PREFIX)) {
					String childType = child.getType().substring(LIST_TYPE_PREFIX.length(), child.getType().length() - 1);
					
					if (!childType.startsWith(EXCLUDE_PACKAGE_PREFIX)) {
						doParse(classLoader.loadClass(childType), child, layer + 1);
					}
				}
			}
		}
	}
	
	public static List<Field> getFields(Class<?> clazz) {
		List<Field> list = new ArrayList<Field>();
		doGetFields(clazz, list);
		
		return list;
	}
	
	private static void doGetFields(Class<?> clazz, List<Field> list) {
		if (clazz.getTypeName().startsWith(EXCLUDE_PACKAGE_PREFIX)) {
			return;
		}
		
		Class<?> superClazz = clazz.getSuperclass();
		if (!Object.class.equals(superClazz)) {
			doGetFields(superClazz, list);
		}
		
		Field[] fields = clazz.getDeclaredFields();
		if (fields.length > 0) {
			list.addAll(Arrays.asList(fields));
		}
	}
	
	public static void echo(DataNode node) {
		echo(node, 0);
	}
	
	private static void echo(DataNode node, int shift) {
		StringBuilder buf = new StringBuilder();
		for (int i = 1; i < shift; i++ ) {
			buf.append("-");
		}
		
		logger.info(buf + node.getName());
		
		if (node.getChildren() != null) {
			Collection<DataNode> children = node.getChildren().values();
			for (DataNode child : children) {
				echo(child, shift + 6);
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		DataNode orderRoot = ClassParser.parse(Order.class);
		echo(orderRoot);
		
		DataNode downOrderRoot = ClassParser.parse(DownOrder.class);
		echo(downOrderRoot);
	}
}
