package com.lumpofcode.collection.vector;

import com.lumpofcode.annotation.NotNullable;
import com.lumpofcode.math.IntegerMath;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Created by emurphy on 6/23/17.
 */
public final class VectorOverlay<T> implements Vector<T>
{
	private final Vector<T> vector;
	private final int fromIndex;
	private final Vector<T> overlay;
	private final int size;
	
	
	public VectorOverlay(final Vector<T> vector, final int fromIndex, final Vector<T> overlay)
	{
		if(null == vector) throw new IllegalArgumentException();
		if(null == overlay) throw new IllegalArgumentException();
		
		if(fromIndex > vector.size()) throw new IndexOutOfBoundsException();    // past end of vector
		if(fromIndex < -overlay.size()) throw new IndexOutOfBoundsException();  // in front of start of vector
		
		if(fromIndex >= 0)
		{
			this.vector = vector;
			this.overlay = overlay;
			this.fromIndex = fromIndex;
		}
		else
		{
			// overlay inserted in front of vector, flip to make underlying vector always start with zero index
			this.vector = overlay;
			this.overlay = vector;
			this.fromIndex = -fromIndex;
		}
		
		// calculate size based on right most element
		this.size = IntegerMath.max(this.vector.size(), fromIndex + this.overlay.size());
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
		if ((index >= this.fromIndex) && (index < (this.fromIndex + overlay.size())))
		{
			// falls withing the overlay, so get from the overlay
			return this.overlay.get(index - fromIndex);
		}
		// falls within the underlying vector, so get from the underlying vector
		return this.vector.get(index);
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		
		if ((index >= this.fromIndex) && (index <= (this.fromIndex + overlay.size())))
		{
			// falls withing the overlay, so set within the overlay
			return new VectorOverlay<T>(this.vector, this.fromIndex, this.overlay.set(index - fromIndex, value));
		}
		
		// falls within the underlying vector, so set within the underlying vector
		return new VectorOverlay<T>(this.vector.set(index, value), this.fromIndex, this.overlay);
	}
	
	@Override
	public Vector<T> push(T value)
	{
		if(this.size() > (this.fromIndex + this.overlay.size()))
		{
			// underlying vector is rightmost; grow the underlying vector
			return new VectorOverlay<T>(this.vector.push(value), this.fromIndex, this.overlay);
		}
		
		// overlay is the right most, so grow it
		return new VectorOverlay<T>(this.vector, this.fromIndex, this.overlay.push(value));
	}
	
	@Override
	public Vector<T> push(T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16)
	{
		if(this.size() > (this.fromIndex + this.overlay.size()))
		{
			// underlying vector is rightmost; grow the underlying vector
			return new VectorOverlay<T>(
				this.vector.push(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16),
				this.fromIndex,
				this.overlay);
		}
		
		// overlay is the right most, so grow it
		return new VectorOverlay<T>(
			this.vector,
			this.fromIndex,
			this.overlay.push(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16));
	}
	
	@Override
	public Vector<T> pushAll(@NotNullable Iterable<T> iterable)
	{
		if(this.size() > (this.fromIndex + this.overlay.size()))
		{
			// underlying vector is rightmost; grow the underlying vector
			return new VectorOverlay<T>(this.vector.pushAll(iterable), this.fromIndex, this.overlay);
		}
		
		// overlay is the right most, so grow it
		return new VectorOverlay<T>(this.vector, this.fromIndex, this.overlay.pushAll(iterable));
	}
	
	@Override
	public <R> Vector<R> map(@NotNullable Function<? super T, ? extends R> mapper)
	{
		return Vectors.map(this, mapper);
	}
	
	@Override
	public <R> Vector<R> flatmap(@NotNullable Function<T, Vector<R>> mapper)
	{
		return Vectors.flatmap(this, mapper);
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
}
