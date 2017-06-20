package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/17/17.
 */
public abstract class AbstractVector<T> implements Vector<T>, Iterable<T>
{
	abstract public int size();
	abstract public T get(int index);
	abstract public Vector<T> set(int index, T value);
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
