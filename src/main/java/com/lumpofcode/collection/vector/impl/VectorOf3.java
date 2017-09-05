package com.lumpofcode.collection.vector.impl;

import com.lumpofcode.collection.vector.Vector;
import com.lumpofcode.collection.vector.Vectors;
import com.lumpofcode.collection.vector.VectorIterator;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

public final class VectorOf3<T> implements Vector<T>, Iterable<T>
{
	private final T element0;
	private final T element1;
	private final T element2;

	public VectorOf3(final T element0, final T element1, final T element2)
	{
		this.element0 = element0;
		this.element1 = element1;
		this.element2 = element2;
	}

	public boolean isEmpty() { return false; }

	public int size() { return 3; }

	public T get(final int index)
	{
		switch(index)
		{
			case 0: return element0;
			case 1: return element1;
			case 2: return element2;
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> set(final int index, final T value)
	{
		switch(index)
		{
			case 0: return new VectorOf3<>(value, element1, element2);
			case 1: return new VectorOf3<>(element0, value, element2);
			case 2: return new VectorOf3<>(element0, element1, value);
			case 3: return append(value);
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> append(final T value)
	{
		return new VectorOf4<>(element0, element1, element2, value);
	}

	public Vector<T> append(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return new VectorTrie<T>(1, new VectorOf16(element0, element1, element2, e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12), new VectorOf3(e13, e14, e15));
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
		return new VectorOf3<>(mapper.apply(element0), mapper.apply(element1), mapper.apply(element2));
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

