package com.lumpofcode;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;

import org.junit.Test;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by emurphy on 6/9/17.
 */
public class PersonTest
{
	@Test
	public void builderTest()
	{
		//
		// default values are used if setter is not called
		//
		final Person defaultPerson = (new PersonBuilder()).build();
		assertTrue(0 == defaultPerson.getId());
		assertTrue(null == defaultPerson.getFirstName());
		
		//
		// fluent interface
		//
		final Person newPerson = (new PersonBuilder())
			.id(100)
			.firstName("foo")
			.lastName("bar")
			.dateOfBirth(new DateOfBirth(1990, 12, 25))
			.build();
		assertTrue(100 == newPerson.getId());
		assertTrue("foo".equals(newPerson.getFirstName()));
		assertTrue("bar".equals(newPerson.getLastName()));
		assertTrue(1990 == newPerson.getDateOfBirth().getYear());
		assertTrue(12 == newPerson.getDateOfBirth().getMonth());
		assertTrue(25 == newPerson.getDateOfBirth().getDay());
		
		System.out.println(newPerson.getDateOfBirth().toString());
		
		//
		// you can reuse a builder, it will maintain it's values
		//
		final PersonBuilder builder = new PersonBuilder();
		final Person idPerson = builder.id(1).build();
		assertTrue(1 == idPerson.getId());
		assertTrue(null == idPerson.getFirstName());
		
		final Person namePerson = builder.firstName("foo").build();
		assertTrue(1 == namePerson.getId());
		assertTrue("foo".equals(namePerson.getFirstName()));
		
		final Person otherNamePerson = builder.build();
		
		assertTrue("Builder produces a new instance on each build()", otherNamePerson != namePerson);
		assertTrue("Builder can produce equivalent instances", otherNamePerson.equals(namePerson));
		
	}
	
	@Test
	public void toStringTest()
	{
		Person person = new Person(0, null, null, null);
		assertEquals("{\"id\":0,\"firstName\":null,\"lastName\":null,\"dateOfBirth\":null}", person.toString());
		
		person = new Person(1, "foo", "bar", new DateOfBirth(2000, 12, 25));
		System.out.println(person.toString());
		assertEquals("{\"id\":1,\"firstName\":\"foo\",\"lastName\":\"bar\",\"dateOfBirth\":{\"year\":2000,\"month\":12,\"day\":25}}", person.toString());
	}
	
	@Test
	public void toJsonTest() throws IOException
	{
		final Person person = new Person(1, "foo", "bar", new DateOfBirth(2000, 12, 25));
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String json = objectMapper.writeValueAsString(person);
		System.out.println(json);
		
		final Person clonePerson = objectMapper.readValue(json, Person.class);
		
		assertFalse("These are distinct instances.", person == clonePerson);
		assertEquals("These are equivalent instances.", person, clonePerson);
	}
}
