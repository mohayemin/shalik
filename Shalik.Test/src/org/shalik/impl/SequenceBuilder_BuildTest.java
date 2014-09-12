package org.shalik.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.shalik.test.testdoubles.Person;

@Category(SequenceBuilderImpl.class)
public class SequenceBuilder_BuildTest {
	SequenceBuilderImpl<Person> sb = new SequenceBuilderImpl<>();
	List<Person> people;

	@Before
	public void beforeEach() {
		sb = new SequenceBuilderImpl<>();
		sb.beginWith(() -> new Person("person0", 30));
		sb.progressAs((first, prev, index) -> new Person("person", prev
			.getAge() + 1));
		people = sb.build(10);
	}

	@Test
	public void build_sizeIsNonZero() {
		assertEquals("When 10 people are requested, 10 people should be built",
			10, people.size());
	}
	
	@Test
	public void build_sizeIsZero(){
		int size = sb.build(0).size();
		assertEquals("When 0 people are requested, 0 people should be built",
			0, size);
		
		SequenceBuilderImpl<String> sb2 = new SequenceBuilderImpl<>();
		size = sb2.beginWith(() -> "").build(0).size();
		assertEquals("When 0 people are requested, 0 people should be built, even if begin and progress are not set",
			0, size);
	}

	@Test
	public void build_beginingObject() {
		Person begin = people.get(0);
		assertEquals("The begining person should have age 30",
			30, begin.getAge());
	}

	@Test
	public void build_lastObject() {
		Person begin = people.get(9);
		assertEquals("The 9th person should have age 39",
			39, begin.getAge());
	}

	@Test(expected = Exception.class)
	public void build_beginWithNotSet() {
		SequenceBuilderImpl<String> sb2 = new SequenceBuilderImpl<>();
		sb2.progressAs((first, prev, index) -> "");

		sb2.build(10);
	}

	@Test(expected = Exception.class)
	public void build_progressAsNotSet() {
		SequenceBuilderImpl<String> sb2 = new SequenceBuilderImpl<>();
		sb2.beginWith(() -> "");

		sb2.build(10);
	}
}
