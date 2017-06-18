package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorOf4<T> implements Vector<T>
{
	private final T element01;
	private final T element02;
	private final T element03;
	private final T element04;
	
	public VectorOf4(T element01, T element02, T element03, T element04)
	{
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element04 = element04;
	}
	
	@Override
	public int size()
	{
		return 4;
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
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf4(value, element02, element03, element04);
			case 1: return new VectorOf4(element01, value, element03, element04);
			case 2: return new VectorOf4(element01, element02, value, element04);
			case 3: return new VectorOf4(element01, element02, element03, value);
			case 4: return new VectorOf5(element01, element02, element03, element04, value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public String toString()
	{
		return "["
			+ element01.toString() + ", "
			+ element02.toString() + ", "
			+ element03.toString() + ", "
			+ element04.toString() + "]";
	}
}
