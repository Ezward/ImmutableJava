package com.lumpofcode.date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumpofcode.date.DateOfBirth;

import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by emurphy on 6/12/17.
 */
public class DateOfBirthTest
{
	@Test
	public void dateOfBirthTest()
	{
		final DateOfBirth dateOfBirth = new DateOfBirth(2000, 12, 25);
		assertTrue(2000 == dateOfBirth.getYear());
		assertTrue(12 == dateOfBirth.getMonth());
		assertTrue(25 == dateOfBirth.getDay());
		
		
		try
		{
			// zero month should throw
			new DateOfBirth(200, 0, 25);
			fail("Should have thrown an exception");
		}
		catch (IllegalStateException e)
		{
			assertTrue(true);   // success
		}
		catch(Exception e)
		{
			fail("Unexpected exception.");
		}
		
		try
		{
			// month out of range should throw
			new DateOfBirth(200, 13, 25);
			fail("Should have thrown an exception");
		}
		catch (IllegalStateException e)
		{
			assertTrue(true);   // success
		}
		catch(Exception e)
		{
			fail("Unexpected exception.");
		}
		
		try
		{
			// zero day should throw
			new DateOfBirth(200, 12, 0);
			fail("Should have thrown an exception");
		}
		catch (IllegalStateException e)
		{
			assertTrue(true);   // success
		}
		catch(Exception e)
		{
			fail("Unexpected exception.");
		}
		
		try
		{
			// out of range day should throw
			new DateOfBirth(200, 12, 32);
			fail("Should have thrown an exception");
		}
		catch (IllegalStateException e)
		{
			assertTrue(true);   // success
		}
		catch(Exception e)
		{
			fail("Unexpected exception.");
		}
		
	}
	
	@Test
	public void toStringTest()
	{
		final DateOfBirth dateOfBirth = new DateOfBirth(2000, 12, 25);
		
		System.out.println(dateOfBirth.toString());
		
		assertEquals("{\"year\":2000,\"month\":12,\"day\":25}", dateOfBirth.toString());
	}
	
	@Test
	public void jsonTest() throws IOException
	{
		final DateOfBirth dateOfBirth = new DateOfBirth(2000, 12, 25);
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String json = objectMapper.writeValueAsString(dateOfBirth);
		System.out.println(json);
		
		final DateOfBirth cloneDate = objectMapper.readValue(json, DateOfBirth.class);
		
	}
}
