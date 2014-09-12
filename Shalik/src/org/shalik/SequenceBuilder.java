package org.shalik;

import java.util.List;

import org.shalik.impl.NextBuilder;

public interface SequenceBuilder<T> {
	public List<T> build(int size);
	public SequenceBuilder<T> beginWith(ObjectBuilder<T> firstBuilder);
	public SequenceBuilder<T> progressAs(NextBuilder<T> nextBuilder);
}
