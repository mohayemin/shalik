package org.shalik.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.shalik.ListBuilder;
import org.shalik.reflection.ClassInfo;
import org.shalik.reflection.MethodInfo;

public class ListBuilderImpl<T> implements ListBuilder<T> {
	private ClassInfo<T> classInfo;
	private Map<Class<?>, Function<Integer, ?>> defaultIncrementProviders;

	public ListBuilderImpl(Class<T> type) {
		this.classInfo = new ClassInfo<>(type);
		defaultIncrementProviders = new HashMap<>();

		for (Class<?> cls : new Class<?>[] { short.class, int.class,
				long.class, float.class, double.class }) {
			defaultIncrementProviders
				.put(cls, (index) -> index);
		}
	}

	@Override
	public List<T> build(int size) {
		List<T> objects = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			try {
				T instance = classInfo.type.newInstance();
				for (MethodInfo setter : classInfo.getSetters()) {
					Class<?> firstParamType = setter.getFirstParameterType();

					if (defaultIncrementProviders.containsKey(firstParamType)) {
						Object val =
							defaultIncrementProviders.get(firstParamType)
								.apply(i);
						setter.method.invoke(instance, val);
					} else {
						System.out.println("sorry");
					}
				}
				objects.add(instance);
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			}
		}
		return objects;
	}
}
