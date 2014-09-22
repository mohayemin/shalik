package org.shalik.reflection;

import java.util.HashMap;
import java.util.Map;

public class DefaultValueProvider {
	private static Map<Class<?>, Object> defaultValues = defaultValues();

	public <T> T getValueFor(Class<T> type) {
		@SuppressWarnings("unchecked")
		T defaultValue = (T) defaultValues.get(type);

		return defaultValue;
	}

	private static HashMap<Class<?>, Object> defaultValues() {
		HashMap<Class<?>, Object> defaultValues =
			new HashMap<Class<?>, Object>();

		defaultValues.put(Boolean.class, new Boolean(false));
		defaultValues.put(Byte.class, new Byte((byte) 0));
		defaultValues.put(Character.class, new Character('A'));
		defaultValues.put(Double.class, new Double(0.0));
		defaultValues.put(Long.class, new Long(0L));
		defaultValues.put(Float.class, new Float(0.0F));
		defaultValues.put(Short.class, new Short((short) 0));
		defaultValues.put(Integer.class, new Integer(0));

		return defaultValues;
	}
}