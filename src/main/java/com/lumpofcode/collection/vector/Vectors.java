package com.lumpofcode.collection.vector;

/**
 * Created by emurphy on 6/16/17.
 */
public final class Vectors
{
	public static final int VECTOR_NODE_SIZE = 16;
	
	
	public static final EmptyVector empty = new EmptyVector();
	
	public static final <T> Vector<T> asVector(final T e1)
	{
		//return new VectorOf1<T>(e1);
		return new VectorOfSize<T>(1, e1, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2)
	{
		//return new VectorOf2<T>(e1, e2);
		return new VectorOfSize<T>(2, e1, e2, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3)
	{
		//return new VectorOf3<T>(e1, e2, e3);
		return new VectorOfSize<T>(3, e1, e2, e3, null, null, null, null, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4)
	{
		//return new VectorOf4<T>(e1, e2, e3, e4);
		return new VectorOfSize<T>(4, e1, e2, e3, e4, null, null, null, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5)
	{
		//return new VectorOf5<T>(e1, e2, e3, e4, e5);
		return new VectorOfSize<T>(5, e1, e2, e3, e4, e5, null, null, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6)
	{
		//return new VectorOf6<T>(e1, e2, e3, e4, e5, e6);
		return new VectorOfSize<T>(6, e1, e2, e3, e4, e5, e6, null, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7)
	{
		//return new VectorOf7<T>(e1, e2, e3, e4, e5, e6, e7);
		return new VectorOfSize<T>(7, e1, e2, e3, e4, e5, e6, e7, null,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8)
	{
		//return new VectorOf8<T>(e1, e2, e3, e4, e5, e6, e7, e8);
		return new VectorOfSize<T>(8, e1, e2, e3, e4, e5, e6, e7, e8,
			null, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9)
	{
		//return new VectorOf9<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9);
		return new VectorOfSize<T>(9, e1, e2, e3, e4, e5, e6, e7, e8, e9, null, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10)
	{
		//return new VectorOf10<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
		return new VectorOfSize<T>(10, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, null, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11)
	{
		//return new VectorOf11<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
		return new VectorOfSize<T>(11, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, null, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12)
	{
		//return new VectorOf12<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
		return new VectorOfSize<T>(12, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, null, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13)
	{
		//return new VectorOf13<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
		return new VectorOfSize<T>(13, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, null, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13, final T e14)
	{
		//return new VectorOf14<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14);
		return new VectorOfSize<T>(14, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, null, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		//return new VectorOf15<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
		return new VectorOfSize<T>(15, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, null);
	}
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15, final T e16)
	{
		//return new VectorOf16<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
		return new VectorOfSize<T>(16, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
	}
}
