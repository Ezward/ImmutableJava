package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/16/17.
 */
public interface Vector<T>
{
	int size();
	T get(final int index);
	Vector<T> set(final int index, final T value);
}
