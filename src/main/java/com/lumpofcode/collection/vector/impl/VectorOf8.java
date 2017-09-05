package com.lumpofcode.collection.vector.impl;

import com.lumpofcode.collection.vector.Vector;
import com.lumpofcode.collection.vector.Vectors;
import com.lumpofcode.collection.vector.VectorIterator;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

public final class VectorOf8<T> implements Vector<T>, Iterable<T>
{
	private final T element0;
	private final T element1;
	private final T element2;
	private final T element3;
	private final T element4;
	private final T element5;
	private final T element6;
	private final T element7;

	public VectorOf8(final T element0, final T element1, final T element2, final T element3, final T element4, final T element5, final T element6, final T element7)
	{
		this.element0 = element0;
		this.element1 = element1;
		this.element2 = element2;
		this.element3 = element3;
		this.element4 = element4;
		this.element5 = element5;
		this.element6 = element6;
		this.element7 = element7;
	}

	public boolean isEmpty() { return false; }

	public int size() { return 8; }

	public T get(final int index)
	{
		switch(index)
		{
			case 0: return element0;
			case 1: return element1;
			case 2: return element2;
			case 3: return element3;
			case 4: return element4;
			case 5: return element5;
			case 6: return element6;
			case 7: return element7;
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> set(final int index, final T value)
	{
		switch(index)
		{
			case 0: return new VectorOf8<>(value, element1, element2, element3, element4, element5, element6, element7);
			case 1: return new VectorOf8<>(element0, value, element2, element3, element4, element5, element6, element7);
			case 2: return new VectorOf8<>(element0, element1, value, element3, element4, element5, element6, element7);
			case 3: return new VectorOf8<>(element0, element1, element2, value, element4, element5, element6, element7);
			case 4: return new VectorOf8<>(element0, element1, element2, element3, value, element5, element6, element7);
			case 5: return new VectorOf8<>(element0, element1, element2, element3, element4, value, element6, element7);
			case 6: return new VectorOf8<>(element0, element1, element2, element3, element4, element5, value, element7);
			case 7: return new VectorOf8<>(element0, element1, element2, element3, element4, element5, element6, value);
			case 8: return append(value);
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> append(final T value)
	{
		return new VectorOf9<>(element0, element1, element2, element3, element4, element5, element6, element7, value);
	}

	public Vector<T> append(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return new VectorTrie<T>(1, new VectorOf16(element0, element1, element2, element3, element4, element5, element6, element7, e0, e1, e2, e3, e4, e5, e6, e7), new VectorOf8(e8, e9, e10, e11, e12, e13, e14, e15));
	}

	public Vector<T> appendAll(@NotNull final Iterable<T> iterable)
	{
		return Vectors.appendAll(this, iterable);
	}

	public Vector<T> appendAll(@NotNull final Iterator<T> it)
	{
		return Vectors.appendAll(this, it);
	}

	public Vector<T> filter(@NotNull final Predicate<T> predicate)
	{
		return Vectors.filter(this, predicate);
	}

	public <R> Vector<R> map(@NotNull final Function<? super T, ? extends R> mapper)
	{
		return new VectorOf8<>(mapper.apply(element0), mapper.apply(element1), mapper.apply(element2), mapper.apply(element3), mapper.apply(element4), mapper.apply(element5), mapper.apply(element6), mapper.apply(element7));
	}

	public <R> Vector<R> flatmap(@NotNull final Function<T, Vector<R>> mapper)
	{
		return Vectors.flatmap(this, mapper);
	}

	public String toString()
	{
		return Vectors.toString(this);
	}

	public Iterator<T> iterator() { return new VectorIterator<T>(this); }
}

