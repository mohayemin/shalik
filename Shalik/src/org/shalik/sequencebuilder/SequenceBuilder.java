package org.shalik.sequencebuilder;

import org.shalik.ListBuilder;

public interface SequenceBuilder<T> extends BeginWithConfig<T>,
	ProceedAsConfig<T>, ListBuilder<T> {
}
