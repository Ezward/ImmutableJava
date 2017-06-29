package com.lumpofcode.collection.compare;


/**
 * Reversed (descending) null safe comparator for Comparables
 * Null is treated as least value (and so sorts first in reversed order)
 *
 * Created by emurphy on 6/29/17.
 */
public class ReverseNullSafeComparator<T extends Comparable> extends NullSafeComparator<T>
{
	@Override
	public int compare(T theValue, T theOtherValue)
	{
		// reverse the arguments to invert the result
		return super.compare(theOtherValue, theValue);
	}
}
