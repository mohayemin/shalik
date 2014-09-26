package org.shalik.reflection;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shalik.test.testdoubles.AllTypes;

public class ClassInfoTest {

	ClassInfo<AllTypes> allTypesInfo;
	@Before
	public void beforeEach(){
		allTypesInfo = new ClassInfo<AllTypes>(AllTypes.class);
	}
	
	@Test
	public void test() {
		List<MethodInfo> setters = allTypesInfo.getSetters();
		
		Assert.assertEquals(8, setters.size());
	}

}
