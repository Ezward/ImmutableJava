package com.lumpofcode.collection.vector;

import com.lumpofcode.math.IntegerMath;

import java.util.Iterator;
import java.util.function.Function;

/**
 * A node in a vector trie hiearchy.
 * The children may be other trie or a vector with elements (at the leaf)
 *
 * This is meant to be a private implementation.  It should not
 * be constructed by applicaitions.  Instance, use Vectors.asVector().
 *
 * Created by emurphy on 6/17/17.
 */
final class VectorTrie<T> implements Vector<T>
{
	private static final int VECTOR_NODE_SIZE = 16;
	
	private final int level;        // zero if leaf node, 1 is first level trie, 2 is second level trie, etc.
	private final int childSize;    // capacity (maximum size) of a child node at this level
	
	private final int size;
	private final Vector<T> vector01;
	private final Vector<T> vector02;
	private final Vector<T> vector03;
	private final Vector<T> vector04;
	private final Vector<T> vector05;
	private final Vector<T> vector06;
	private final Vector<T> vector07;
	private final Vector<T> vector08;
	private final Vector<T> vector09;
	private final Vector<T> vector10;
	private final Vector<T> vector11;
	private final Vector<T> vector12;
	private final Vector<T> vector13;
	private final Vector<T> vector14;
	private final Vector<T> vector15;
	private final Vector<T> vector16;
	
	public VectorTrie(final int level, final Vector<T> vector01, final Vector<T> vector02)
	{
		this(level,
			vector01,
			vector02,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty,
			Vectors.empty);
	}
	
	
	public VectorTrie(final int level,
	                  final Vector<T> vector01,
	                  final Vector<T> vector02,
	                  final Vector<T> vector03,
	                  final Vector<T> vector04,
	                  final Vector<T> vector05,
	                  final Vector<T> vector06,
	                  final Vector<T> vector07,
	                  final Vector<T> vector08,
	                  final Vector<T> vector09,
	                  final Vector<T> vector10,
	                  final Vector<T> vector11,
	                  final Vector<T> vector12,
	                  final Vector<T> vector13,
	                  final Vector<T> vector14,
	                  final Vector<T> vector15,
	                  final Vector<T> vector16)
	{
		this.level = level;
		this.childSize = IntegerMath.power(VECTOR_NODE_SIZE, level);

		this.vector01 = vector01;
		this.vector02 = vector02;
		this.vector03 = vector03;
		this.vector04 = vector04;
		this.vector05 = vector05;
		this.vector06 = vector06;
		this.vector07 = vector07;
		this.vector08 = vector08;
		this.vector09 = vector09;
		this.vector10 = vector10;
		this.vector11 = vector11;
		this.vector12 = vector12;
		this.vector13 = vector13;
		this.vector14 = vector14;
		this.vector15 = vector15;
		this.vector16 = vector16;
		
		this.size =  vector01.size()
			+ vector02.size()
			+ vector03.size()
			+ vector04.size()
			+ vector05.size()
			+ vector06.size()
			+ vector07.size()
			+ vector08.size()
			+ vector09.size()
			+ vector10.size()
			+ vector11.size()
			+ vector12.size()
			+ vector13.size()
			+ vector14.size()
			+ vector15.size()
			+ vector16.size();
	}
	
	@Override
	public int size()
	{
		return this.size;
	}
	
	@Override
	public boolean isEmpty()
	{
		return false;
	}
	
	@Override
	public T get(int index)
	{
		if((index < 0) || (index >= size())) throw new IndexOutOfBoundsException();

		//
		// find the child within this trie (index / childSize)
		// then get that child's element (index % childSize)
		//
		return getChild(index / childSize).get(index % childSize);
	}
	
	/**
	 * Set a value at the given index
	 *
	 * @param index
	 * @param value
	 * @return
	 */
	@Override
	public Vector<T> set(int index, T value)
	{
		if((index < 0) || (index > size())) throw new IndexOutOfBoundsException();
		
		//
		// find the child within this trie (index / childSize)
		// if it is within this trie, set it's element (index % childIndex)
		// if it is not within this trie, then we need to add another level to the hierarchy
		//
		final int childIndex = index / childSize;
		if(childIndex < VECTOR_NODE_SIZE)
		{
			//
			// find the child within this trie (index / childSize)
			// then set that child's element (index % childSize)
			// and build a new vector using the updated child
			//
			return setChild(childIndex, getChild(childIndex).set(index % childSize, value));
		}
		
		//
		// we are beyond the capacity of this trie, so create a new level in the hierarachy
		//
		return new VectorTrie(level + 1,this, Vectors.asVector(value));
	}
	
	@Override
	public Vector<T> push(T value)
	{
		// add element after last current element
		return this.set(this.size(), value);
	}
	
