package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/16/17.
 */
public final class VectorOf1<T> implements Vector<T>
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
			case 1: return new VectorOf2(this.element01, value);
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public String toString()
	{
		return "[" + element01.toString() + "]";
	}
}
