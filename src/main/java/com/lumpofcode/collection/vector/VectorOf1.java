package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/16/17.
 */
public final class VectorOf1<T> implements Vector<T>, Iterable<T>
{
	private final T element01;
	
	public VectorOf1(final T element01)
	{
		this.element01 = element01;
	}
	
	@Override
	public int size()
	{
		return 1;
	}
	
	@Override
	public T get(int index)
	{
		switch(index)
		{
			case 0: return element01;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf1(value);
			case 1: return push(value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return new VectorOf2(this.element01, value);
	}
	
	@Override
	public String toString()
	{
		return "[" + element01.toString() + "]";
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
	
}
