package org.shalik.impl.listbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.shalik.impl.ListBuilderImpl;
import org.shalik.test.testdoubles.AllTypes;

public class ListBuilder_DefaultValue {

	private ListBuilderImpl<AllTypes> builder;
	private AllTypes object0;
	@Before
	public void setupForEach() {
		builder = new ListBuilderImpl<>(AllTypes.class);
		object0 = builder.build(10).get(0);
	}

	@Test
	public void build_10_sizeIsTen() {
		assertEquals(10, builder.build(10).size());
	}

	@Test
	public void build_firstShortIs0() {
		assertEquals(0, object0.getShortInteger());
	}
	
	@Test
	public void build_firstIntIs0() {
		assertEquals(0, object0.getInterger());
	}
	
	@Test
	public void build_firstLongIs0() {
		assertEquals(0, object0.getLongInteger());
	}
	
	@Test
	public void build_firstFloatIs0f() {
		assertEquals(0.f, object0.getSingleFloat(), 1e-10);
	}
	
	@Test
	public void build_firstDoubleIs0() {
		assertEquals(0., object0.getDoubleFloat(), 1e-10);
	}
	
	@Test
	public void build_firstCharIsUpperCaseA() {
		assertEquals('A', object0.getCharacter());
	}
	
	@Test
	public void build_firstBoolIsFalse() {
		assertEquals(false, object0.isBool());
	}
	
	@Test
	public void build_firstStringIs_string0() {
		assertEquals("string0", object0.getString());
	}
}
