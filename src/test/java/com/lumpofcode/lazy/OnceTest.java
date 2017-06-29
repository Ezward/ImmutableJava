package com.lumpofcode.lazy;

import com.lumpofcode.lazy.Once;

import java.util.NoSuchElementException;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by emurphy on 6/12/17.
 */
public class OnceTest
{
	@Test
	public void onceTest()
	{
		final Once<String> once = new Once();
		
		assertFalse(once.isSet());
		
		try
		{
			// attempt to get once before it is set throws
			String s = once.get();
			fail("Once.get() should throw if once is not set.");
		}
		catch (NoSuchElementException e)
		{
			assertTrue(true);   // success
		}
		catch (Exception e)
		{
			fail("Unexpected exception.");
		}
		
		assertTrue("Setter returns value", "foo".equals(once.set("foo")));
		assertTrue(once.isSet());
		assertTrue("foo".equals(once.get()));
		
		assertTrue("Setting a different value is ignored.", "foo".equals(once.set("bar")));
		assertTrue("foo".equals(once.get()));
		
	}
	
	@Test
	public void testOnceSetNull()
	{
		final Once<String> once = new Once();
		
		once.set(null);
		
		assertTrue(null == once.get());
	}
}
