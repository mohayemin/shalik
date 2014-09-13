package org.shalik;

import java.util.List;

public interface ListBuilder<T> {
	public List<T> build(int size);
}
