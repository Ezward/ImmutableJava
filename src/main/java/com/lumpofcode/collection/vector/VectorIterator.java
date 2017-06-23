package com.lumpofcode.collection.vector;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for the elements of the given vector.
 *
 * Created by emurphy on 6/17/17.
 */
public class VectorIterator<T> implements Iterator<T>
{
	private int i = 0;
	private final Vector<T> vector;
	
	public VectorIterator(final Vector<T> vector)
	{
		this.vector = vector;
	}
	
	@Override
	public boolean hasNext()
	{
		return i < vector.size();
	}
	
	@Override
	public T next()
	{
		if(!hasNext()) throw new NoSuchElementException();
		return vector.get(i++);
	}
}
