package org.shalik.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.shalik.test.testdoubles.Person;

@Category(SequenceBuilderImpl.class)
public class SequenceBuilder_BeginWithTest {
	SequenceBuilderImpl<Person> sb;
	
	@Before
	public void beforeEach(){
		sb = new SequenceBuilderImpl<>();
		sb.beginWith(() -> new Person("person0", 30));
	}
	
	@Test
	public void beginWith_basic() {
		Person person0 = sb.build(1).get(0);
		assertEquals("When begining with age 30, person[0] should have age 30",
			30, person0.getAge());
	}
}