	@Override
	public Vector<T> push(T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16)
	{
		final int childIndex = size / childSize; // index of vector containing last element
		final int childCount = size % childSize;  // size of vector containing last element
		final int childCapacity = childSize - childCount;   // remaining capacity of vector containing last element
		
		//
		// determine if we can just add this to the child, or if we need to split it between childred
		//
		if(childCapacity >= 16)
		{
			//
			// there is room for these element in the child,
			// push to the child, then rebuild the trie with the updated child
			//
			return setChild(childIndex, getChild(childIndex).push(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16));
		}
		else
		{
			//
			// there is no room in the child, which means these
			// new elements will need to be split between children.
			// Use a loop to push each element.  It is inefficient, but handles situation
			// where a new child or new level in the hierarchy is required
			//
			Vector<T> result = this.push(e1);
			result = result.push(e2);
			result = result.push(e3);
			result = result.push(e4);
			result = result.push(e5);
			result = result.push(e6);
			result = result.push(e7);
			result = result.push(e8);
			result = result.push(e9);
			result = result.push(e10);
			result = result.push(e11);
			result = result.push(e12);
			result = result.push(e13);
			result = result.push(e14);
			result = result.push(e15);
			result = result.push(e16);
			return result;
		}
	}
	
	
	@Override
	public Vector<T> pushAll(Vector<T> vector)
	{
		Vector<T> result = this;
		for(T element : vector)
		{
			result = result.push(element);
		}
		return result;
	}
	
	@Override
	public <R> Vector<R> map(Function<? super T, ? extends R> mapper)
	{
		return new VectorTrie<R>(
			level,
			vector01.map(mapper),
			vector02.map(mapper),
			vector03.map(mapper),
			vector04.map(mapper),
			vector05.map(mapper),
			vector06.map(mapper),
			vector07.map(mapper),
			vector08.map(mapper),
			vector09.map(mapper),
			vector10.map(mapper),
			vector11.map(mapper),
			vector12.map(mapper),
			vector13.map(mapper),
			vector14.map(mapper),
			vector15.map(mapper),
			vector16.map(mapper));
	}
	
	@Override
	public <R> Vector<R> flatmap(Function<T, Vector<R>> mapper)
	{
		Vector<R> result = vector01.flatmap(mapper);
		result = result.pushAll(vector02.flatmap(mapper));
		result = result.pushAll(vector03.flatmap(mapper));
		result = result.pushAll(vector04.flatmap(mapper));
		result = result.pushAll(vector05.flatmap(mapper));
		result = result.pushAll(vector06.flatmap(mapper));
		result = result.pushAll(vector07.flatmap(mapper));
		result = result.pushAll(vector08.flatmap(mapper));
		result = result.pushAll(vector09.flatmap(mapper));
		result = result.pushAll(vector10.flatmap(mapper));
		result = result.pushAll(vector11.flatmap(mapper));
		result = result.pushAll(vector12.flatmap(mapper));
		result = result.pushAll(vector13.flatmap(mapper));
		result = result.pushAll(vector14.flatmap(mapper));
		result = result.pushAll(vector15.flatmap(mapper));
		return result.pushAll(vector16.flatmap(mapper));
	}
	
	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();
		
		builder
			.append('[')
			.append(vector01.toString())
			.append(vector02.toString())
			.append(vector03.toString())
			.append(vector04.toString())
			.append(vector05.toString())
			.append(vector06.toString())
			.append(vector07.toString())
			.append(vector08.toString())
			.append(vector09.toString())
			.append(vector10.toString())
			.append(vector11.toString())
			.append(vector12.toString())
			.append(vector13.toString())
			.append(vector14.toString())
			.append(vector15.toString())
			.append(vector16.toString())
			.append(']');
		
		return builder.toString();
	}
	
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
	
	//
	// ---------------------- private helpers --------------------------
	//
	private Vector<T> getChild(final int childIndex)
	{
		if((childIndex < 0) || (childIndex >= VECTOR_NODE_SIZE)) throw new IndexOutOfBoundsException();
		switch(childIndex)
		{
			case 0: return vector01;
			case 1: return vector02;
			case 2: return vector03;
			case 3: return vector04;
			case 4: return vector05;
			case 5: return vector06;
			case 6: return vector07;
			case 7: return vector08;
			case 8: return vector09;
			case 9: return vector10;
			case 10: return vector11;
			case 11: return vector12;
			case 12: return vector13;
			case 13: return vector14;
			case 14: return vector15;
			default: return vector16;
		}
	}
	
	private Vector<T> setChild(final int childIndex, Vector<T> childValue)
	{
		if((childIndex < 0) || (childIndex >= VECTOR_NODE_SIZE)) throw new IndexOutOfBoundsException();
		switch(childIndex)
		{
			case 0: return new VectorTrie(level, childValue, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 1: return new VectorTrie(level, vector01, childValue, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 2: return new VectorTrie(level, vector01, vector02, childValue, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 3: return new VectorTrie(level, vector01, vector02, vector03, childValue, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 4: return new VectorTrie(level, vector01, vector02, vector03, vector04, childValue, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 5: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, childValue, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 6: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, childValue, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 7: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, childValue, vector09, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 8: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, childValue, vector10, vector11, vector12, vector13, vector14, vector15, vector16);
			case 9: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, childValue, vector11, vector12, vector13, vector14, vector15, vector16);
			case 10: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, childValue, vector12, vector13, vector14, vector15, vector16);
			case 11: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, childValue, vector13, vector14, vector15, vector16);
			case 12: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, childValue, vector14, vector15, vector16);
			case 13: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, childValue, vector15, vector16);
			case 14: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, childValue, vector16);
			default: return new VectorTrie(level, vector01, vector02, vector03, vector04, vector05, vector06, vector07, vector08, vector09, vector10, vector11, vector12, vector13, vector14, vector15, childValue);
		}
	}
	
	
}
