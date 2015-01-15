package ln.xujin.dataexch.transfer;

import ln.xujin.dataexch.io.ClassParser;
import ln.xujin.dataexch.model.DataNode;
import ln.xujin.dataexch.model.DownOrder;
import ln.xujin.dataexch.model.Order;

public class DataTransfer<Source, Target> {
	
	private static final ClassLoader classLoader = DataTransfer.class.getClassLoader();
	
	private DataNode sourceNode;
	
	private DataNode targetNode;

	public DataTransfer(Class<Source> source, Class<Target> target) {
		try {
			sourceNode = ClassParser.parse(source);
			targetNode = ClassParser.parse(target);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Target execute(Source source) {
		try {
			if (targetNode != null) {
				Class<?> targetClazz = classLoader.loadClass(targetNode.getType());
				Object target = targetClazz.newInstance();
				
				return (Target) target;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		DataTransfer<Order, DownOrder> transfer = new DataTransfer<Order, DownOrder>(Order.class, DownOrder.class);
		
		Order order = new Order();
		DownOrder downOrder = transfer.execute(order);
		System.out.println(downOrder);
	}
}
