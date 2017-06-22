package com.lumpofcode.collection.vector;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Vector of up to length 16.
 *
 * This is an internal data structure.
 * Use Vectors.of() factory method to construct vectors from elements.
 *
 * Created by emurphy on 6/18/17.
 */
final class VectorOfSize<T> implements Vector<T>, Iterable<T>
{
	private final int size;
	
	private final T element01;
	private final T element02;
	private final T element03;
	private final T element04;
	private final T element05;
	private final T element06;
	private final T element07;
	private final T element08;
	private final T element09;
	private final T element10;
	private final T element11;
	private final T element12;
	private final T element13;
	private final T element14;
	private final T element15;
	private final T element16;
	
	
	/**
	 * Constructor for vector with 1..16 elements.
	 *
	 * @param size
	 * @param element01
	 * @param element02
	 * @param element03
	 * @param element04
	 * @param element05
	 * @param element06
	 * @param element07
	 * @param element08
	 * @param element09
	 * @param element10
	 * @param element11
	 * @param element12
	 * @param element13
	 * @param element14
	 * @param element15
	 * @param element16
	 */
	/* package private*/ VectorOfSize(final int size,
	                                  final T element01, final T element02, final T element03, final T element04,
	                                  final T element05, final T element06, final T element07, final T element08,
	                                  final T element09, final T element10, final T element11, final T element12,
	                                  final T element13, final T element14, final T element15, final T element16)
	{
		if((size < 1) || (size > Vectors.VECTOR_NODE_SIZE)) throw new IllegalArgumentException();
		this.size = size;
		
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element04 = element04;
		this.element05 = element05;
		this.element06 = element06;
		this.element07 = element07;
		this.element08 = element08;
		this.element09 = element09;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element14 = element14;
		this.element15 = element15;
		this.element16 = element16;
	}
	
	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	public boolean isEmpty()
	{
		return false;
	}
	
	@Override
	public T get(final int index)
	{
		if((index < 0) || (index >= size)) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: return element01;
			case 1: return element02;
			case 2: return element03;
			case 3: return element04;
			case 4: return element05;
			case 5: return element06;
			case 6: return element07;
			case 7: return element08;
			case 8: return element09;
			case 9: return element10;
			case 10: return element11;
			case 11: return element12;
			case 12: return element13;
			case 13: return element14;
			case 14: return element15;
			default: return element16;
		}
	}
	
	@Override
	public Vector<T> set(final int index, final T value)
	{
		//
		// make sure index is within bounds
		//
		if((index < 0) || (index > size)) throw new IndexOutOfBoundsException();
		if(index == size)
		{
			return push(value);
		}
		
		switch(index)
		{
			case 0: return new VectorOfSize(size, value, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 1: return new VectorOfSize(size, element01, value, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 2: return new VectorOfSize(size, element01, element02, value, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 3: return new VectorOfSize(size, element01, element02, element03, value, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 4: return new VectorOfSize(size, element01, element02, element03, element04, value, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 5: return new VectorOfSize(size, element01, element02, element03, element04, element05, value, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 6: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, value, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 7: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, value, element09, element10, element11, element12, element13, element14, element15, element16);
			case 8: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, value, element10, element11, element12, element13, element14, element15, element16);
			case 9: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, value, element11, element12, element13, element14, element15, element16);
			case 10: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, value, element12, element13, element14, element15, element16);
			case 11: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, value, element13, element14, element15, element16);
			case 12: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, value, element14, element15, element16);
			case 13: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, value, element15, element16);
			case 14: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, value, element16);
			default: return new VectorOfSize(size, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, value);
		}
	}
	
	/**
	 * Append an element onto the end of the vector.
	 *
	 * @param value
	 * @return a new vector with the element appended.
	 */
	public Vector<T> push(final T value)
	{
		switch(size)
		{
			case 0: return new VectorOfSize(size + 1, value, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 1: return new VectorOfSize(size + 1, element01, value, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 2: return new VectorOfSize(size + 1, element01, element02, value, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 3: return new VectorOfSize(size + 1, element01, element02, element03, value, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 4: return new VectorOfSize(size + 1, element01, element02, element03, element04, value, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 5: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, value, element07, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 6: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, value, element08, element09, element10, element11, element12, element13, element14, element15, element16);
			case 7: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, value, element09, element10, element11, element12, element13, element14, element15, element16);
			case 8: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, value, element10, element11, element12, element13, element14, element15, element16);
			case 9: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, value, element11, element12, element13, element14, element15, element16);
			case 10: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, value, element12, element13, element14, element15, element16);
			case 11: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, value, element13, element14, element15, element16);
			case 12: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, value, element14, element15, element16);
			case 13: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, value, element15, element16);
			case 14: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, value, element16);
			case 15: return new VectorOfSize(size + 1, element01, element02, element03, element04, element05, element06, element07, element08, element09, element10, element11, element12, element13, element14, element15, value);
			default: return new VectorTrie<T>(1, this, Vectors.asVector(value));
		}
	}
	
	public Vector<T> pushAll(final Vector<T> vector)
	{
		Vector<T> result = this;
		for(T element : vector)
		{
			result = result.push(element);
		}
		return result;
	}
	
	public <R> Vector<R> map(Function<? super T, ? extends R> mapper)
	{
		return new VectorOfSize<R>(
			size,
			mapper.apply(element01),
			mapper.apply(element02),
			mapper.apply(element03),
			mapper.apply(element04),
			mapper.apply(element05),
			mapper.apply(element06),
			mapper.apply(element07),
			mapper.apply(element08),
			mapper.apply(element09),
			mapper.apply(element10),
			mapper.apply(element11),
			mapper.apply(element12),
			mapper.apply(element13),
			mapper.apply(element14),
			mapper.apply(element15),
			mapper.apply(element16));
	}
	
	public	<R> Vector<R> flatmap(Function<T, Vector<R>> mapper)
	{
		Vector<R> result = Vectors.empty;
		for(T element : this)
		{
			result = result.pushAll(mapper.apply(element));
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder('[');
		if(size >= 1)
		{
			builder.append(element01);
			if(size > 2)
			{
				builder.append(", ").append(element02);
				if(size > 3)
				{
					builder.append(", ").append(element03);
					if(size >= 4)
					{
						builder.append(", ").append(element04);
						if (size >= 5)
						{
							builder.append(", ").append(element05);
							if (size >= 6)
							{
								builder.append(", ").append(element06);
								if (size >= 7)
								{
									builder.append(", ").append(element07);
									if (size >= 8)
									{
										builder.append(", ").append(element08);
										if (size >= 9)
										{
											builder.append(", ").append(element09);
											if (size >= 10)
											{
												builder.append(", ").append(element10);
												if (size >= 11)
												{
													builder.append(", ").append(element11);
													if (size >= 12)
													{
														builder.append(", ").append(element12);
														if (size >= 13)
														{
															builder.append(", ").append(element13);
															if (size >= 14)
															{
																builder.append(", ").append(element14);
																if (size >= 15)
																{
																	builder.append(", ").append(element15);
																	if (size == 16)
																	{
																		builder.append(", ").append(element16);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return builder.append(']').toString();
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
	
}
