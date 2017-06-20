package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorOf3<T> implements Vector<T>, Iterable<T>
{
	private final T element01;
	private final T element02;
	private final T element03;
	
	public VectorOf3(T element01, T element02, T element03)
	{
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
	}
	
	@Override
	public int size()
	{
		return 3;
	}
	
	@Override
	public T get(int index)
	{
		switch(index)
		{
			case 0: return element01;
			case 1: return element02;
			case 2: return element03;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf3(value, this.element02, this.element03);
			case 1: return new VectorOf3(this.element01, value, this.element03);
			case 2: return new VectorOf3(this.element01, this.element02, value);
			case 3: return push(value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return new VectorOf4(this.element01, this.element02, this.element03, value);
	}
	
	@Override
	public String toString()
	{
		return "[" + element01.toString() + ", " + element02.toString() + ", " + element03.toString() + "]";
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
