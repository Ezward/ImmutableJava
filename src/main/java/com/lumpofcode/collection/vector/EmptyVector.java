package com.lumpofcode.collection.vector;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Created by emurphy on 6/16/17.
 */
class EmptyVector<T> implements Vector<T>
{
	@Override
	public int size()
	{
		return 0;
	}
	
	@Override
	public boolean isEmpty()
	{
		return true;
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
	
	public Vector<T> pushAll(Vector<T> values)
	{
		Vector<T> result = this;
		for(T value : values)
		{
			result = result.push(value);
		}
		return result;
	}
	
	public <R> Vector<R> map(Function<? super T, ? extends R> mapper)
	{
		return Vectors.empty;
	}
	
	public <R> Vector<R> flatmap(Function<T, Vector<R>> mapper)
	{
		return Vectors.empty;
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
