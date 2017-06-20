package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorOf5<T> implements Vector<T>, Iterable<T>
{
	private final T element01;
	private final T element02;
	private final T element03;
	private final T element04;
	private final T element05;
	
	public VectorOf5(T element01, T element02, T element03, T element04, T element05)
	{
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element04 = element04;
		this.element05 = element05;
	}
	
	@Override
	public int size()
	{
		return 5;
	}
	
	@Override
	public T get(int index)
	{
		switch(index)
		{
			case 0: return element01;
			case 1: return element02;
			case 2: return element03;
			case 3: return element04;
			case 4: return element05;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf5(value, element02, element03, element04, element05);
			case 1: return new VectorOf5(element01, value, element03, element04, element05);
			case 2: return new VectorOf5(element01, element02, value, element04, element05);
			case 3: return new VectorOf5(element01, element02, element03, value, element05);
			case 4: return new VectorOf5(element01, element02, element03, element04, value);
			case 5: return push(value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return new VectorOf6(element01, element02, element03, element04, element05, value);
	}
	
	@Override
	public String toString()
	{
		return "["
			+ element01.toString() + ", "
			+ element02.toString() + ", "
			+ element03.toString() + ", "
			+ element04.toString() + ", "
			+ element05.toString() + "]";
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
