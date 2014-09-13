package org.shalik.sequencebuilder;

public interface NextBuilder<T> {
	public T buildNext(T begining, T previous, int indexOfNext);
}
