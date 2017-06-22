package com.lumpofcode.collection.vector;

import java.util.function.Function;

/**
 * Created by emurphy on 6/16/17.
 */
public interface Vector<T> extends Iterable<T>
{
	int size();
	boolean isEmpty();
	T get(final int index);
	Vector<T> set(final int index, final T value);
	Vector<T> push(final T value);
	Vector<T> pushAll(final Vector<T> value);
	
	/**
	 * Map the values in the vector using the mapper function
	 * and return a new vector of mapped elements.
	 *
	 * @param mapper function that maps a T to an R
	 * @param <R> the result type
	 * @return Vector of elements mapped from T to R
	 */
	<R> Vector<R> map(Function<? super T, ? extends R> mapper);
	
	<R> Vector<R> flatmap(Function<T, Vector<R>> mapper);
	
}
