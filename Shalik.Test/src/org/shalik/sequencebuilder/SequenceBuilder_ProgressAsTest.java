package org.shalik.sequencebuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.shalik.sequencebuilder.impl.SequenceBuilderImpl;
import org.shalik.test.testdoubles.Person;

@Category(SequenceBuilderImpl.class)
public class SequenceBuilder_ProgressAsTest {
	SequenceBuilderImpl<Person> sb = new SequenceBuilderImpl<>();

	@Before
	public void beforeEach() {
		sb = new SequenceBuilderImpl<Person>()
			.beginWith(() -> new Person("person0", 30));
	}

	@Test
	public void progressAs_ruleBasedOnBeginingAndPreviousAndIndex() {
		sb.beginWith(() -> new Person("person0", 1))
			.proceedAs((first, prev, index) 
				-> new Person("person", first.getAge() + index * prev.getAge()));
		// 0->1, 1->2, 2->5, 3->16
		Person person3 = sb.build(10).get(3);
		assertEquals(
			"When beginin person has age 1 and other has (first+index*previous), "
				+ "ages follow the sequence 1,2,5,16... and person3 has age 16",
			16, person3.getAge());
	}

	@Test
	public void progressAs_ruleBasedOnPrevious() {
		sb.proceedAs((first, prev, index) -> new Person("person", prev
			.getAge() + 1));

		Person person3 = sb.build(10).get(3);
		assertEquals(
			"When beginin person has age 30 and others' age is 1 more than previous, person 3 should have age 33",
			33, person3.getAge());
	}

	@Test
	public void progressAs_ruleBasedOnBegining() {
		sb.proceedAs((first, prev, index) -> new Person("person", first
			.getAge() * 2));

		Person person3 = sb.build(10).get(3);
		assertEquals(
			"When beginin person has age 30 and other has double of that, person3 has age 60",
			60, person3.getAge());
	}

	@Test
	public void progressAs_ruleBasedOnIndex() {
		sb.proceedAs((first, prev, index) -> new Person("person" + index, 30));

		Person person3 = sb.build(10).get(3);
		assertEquals(
			"When begining person name is `person0` and name is in pattern `person{i}` person3 has name `person3`",
			"person3", person3.getName());
	}
}
