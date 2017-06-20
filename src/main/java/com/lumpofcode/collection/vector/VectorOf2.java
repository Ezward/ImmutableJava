package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/16/17.
 */
public final class VectorOf2<T> implements Vector<T>, Iterable<T>
{
	private final T element01;
	private final T element02;
	
	public VectorOf2(T element01, T element02)
	{
		this.element01 = element01;
		this.element02 = element02;
	}
	
	@Override
	public int size()
	{
		return 2;
	}
	
	@Override
	public T get(int index)
	{
		switch(index)
		{
			case 0: return element01;
			case 1: return element02;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf2(value, this.element02);
			case 1: return new VectorOf2(this.element01, value);
			case 2: return push(value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return new VectorOf3(this.element01, this.element02, value);
	}

	@Override
	public String toString()
	{
		return "[" + element01.toString() + ", " + element02.toString() + "]";
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
