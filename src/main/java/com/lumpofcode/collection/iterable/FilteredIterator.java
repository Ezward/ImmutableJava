package com.lumpofcode.collection.iterable;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * An adapter that turns an Iterator into a filtered iterator
 * such that only elements that match the predicate are returned.
 *
 * Created by emurphy on 9/1/17.
 */
public class FilteredIterator<T> implements Iterator<T>
{
	private final Iterator<T> it;
	private final Predicate<T> predicate;
	private boolean haveNext = false;
	private T next;
	
	public FilteredIterator(@NotNull final Iterator<T> iterator, @NotNull final Predicate<T> predicate)
	{
		if(null == iterator) throw new IllegalArgumentException();
		if(null == predicate) throw new IllegalArgumentException();
		
		this.it = iterator;
		this.predicate = predicate;
	}
	
	@Override
	public boolean hasNext()
	{
		if(!haveNext)
		{
			while(it.hasNext())
			{
				if(predicate.test(next = it.next()))
				{
					return haveNext = true;
				}
			}
		}
		return haveNext;
	}
	
	@Override
	public T next()
	{
		if(this.hasNext())
		{
			haveNext = false;
			return next;
		}
		
		throw new NoSuchElementException();
	}
}
