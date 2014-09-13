package org.shalik.sequencebuilder.impl;

import java.util.ArrayList;
import java.util.List;

import org.shalik.ObjectBuilder;
import org.shalik.sequencebuilder.NextBuilder;
import org.shalik.sequencebuilder.SequenceBuilder;

public class SequenceBuilderImpl<T> implements SequenceBuilder<T> {

	private ObjectBuilder<T> beginingBuilder;
	private NextBuilder<T> nextBuilder;

	public SequenceBuilderImpl() {
	}
	
	@Override
	public List<T> build(int size) {
		List<T> items = new ArrayList<>();
		if (size == 0) {
			return items;
		}
		T first = beginingBuilder.build();
		items.add(first);
		
		T current = first;
		for (int i = 1; i < size; i++) {
			current = buildNext(items, first, current, i);
		}
		
		return items;
	}

	private T buildNext(List<T> items, T first, T current, int i) {
		T next = nextBuilder.buildNext(first, current, i);
		items.add(next);
		return next;
	}

	@Override
	public SequenceBuilderImpl<T> beginWith(ObjectBuilder<T> beginingBuilder) {
		this.beginingBuilder = beginingBuilder;
		return this;
	}

	@Override
	public SequenceBuilderImpl<T> proceedAs(NextBuilder<T> nextBuilder) {
		this.nextBuilder = nextBuilder;
		return this;
	}
}
