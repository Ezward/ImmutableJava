package com.lumpofcode.collection.compare;

import java.util.Comparator;

/**
 * Created by emurphy on 6/29/17.
 */
public class ReverseComparableComparator<T extends Comparable> implements Comparator<T>
{
	@Override
	public int compare(final T theValue, final T theOtherValue)
	{
		// reverse arguments to invert the result
		return theOtherValue.compareTo(theValue);
	}
	
}
