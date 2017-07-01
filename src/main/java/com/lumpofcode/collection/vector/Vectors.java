package com.lumpofcode.collection.vector;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Methods that create or act on Vectors.
 *
 * Use the Vectors.asVector() functions to construct Vectors.
 *
 * Created by emurphy on 6/16/17.
 */
public final class Vectors
{
	public static final int VECTOR_NODE_SIZE = 16;
	
	/**
	 * An empty vector as a singleton.
	 */
	public static final EmptyVector empty = new EmptyVector();
	
	/**
	 * Factory to construct a Vector with a single element
	 *
	 * @param e1 the element
	 * @param <T> the type of the element
	 * @return a Vector of type T with one element
	 */
	public static final <T> Vector<T> asVector(final T e1)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf1<T>(e1);
//		return new VectorOfSize<T>(1, e1, null, null, null, null, null, null, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a two elements
	 *
	 * @param e1
	 * @param e2
	 * @param <T> the type of the elements
	 * @return a Vector of type T with two elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf2<T>(e1, e2);
//		return new VectorOfSize<T>(2, e1, e2, null, null, null, null, null, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a three elements
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param <T> the type of the elements
	 * @return a Vector of type T with three elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf3<T>(e1, e2, e3);
//		return new VectorOfSize<T>(3, e1, e2, e3, null, null, null, null, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a four elements
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param e4
	 * @param <T> the type of the elements
	 * @return a Vector of type T with four elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf4<T>(e1, e2, e3, e4);
//		return new VectorOfSize<T>(4, e1, e2, e3, e4, null, null, null, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a five elements
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param e4
	 * @param e5
	 * @param <T> the type of the elements
	 * @return a Vector of type T with five elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf5<T>(e1, e2, e3, e4, e5);
//		return new VectorOfSize<T>(5, e1, e2, e3, e4, e5, null, null, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a six elements
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param e4
	 * @param e5
	 * @param e6
	 * @param <T> the type of the elements
	 * @return a Vector of type T with six elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf6<T>(e1, e2, e3, e4, e5, e6);
//		return new VectorOfSize<T>(6, e1, e2, e3, e4, e5, e6, null, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a sleven elements :)
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param e4
	 * @param e5
	 * @param e6
	 * @param e7
	 * @param <T> the type of the elements
	 * @return a Vector of type T with seven elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf7<T>(e1, e2, e3, e4, e5, e6, e7);
//		return new VectorOfSize<T>(7, e1, e2, e3, e4, e5, e6, e7, null,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a eight elements
	 *
	 * @param e1
	 * @param e2
	 * @param e3
	 * @param e4
	 * @param e5
	 * @param e6
	 * @param e7
	 * @param e8
	 * @param <T> the type of the elements
	 * @return a Vector of type T with eight elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf8<T>(e1, e2, e3, e4, e5, e6, e7, e8);
//		return new VectorOfSize<T>(8, e1, e2, e3, e4, e5, e6, e7, e8,
//			null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a nine elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with nine elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf9<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9);
//		return new VectorOfSize<T>(9, e1, e2, e3, e4, e5, e6, e7, e8, e9, null, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a ten elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with ten elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf10<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
//		return new VectorOfSize<T>(10, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, null, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a eleven elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with eleven elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf11<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
//		return new VectorOfSize<T>(11, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, null, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a twelve elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with twelve elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf12<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
//		return new VectorOfSize<T>(12, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, null, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a thirteen elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with thirteen elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf13<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
//		return new VectorOfSize<T>(13, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, null, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a fourteen elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with fourteen elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13, final T e14)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf14<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14);
//		return new VectorOfSize<T>(14, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, null, null);
	}
	
	/**
	 * Factory to construct a Vector with a fifteen elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with fifteen elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf15<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
//		return new VectorOfSize<T>(15, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, null);
	}
	
	/**
	 * Factory to construct a Vector with a sixteen elements
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
	 * @param <T> the type of the elements
	 * @return a Vector of type T with sixteen elements
	 */
	public static final <T> Vector<T> asVector(final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8,
	                                           final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15, final T e16)
	{
		return new com.lumpofcode.collection.vector.impl.VectorOf16<T>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
//		return new VectorOfSize<T>(16, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
	}
	
	/**
	 * Construct a vector from an Iterable
	 *
	 * @param values an Iterable that provides ordered values
	 * @param <T>
	 * @return A vector of the elements of the Iterable
	 */
	public static final <T> Vector<T> asVector(Iterable<T> values)
	{
		return Vectors.empty.pushAll(values);
	}
	
	
	/**
	 * Push all elements in the Iterable into the end of the Vector
	 *
	 * @param vector
	 * @param iterable
	 * @param <T>
	 * @return a new Vector with the Iterable's elements appended.
	 */
	public static final <T> Vector<T> pushAll(final Vector vector, final Iterable<T> iterable)
	{
		//
		// do in chunks of 16 for efficiency
		//
		Vector<T> result = vector;
		final Iterator<T> it = iterable.iterator();
		
		//
		// get to a 16-aligned result, so we can start using push-16 for efficiency
		//
		while(((result.size() % VECTOR_NODE_SIZE) != 0) && it.hasNext())
		{
			result = result.push(it.next());
		}
		
		//
		// While we have 16 elements available, collect them and use the more efficient 16 push,
		// otherwise push each element individually
		//
		while(it.hasNext())
		{
			final T e1 = it.next();
			if (it.hasNext())
			{
				final T e2 = it.next();
				if (it.hasNext())
				{
					final T e3 = it.next();
					if (it.hasNext())
					{
						final T e4 = it.next();
						if (it.hasNext())
						{
							final T e5 = it.next();
							if (it.hasNext())
							{
								final T e6 = it.next();
								if (it.hasNext())
								{
									final T e7 = it.next();
									if (it.hasNext())
									{
										final T e8 = it.next();
										if (it.hasNext())
										{
											final T e9 = it.next();
											if (it.hasNext())
											{
												final T e10 = it.next();
												if (it.hasNext())
												{
													final T e11 = it.next();
													if (it.hasNext())
													{
														final T e12 = it.next();
														if (it.hasNext())
														{
															final T e13 = it.next();
															if (it.hasNext())
															{
																final T e14 = it.next();
																if (it.hasNext())
																{
																	final T e15 = it.next();
																	if (it.hasNext())
																	{
																		final T e16 = it.next();
																		result = result.push(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
																	}
																	else
																	{
																		result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12).push(e13).push(e14).push(e15);
																	}
																}
																else
																{
																	result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12).push(e13).push(e14);
																}
															}
															else
															{
																result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12).push(e13);
															}
														}
														else
														{
															result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12);
														}
													}
													else
													{
														result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11);
													}
													
												}
												else
												{
													result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10);
												}
											}
											else
											{
												result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9);
											}
										}
										else
										{
											result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8);
										}
									}
									else
									{
										result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7);
									}
								}
								else
								{
									result = result.push(e1).push(e2).push(e3).push(e4).push(e5).push(e6);
								}
							}
							else
							{
								result = result.push(e1).push(e2).push(e3).push(e4).push(e5);
							}
						}
						else
						{
							result = result.push(e1).push(e2).push(e3).push(e4);
						}
					}
					else
					{
						result = result.push(e1).push(e2).push(e3);
					}
				}
				else
				{
					result = result.push(e1).push(e2);
				}
			}
			else
			{
				result = result.push(e1);
			}
		}
		
		return result;
	}
	

	public static <T, R> Vector<R> map(@NotNull Vector<T> vector, @NotNull Function<? super T, ? extends R> mapper)
	{
		//
		// do in chunks of 16 for efficiency
		//
		Vector<R> result = Vectors.empty;
		int index = 0;
		while(index <= (vector.size() - Vectors.VECTOR_NODE_SIZE))
		{
			result = result.push(
				mapper.apply(vector.get(index + 0)), mapper.apply(vector.get(index + 1)), mapper.apply(vector.get(index + 2)), mapper.apply(vector.get(index + 3)),
				mapper.apply(vector.get(index + 4)), mapper.apply(vector.get(index + 5)), mapper.apply(vector.get(index + 6)), mapper.apply(vector.get(index + 7)),
				mapper.apply(vector.get(index + 8)), mapper.apply(vector.get(index + 9)), mapper.apply(vector.get(index + 10)), mapper.apply(vector.get(index + 11)),
				mapper.apply(vector.get(index + 12)), mapper.apply(vector.get(index + 13)), mapper.apply(vector.get(index + 14)), mapper.apply(vector.get(index + 15)));
			
			index += Vectors.VECTOR_NODE_SIZE;
		}
		
		//
		// handle the rest with simple push
		//
		while(index < vector.size())
		{
			result = result.push(mapper.apply(vector.get(index)));
			
			index += 1;
		}
		return result;
	}
	
	public static <T, R> Vector<R> flatmap(@NotNull Vector<T> vector, @NotNull Function<T, Vector<R>> mapper)
	{
		Vector<R> result = Vectors.empty;
		for(T element : vector)
		{
			result = result.pushAll(mapper.apply(element));
		}
		return result;
	}
	
	
	
}
