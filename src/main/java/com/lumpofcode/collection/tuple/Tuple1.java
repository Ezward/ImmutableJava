package com.lumpofcode.collection.tuple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.lumpofcode.annotation.NotNullable;
import java.util.function.Function;

/**
 * A finite ordered collection of elements with independent types.
 *
 * Created by emurphy on 6/25/17.
 */
public final class Tuple1<T1>
{
	public final T1 _1;

	/**
	 * Complete constructor
	 *
	 * @param t1 component 1 of type T1
	 */
	@JsonCreator
	public Tuple1(@JsonProperty("t1") T1 t1)
	{
		_1 = t1;
	}

	public int size() { return 1; }

	/**
	 * get component 1
	 *
	 * @return value of component 1
	 */
	public T1 _1() { return _1; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNullable Function<? super Tuple1<? super T1>, ? extends R> mapper)
	{
		return mapper.apply(this);
	}

	/**
	 * Map a Tuple to another Tuple with a mapper function per component.
	 *
	 * @param mapper1 mapper for component 1
	 * @param <R1> resulting type of component 1
	 * @return new Tuple with mapped components
	 */
	public <R1> Tuple1<R1> mapTuple(
		@NotNullable Function<? super T1, ? extends R1> mapper1)
	{
		return new Tuple1(mapper1.apply(_1));
	}

	/**
	 * Create a new Tuple by mapping component 1
	 *
	 * @param mapper1 mapper for component 1
	 * @param <R1> result type for component 1
	 * @return a new Tuple with component 1 mapped
	 */
	public <R1> Tuple1<R1> map_1 (@NotNullable Function <? super T1, ? extends R1> mapper1)
	{
		return new Tuple1(mapper1.apply(_1));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("(");
		sb.append((null != _1) ? _1 : "null");
		sb.append(')');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple1<?> tuple1 = (Tuple1<?>) that;

		if (_1 != null ? !_1.equals(tuple1._1) : tuple1._1 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = _1 != null ? _1.hashCode() : 0;
		return result;
	}

}

