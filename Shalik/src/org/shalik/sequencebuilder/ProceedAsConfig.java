package org.shalik.sequencebuilder;

import org.shalik.ListBuilder;

public interface ProceedAsConfig<T> {
	public ListBuilder<T> proceedAs(NextBuilder<T> nextBuilder);
}
