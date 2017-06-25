package com.lumpofcode.range;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by emurphy on 6/25/17.
 */
public class IntegerRangeTest
{
	@Test
	public void testRange()
	{
		int start = 0;
		int count = 10;
		final IntegerRange range = new IntegerRange(start, count);
		int i = start;
		for(Integer j : range)
		{
			assertTrue(i == j);
			i += 1;
		}
		assertTrue(i == count);
	}
	
	@Test
	public void testSkipRange()
	{
		int start = 0;
		int count = 10;
		int skip = 3;
		final IntegerRange range = new IntegerRange(start, count, skip);
		int i = start;
		for(Integer j : range)
		{
			assertTrue(i == j);
			i += skip;
		}
		assertTrue(i == start + count * skip);
	}
	
	@Test
	public void testNegativeSkipRange()
	{
		int start = 0;
		int count = 10;
		int skip = -3;
		final IntegerRange range = new IntegerRange(start, count, skip);
		int i = start;
		for(Integer j : range)
		{
			assertTrue(i == j);
			i += skip;
		}
		assertTrue(i == start + count * skip);
	}

}
