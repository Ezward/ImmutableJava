package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorOf6<T> implements Vector<T>, Iterable<T>
{
	private final T element01;
	private final T element02;
	private final T element03;
	private final T element04;
	private final T element05;
	private final T element06;
	
	public VectorOf6(T element01, T element02, T element03, T element04, T element05, T element06)
	{
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element04 = element04;
		this.element05 = element05;
		this.element06 = element06;
	}
	
	@Override
	public int size()
	{
		return 6;
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
			case 5: return element06;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf6(value, element02, element03, element04, element05, element06);
			case 1: return new VectorOf6(element01, value, element03, element04, element05, element06);
			case 2: return new VectorOf6(element01, element02, value, element04, element05, element06);
			case 3: return new VectorOf6(element01, element02, element03, value, element05, element06);
			case 4: return new VectorOf6(element01, element02, element03, element04, value, element06);
			case 5: return new VectorOf6(element01, element02, element03, element04, element05, value);
			case 6: return push(value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return new VectorOf7(element01, element02, element03, element04, element05, element06, value);
	}
	
	@Override
	public String toString()
	{
		return "["
			+ element01.toString() + ", "
			+ element02.toString() + ", "
			+ element03.toString() + ", "
			+ element04.toString() + ", "
			+ element05.toString() + ", "
			+ element06.toString() + "]";
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
