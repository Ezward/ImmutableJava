package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorOf7<T> implements Vector<T>
{
	private final T element01;
	private final T element02;
	private final T element03;
	private final T element04;
	private final T element05;
	private final T element06;
	private final T element07;
	
	public VectorOf7(T element01, T element02, T element03, T element04, T element05, T element06, T element07)
	{
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element04 = element04;
		this.element05 = element05;
		this.element06 = element06;
		this.element07 = element07;
	}
	
	@Override
	public int size()
	{
		return 7;
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
			case 6: return element07;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf7(value, element02, element03, element04, element05, element06, element07);
			case 1: return new VectorOf7(element01, value, element03, element04, element05, element06, element07);
			case 2: return new VectorOf7(element01, element02, value, element04, element05, element06, element07);
			case 3: return new VectorOf7(element01, element02, element03, value, element05, element06, element07);
			case 4: return new VectorOf7(element01, element02, element03, element04, value, element06, element07);
			case 5: return new VectorOf7(element01, element02, element03, element04, element05, value, element07);
			case 6: return new VectorOf7(element01, element02, element03, element04, element05, element06, value);
			case 7: return new VectorOf8(element01, element02, element03, element04, element05, element06, element07, value);
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
			+ element04.toString() + ", "
			+ element05.toString() + ", "
			+ element06.toString() + ", "
			+ element07.toString() + "]";
	}
}
