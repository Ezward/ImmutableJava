package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorOf11<T> implements Vector<T>
{
	private final T element01;
	private final T element02;
	private final T element03;
	private final T element04;
	private final T element05;
	private final T element06;
	private final T element07;
	private final T element08;
	private final T element09;
	private final T element10;
	private final T element11;
	
	public VectorOf11(T element01, T element02, T element03, T element04, T element05, T element06, T element07, T element08,
	                  T element09, T element10, T element11)
	{
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element04 = element04;
		this.element05 = element05;
		this.element06 = element06;
		this.element07 = element07;
		this.element08 = element08;
		this.element09 = element09;
		this.element10 = element10;
		this.element11 = element11;
	}
	
	@Override
	public int size()
	{
		return 11;
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
			case 7: return element08;
			case 8: return element09;
			case 9: return element10;
			case 10: return element11;
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf11(value, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11);
			case 1: return new VectorOf11(element01, value, element03, element04, element05, element06, element07, element08, element09, element10, element11);
			case 2: return new VectorOf11(element01, element02, value, element04, element05, element06, element07, element08, element09, element10, element11);
			case 3: return new VectorOf11(element01, element02, element03, value, element05, element06, element07, element08, element09, element10, element11);
			case 4: return new VectorOf11(element01, element02, element03, element04, value, element06, element07, element08, element09, element10, element11);
			case 5: return new VectorOf11(element01, element02, element03, element04, element05, value, element07, element08, element09, element10, element11);
			case 6: return new VectorOf11(element01, element02, element03, element04, element05, element06, value, element08, element09, element10, element11);
			case 7: return new VectorOf11(element01, element02, element03, element04, element05, element06, element07, value, element09, element10, element11);
			case 8: return new VectorOf11(element01, element02, element03, element04, element05, element06, element07, element08, value, element10, element11);
			case 9: return new VectorOf11(element01, element02, element03, element04, element05, element06, element07, element08, element09, value, element11);
			case 10: return new VectorOf11(element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, value);
			case 11: return new VectorOf12(element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, value);
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
			+ element07.toString() + ", "
			+ element08.toString() + ", "
			+ element09.toString() + ", "
			+ element10.toString() + ", "
			+ element11.toString() + "]";
	}
}
