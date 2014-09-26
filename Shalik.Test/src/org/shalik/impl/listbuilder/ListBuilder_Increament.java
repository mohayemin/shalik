package org.shalik.impl.listbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.shalik.impl.ListBuilderImpl;
import org.shalik.test.testdoubles.AllTypes;

public class ListBuilder_Increament {

	private ListBuilderImpl<AllTypes> builder;
	private AllTypes object5;
	@Before
	public void setupForEach() {
		builder = new ListBuilderImpl<>(AllTypes.class);
		object5 = builder.build(10).get(5);
	}
	
	@Test
	public void build_short5_5() {
		assertEquals(5, object5.getShortInteger());
	}
	
	@Test
	public void build_int5_5() {
		assertEquals(5, object5.getInterger());
	}
	
	@Test
	public void build_long5_5() {
		assertEquals(5L, object5.getLongInteger());
	}
	
	@Test
	public void build_float5_5() {
		assertEquals(5.f, object5.getSingleFloat(), 1e-10);
	}
	
	@Test
	public void build_double5_5() {
		assertEquals(5., object5.getDoubleFloat(), 1e-10);
	}
		
	@Test
	public void build_string5_string5() {
		assertEquals("string5", object5.getString());
	}
}