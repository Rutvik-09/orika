/*
 * Orika - simpler, better and faster Java bean mapping
 *
 * Copyright (C) 2011-2013 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ma.glasnost.orika.test.community;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

public class Issue18TestCase {

	
	@SuppressWarnings("deprecation")
	@Test
	public void testMappingEmptyArray() {
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.registerClassMap(ClassMapBuilder.map(Object.class,Object.class).byDefault().toClassMap());
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = mapperFactory.getMapperFacade().mapAsList(listA, Object.class);
		
		Assert.assertNotNull(listB);
        Assert.assertThat(listB, is(empty()));
	}
	
}
