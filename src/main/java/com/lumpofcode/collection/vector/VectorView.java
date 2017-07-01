package com.lumpofcode.collection.vector;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;

/**
 * A subset range of an underlying Vector.
 *
 * Created by emurphy on 6/23/17.
 */
public final class VectorView<T> implements Vector<T>
{
	private final Vector<T> vector;
	private final int fromIndex;
	private final int size;
	
	public VectorView(@NotNull final Vector<T> vector, final int fromIndex, final int toIndex)
	{
		if(null == vector) throw new IllegalArgumentException();
		if((fromIndex < 0) || (fromIndex > vector.size())) throw new IndexOutOfBoundsException();
		if((toIndex < fromIndex) || (toIndex > vector.size())) throw new IndexOutOfBoundsException();
		
		this.fromIndex = fromIndex;
		this.size = toIndex - fromIndex;
		this.vector = vector;
	}
	
	@Override
	public int size()
	{
		return this.size;
	}
	
	@Override
	public boolean isEmpty()
	{
		return 0 == this.size;
	}
	
	@Override
	public T get(int index)
	{
		if((index < 0) || (index >= this.size)) throw new IndexOutOfBoundsException();

		return this.vector.get(fromIndex + index);
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		if((index < 0) || (index > this.size)) throw new IndexOutOfBoundsException();

		return new VectorOverlay(this, index, Vectors.asVector(value));
	}
	
	@Override
	public Vector<T> push(T value)
	{
		return new VectorOverlay(this, this.size, Vectors.asVector(value));
	}
	
	@Override
	public Vector<T> push(T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16)
	{
		//
		// create a vector from the values and append as an overlay
		//
		return new VectorOverlay(this, this.size, Vectors.asVector(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16));
	}
	
	@Override
	public Vector<T> pushAll(@NotNull Iterable<T> iterable)
	{
		if (iterable instanceof Vector)
		{
			//
			// the iterable is a vector, so we can use it directly
			//
			return new VectorOverlay(this, this.size, (Vector<T>)iterable);
		}
		
		//
		// create a vector from the iterable, then append it as an overlay
		//
		return new VectorOverlay(this, this.size, Vectors.empty.pushAll(iterable));
	}
	
	@Override
	public <R> Vector<R> map(@NotNull Function<? super T, ? extends R> mapper)
	{
		return Vectors.map(this, mapper);
	}
	
	@Override
	public <R> Vector<R> flatmap(@NotNull Function<T, Vector<R>> mapper)
	{
		return Vectors.flatmap(this, mapper);
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
