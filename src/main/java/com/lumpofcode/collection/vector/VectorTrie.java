package com.lumpofcode.collection.vector;

import com.lumpofcode.math.IntegerMath;

/**
 * Created by emurphy on 6/17/17.
 */
public final class VectorTrie<T> implements Vector<T>
{
	public static final int VECTOR_TRIE_SIZE = 3;
	
	private final int level;        // zero if leaf node, 1 is first level trie, 2 is second level trie, etc.
	private final int childSize;    // size of each child node
	private final int size;
	private final Vector<T> vector01;
	private final Vector<T> vector02;
	private final Vector<T> vector03;
	
	public VectorTrie(final int level, final Vector<T> vector01, final Vector<T> vector02)
	{
		this(level, vector01, vector02, Vectors.empty);
	}
	
	public VectorTrie(final int level, final Vector<T> vector01, final Vector<T> vector02, final Vector<T> vector03)
	{
		this.level = level;
		this.vector01 = vector01;
		this.vector02 = vector02;
		this.vector03 = vector03;
		
		this.childSize = IntegerMath.power(VECTOR_TRIE_SIZE, level);
		this.size = vector01.size() + vector02.size() + vector03.size();
	}
	
	@Override
	public int size()
	{
		return this.size;
	}
	
	@Override
	public T get(int index)
	{
		if((index < 0) || (index >= size())) throw new IndexOutOfBoundsException();

		switch(index / childSize)
		{
			case 0: return vector01.get(index % childSize);
			case 1: return vector02.get(index % childSize);
			default: return vector03.get(index % childSize);
		}
	}
	
	@Override
	public Vector<T> set(int index, T value)
	{
		if((index < 0) || (index > size())) throw new IndexOutOfBoundsException();
		
		switch(index / childSize)
		{
			case 0: return new VectorTrie(level, vector01.set(index % childSize, value), vector02, vector03);
			case 1: return new VectorTrie(level, vector01, vector02.set(index % childSize, value), vector03);
			case 2: return new VectorTrie(level, vector01, vector02, vector03.set(index % childSize, value));
			default:
				//
				// create a new level in the vector trie hierarchy
				//
				return new VectorTrie(
						level + 1,
						this,
						new VectorOf1(value),
						Vectors.empty);
		}
	}
	private StringBuilder tab(final StringBuilder builder, final int level)
	{
		for(int i = 0; i < level; i += 1)
		{
			builder.append('\t');
		}
		return builder;
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
			.append(']');
		
		return builder.toString();
	}
	
}
