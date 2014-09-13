package org.shalik.sequencebuilder;

import org.shalik.ObjectBuilder;

public interface BeginWithConfig<T> {
	public ProceedAsConfig<T> beginWith(ObjectBuilder<T> beginWith);
}
