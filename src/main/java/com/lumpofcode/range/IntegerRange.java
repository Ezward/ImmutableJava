package com.lumpofcode.range;

import com.lumpofcode.annotation.Immutable;

import java.util.Iterator;

/**
 * Created by emurphy on 6/25/17.
 */
@Immutable
public final class IntegerRange implements Iterable<Integer>
{
	private final int start;
	private final int count;
	private final int skip;
	
	/**
	 * Iterable that produces 'count' integers starting at 'start'
	 *
	 * Usage example:
	 *   for(Integer i : new IntegerRange(1, 10))
	 *   {
	 *       System.out.println(i);
	 *   }
	 * will print out the integers 1,2,3,4,5,6,7,8,9,10
	 *
	 * @param start first integer to produce (provided count != 0)
	 * @param count number of integers to produce
	 * @throws IllegalArgumentException if count < 0
	 */
	public IntegerRange(final int start, final int count)
	{
		this(start, count, 1);
	}
	
	/**
	 * Iterable that produces 'count' integers starting at 'start'
	 *
	 * Usage example:
	 *   for(Integer i : new IntegerRange(1, 10, 3))
	 *   {
	 *       System.out.println(i);
	 *   }
	 * will print out the integers 1,4,7,10,13,16,19,22,25,28
	 *
	 * @param start first integer to produce (provided count != 0)
	 * @param count number of integers to produce
	 * @param skip the value to add to the previous integer on each iteration.
	 *             this may be negative to go backwards.
	 * @throws IllegalArgumentException if count < 0
	 */
	public IntegerRange(final int start, final int count, final int skip)
	{
		if(count < 0) throw new IllegalArgumentException();
		//
		// TODO : check for potential overflow and throw
		//
		
		this.skip = skip;
		this.start = start;
		this.count = count;
	}
	
	/**
	 * Iterator for the range
	 *
	 * @return an Iterator for the range
	 */
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>()
		{
			private int i = 0;
			private int skipped = 0;
			
			@Override
			public boolean hasNext()
			{
				return i < count;
			}
			
			@Override
			public Integer next()
			{
				final int value = start + skipped;
				i += 1;
				skipped += skip;
				return value;
			}
		};
	}
}
