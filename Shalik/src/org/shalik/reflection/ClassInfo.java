package org.shalik.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassInfo<T> {
	public final Class<T> type;
	private List<MethodInfo> setters;
	
	public ClassInfo(Class<T> type) {
		this.type = type;
	}
	
	public Iterable<MethodInfo> getSetters() {		
		if (setters == null) {
			generateSetters();
		}
		
		return setters;
	}

	private void generateSetters() {
		setters = new ArrayList<MethodInfo>();

		for (Method method : type.getMethods()) {
			MethodInfo methodInfo = new MethodInfo(method);
			if (methodInfo.isSetter()) {
				setters.add(methodInfo);
			}
		}
	}
}
