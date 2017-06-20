package com.lumpofcode.collection.vector;

import java.util.Iterator;

/**
 * Created by emurphy on 6/16/17.
 */
class EmptyVector<T> implements Vector<T>, Iterable<T>
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
		if(0 == index) return push(value);
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return Vectors.asVector(value);
	}
	
	@Override
	public String toString()
	{
		return "[]";
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
