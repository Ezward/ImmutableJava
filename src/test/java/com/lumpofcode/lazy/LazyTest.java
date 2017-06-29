package com.lumpofcode.lazy;

import java.util.function.Supplier;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by emurphy on 6/13/17.
 */
public class LazyTest
{
	public static class Holder<T>
	{
		private T value = null;
		
		public Holder(T value)
		{
			this.value = value;
		}
		
		public T get()
		{
			return value;
		}
		
		public void set(T value)
		{
			this.value = value;
		}
	}
	
	@Test
	public void lazyTest()
	{
		final Holder<Integer> count = new Holder(0);
		final Supplier<String> supplier = () -> { count.set(1 + count.get()); return "foo"; };
		final Lazy<String> lazy = new Lazy<>(supplier);
		
		assertTrue(0 == count.get());
		assertTrue("foo".equals(lazy.get()));
		assertTrue(1 == count.get());
		
		//
		// second call should not call the supplier again
		//
		assertTrue("foo".equals(lazy.get()));
		assertTrue(1 == count.get());
	}
}
