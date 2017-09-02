package com.lumpofcode.collection.vector.impl;

import com.lumpofcode.collection.vector.Vector;
import com.lumpofcode.collection.vector.Vectors;
import com.lumpofcode.collection.vector.VectorIterator;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

/**
 * An empty vector.
 * This is an internal data structure.
 * Don't construct this directly, use the Vector.empty singleton.
 *
 * Created by emurphy on 6/16/17.
 */
public final class EmptyVector<T> implements Vector<T>
{
	public int size()
	{
		return 0;
	}

	public boolean isEmpty()
	{
		return true;
	}

	public T get(final int index)
	{
		throw new IndexOutOfBoundsException();
	}

	public Vector<T> set(final int index, final T value)
	{
		if(0 == index) return push(value);
		throw new IndexOutOfBoundsException();
	}

	public Vector<T> push(final T value)
	{
		return Vector.of(value);
	}

	public Vector<T> push(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return Vector.of(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
	}

	public Vector<T> pushAll(@NotNull final Iterable<T> values)
	{
		return Vectors.pushAll(this, values);
	}

	public Vector<T> pushAll(@NotNull final Iterator<T> values)
	{
		return Vectors.pushAll(this, values);
	}

	public Vector<T> filter(@NotNull final Predicate<T> predicate)
	{
		return Vector.empty;
	}

	public <R> Vector<R> map(@NotNull final Function<? super T, ? extends R> mapper)
	{
		return Vector.empty;
	}

	public <R> Vector<R> flatmap(@NotNull final Function<T, Vector<R>> mapper)
	{
		return Vector.empty;
	}

	public String toString()
	{
		return "[]";
	}

	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}

}

