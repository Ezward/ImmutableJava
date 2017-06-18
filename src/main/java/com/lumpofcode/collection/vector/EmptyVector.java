package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/16/17.
 */
public class EmptyVector<T> implements Vector<T>
{
	@Override
	public int size()
	{
		return 0;
	}
	
	@Override
	public T get(int index)
	{
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		if(0 == index) return new VectorOf1(value);
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public String toString()
	{
		return "[]";
	}
	
}
