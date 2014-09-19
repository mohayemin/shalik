package org.shalik.impl;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.shalik.test.testdoubles.AllTypes;

public class ListBuilder_BuildTest {

	private ListBuilderImpl<AllTypes> builder;
	private List<AllTypes> objects;

	@Before
	public void setupForEach() {
		builder = new ListBuilderImpl<>(AllTypes.class);
		objects = builder.build(10);
	}

	@Test
	public void build_10_sizeIsTen() {
		assertEquals(10, objects.size());
	}

	@Test
	public void build_firstShortIs0() {
		assertEquals(0, objects.get(0).getShortInteger());
	}
	
	@Test
	public void build_firstIntIs0() {
		assertEquals(0, objects.get(0).getInterger());
	}
	
	@Test
	public void build_firstLongIs0() {
		assertEquals(0, objects.get(0).getLongInteger());
	}
	
	@Test
	public void build_firstFloatIs0f() {
		assertEquals(0.f, objects.get(0).getSingleFloat(), 1e-10);
	}
	
	@Test
	public void build_firstDoubleIs0() {
		assertEquals(0., objects.get(0).getDoubleFloat(), 1e-10);
	}
	
	@Test
	public void build_firstDateIs0() {
		assertEquals(new Date(0L), objects.get(0).getDate());
	}
	
	@Test
	public void build_firstCharIsUpperCaseA() {
		assertEquals('A', objects.get(0).getCharacter());
	}
	
	@Test
	public void build_firstBoolIsFalse() {
		assertEquals(false, objects.get(0).isBool());
	}
	
	@Test
	public void build_firstStringIs_string0() {
		assertEquals("string0", objects.get(0).getString());
	}
}
