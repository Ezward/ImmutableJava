package com.lumpofcode.collection.tuple;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumpofcode.date.DateOfBirth;

import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by emurphy on 6/25/17.
 */
public class TupleTest
{
	@Test
	public void jsonTuple2Test() throws IOException
	{
		final Tuple2<Integer, DateOfBirth> tuple = new Tuple2<>(1, new DateOfBirth(2000, 12, 25));
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String json = objectMapper.writeValueAsString(tuple);
		System.out.println(json);
		
		//
		// NOTE: to deserialize a generic type, like TupleN, a TypeReference must be provided to the mapper
		//
		final Tuple2<Integer, DateOfBirth> clone = objectMapper.readValue(json, new TypeReference<Tuple2<Integer, DateOfBirth>>(){});
		
		assertFalse("These are distinct instances.", tuple == clone);
		assertEquals("These are equivalent instances.", tuple, clone);
	}
	
	@Test
	public void jsonTuple3Test() throws IOException
	{
		final Tuple3<Integer, String, DateOfBirth> tuple = new Tuple3<>(1, "foobar", new DateOfBirth(2000, 12, 25));
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String json = objectMapper.writeValueAsString(tuple);
		System.out.println(json);
		
		//
		// NOTE: to deserialize a generic type, like TupleN, a TypeReference must be provided to the mapper
		//
		final Tuple3<Integer, String, DateOfBirth> cloneTuple = objectMapper.readValue(json, new TypeReference<Tuple3<Integer, String, DateOfBirth>>(){});
		
		assertFalse("These are distinct instances.", tuple == cloneTuple);
		assertEquals("These are equivalent instances.", tuple, cloneTuple);
	}
}
