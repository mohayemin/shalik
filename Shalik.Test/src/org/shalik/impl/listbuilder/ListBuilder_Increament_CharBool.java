package org.shalik.impl.listbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.shalik.impl.ListBuilderImpl;
import org.shalik.test.testdoubles.AllTypes;

public class ListBuilder_Increament_CharBool {

	private ListBuilderImpl<AllTypes> builder;
	private List<AllTypes> objects;

	@Before
	public void setupForEach() {
		builder = new ListBuilderImpl<>(AllTypes.class);
		objects = builder.build(70);
	}

	@Test
	public void build_char5_uppercaseF() {
		assertEquals('F', objects.get(5));
	}

	@Test
	public void build_char26_lowercaseA() {
		assertEquals('a', objects.get(26));
	}

	@Test
	public void build_char52_lowercaseA() {
		assertEquals('A', objects.get(52));
	}

	@Test
	public void build_bool5_true() {
		assertTrue(objects.get(5).isBool());
	}

	@Test
	public void build_bool6_false() {
		assertFalse(objects.get(6).isBool());
	}
}
