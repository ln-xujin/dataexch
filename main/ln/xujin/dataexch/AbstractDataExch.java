package ln.xujin.dataexch;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import ln.xujin.dataexch.model.DataMapping;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.jxpath.JXPathContext;

public abstract class AbstractDataExch<T, S> {
	
	private static final ClassLoader classLoader = AbstractDataExch.class.getClassLoader();
	
	private static final PropertyUtilsBean propertyUtils = BeanUtilsBean.getInstance().getPropertyUtils();
	
	private Class<T> targetClazz;
	
	private Class<S> sourceClazz;
	
	private List<DataMapping> mappings;
	
	@SuppressWarnings("unchecked")
	public AbstractDataExch() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Type[] typeArgs = type.getActualTypeArguments();
		targetClazz = (Class<T>) typeArgs[0];
		sourceClazz = (Class<S>) typeArgs[1];
	}
	
	@SuppressWarnings("unchecked")
	public T make(S source) {
		if (mappings == null) {
			return null;
		}
		
		try {
			Object target = targetClazz.newInstance();
			JXPathContext ctxSource = JXPathContext.newContext(source);
			JXPathContext ctxTarget = JXPathContext.newContext(target);

			mappings.parallelStream().forEach(mapping -> {
				ctxTarget.setValue(mapping.getTargetXpath(), ctxSource.getValue(mapping.getSourceXpath()));
			});
			
			return (T) target;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<DataMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<DataMapping> mappings) {
		this.mappings = mappings;
	}
	
}