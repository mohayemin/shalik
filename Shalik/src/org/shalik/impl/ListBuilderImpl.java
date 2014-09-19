package org.shalik.impl;

import java.util.ArrayList;
import java.util.List;

import org.shalik.ListBuilder;
import org.shalik.reflection.ClassInfo;

public class ListBuilderImpl<T> implements ListBuilder<T>{
	private ClassInfo<T> classInfo;
	public ListBuilderImpl(Class<T> type) {
		this.classInfo = new ClassInfo<>(type);
	}
	
	@Override
	public List<T> build(int size) {
		List<T> objects = new ArrayList<>(size);
		
		for (int i = 0; i < size; i++) {
			try {
				T instance = classInfo.type.newInstance();
				objects.add(instance);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return objects;
	}
}
