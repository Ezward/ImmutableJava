package com.lumpofcode.collection.vector;

import java.util.Iterator;
import java.util.function.Function;

/**
 * An empty vector.
 * This is an internal data structure.
 * Don't construct this directly, use the Vectors.empty singleton.
 *
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
	
	public Vector<T> push(final T e1, final T e2, final T e3, final T e4,
	                      final T e5, final T e6, final T e7, final T e8,
	                      final T e9, final T e10, final T e11, final T e12,
	                      final T e13, final T e14, final T e15, final T e16)
	{
		return Vectors.asVector(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
	}
	
	public Vector<T> pushAll(Iterable<T> values)
	{
		return Vectors.pushAll(this, values);
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
