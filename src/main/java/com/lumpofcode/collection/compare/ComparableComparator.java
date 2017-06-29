package com.lumpofcode.collection.compare;

import java.util.Comparator;

/**
 * Comparator adapter for Comparable
 *
 * Created by emurphy on 6/28/17.
 */
public final class ComparableComparator<T extends Comparable> implements Comparator<T>
{
	@Override
	public int compare(final T theValue, final T theOtherValue)
	{
		return theValue.compareTo(theOtherValue);
	}
}
