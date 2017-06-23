package com.lumpofcode.collection.vector;

import com.lumpofcode.annotation.NotNull;

import java.util.function.Function;

/**
 * Created by emurphy on 6/16/17.
 */
public interface Vector<T> extends Iterable<T>
{
	/**
	 * The number of elements in the Vector.
	 * This is calculated efficiently.
	 *
	 * @return The number of elements in the Vector
	 */
	int size();
	
	/**
	 * Determine if the Vector is empty.
	 *
	 * @return true if the vector is empty, false if not.
	 */
	boolean isEmpty();
	
	/**
	 * Get the element at the given index
	 *
	 * @param index zero based index of element 0..size-1
	 * @return the element
	 * @throws IndexOutOfBoundsException if index lt 0 or index gte size
	 */
	T get(final int index);
	
	/**
	 * Set the value at the given index.
	 * Setting the value at index == size will
	 * increase the size of the Vector by one
	 * (it is equivalent to a push()).
	 *
	 * @param index zero based index 0..size
	 * @param value the value to set
	 * @return a new Vector with the element set
	 * @throws IndexOutOfBoundsException if index lt 0 or index gt size
	 */
	Vector<T> set(final int index, final T value);
	
	/**
	 * Append a value to the end of the Vector.
	 *
	 * @param value the value to append
	 * @return a new Vector with the value appended
	 */
	Vector<T> push(final T value);
	
	/**
	 * Efficiently append 16 elements to the end of the Vector.
	 * When building a large vector, this is the most
	 * efficient way to build up the vector, provided that
	 * elements are always added in chunks of 16.
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param e4
	 * @param e5
	 * @param e6
	 * @param e7
	 * @param e8
	 * @param e9
	 * @param e10
	 * @param e11
	 * @param e12
	 * @param e13
	 * @param e14
	 * @param e15
	 * @param e16
	 * @return a new Vector with 16 addition elements
	 */
	public Vector<T> push(final T e1, final T e2, final T e3, final T e4,
	                      final T e5, final T e6, final T e7, final T e8,
	                      final T e9, final T e10, final T e11, final T e12,
	                      final T e13, final T e14, final T e15, final T e16);
	
	/**
	 * Append all elements in the given vector
	 * to this vector, in order.
	 *
	 * @param vector with elements to append
	 * @return
	 */
	Vector<T> pushAll(@NotNull final Vector<T> vector);
	
	/**
	 * Map the values in the vector using the mapper function
	 * and return a new vector of mapped elements.
	 *
	 * @param <R> the resulting element type
	 * @param mapper function that maps a T to an R
	 * @return Vector of elements of type R
	 */
	<R> Vector<R> map(@NotNull Function<? super T, ? extends R> mapper);
	
	/**
	 * Map each element of type T of this vector to
	 * a Vector of type R, to produce a vector of vectors of type R,
	 * then flatten (append) that into a vector of type R.
	 *
	 * @param <R> the resulting element type
	 * @param mapper function that maps a value of type T
	 *               to a Vector with elements of type R
	 * @return Vector of elements of type R
	 */
	<R> Vector<R> flatmap(@NotNull Function<T, Vector<R>> mapper);
}
