package com.lumpofcode.collection.vector;

import java.util.Iterator;

public final class VectorOf3<T> implements Vector<T>, Iterable<T>
{
	private final T element0;
	private final T element1;
	private final T element2;
	
	public VectorOf3(T element0, T element1, T element2)
	{
		this.element0 = element0;
		this.element1 = element1;
		this.element2 = element2;
	}
	
	public int size() { return 3; }
	
	public T get(int index)
	{
		switch(index)
		{
			case 0: return element0;
			case 1: return element1;
			case 2: return element2;
		}
		
		throw new IndexOutOfBoundsException();
	}
	
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf3(value, element1, element2);
			case 1: return new VectorOf3(element0, value, element2);
			case 2: return new VectorOf3(element0, element1, value);
			case 3: return push(value);
		}
		
		throw new IndexOutOfBoundsException();
	}
	
	public Vector<T> push(T value)
	{
		return new VectorOf4(element0, element1, element2, value);
	}
	
	public String toString()
	{
		return "[" + element0.toString() + ", " + element1.toString() + ", " + element2.toString() + "]";
		
	}
	
	public Iterator<T> iterator() { return new VectorIterator<T>(this); }
}
