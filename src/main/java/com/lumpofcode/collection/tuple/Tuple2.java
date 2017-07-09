package com.lumpofcode.collection.tuple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.lumpofcode.annotation.NotNull;
import java.util.function.Function;

/**
 * A finite ordered collection of elements with independent types.
 *
 * Created by emurphy on 6/25/17.
 */
public final class Tuple2<T1, T2>
{
	public final T1 _1;
	public final T2 _2;

	/**
	 * Complete constructor
	 *
	 * @param t1 component 1 of type T1
	 * @param t2 component 2 of type T2
	 */
	@JsonCreator
	public Tuple2(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2)
	{
		_1 = t1;
		_2 = t2;
	}

	public int size() { return 2; }

	/**
	 * get component 1
	 *
	 * @return value of component 1
	 */
	public T1 _1() { return _1; }

	/**
	 * get component 2
	 *
	 * @return value of component 2
	 */
	public T2 _2() { return _2; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNull Function<? super Tuple2<? super T1, ? super T2>, ? extends R> mapper)
	{
		return mapper.apply(this);
	}

	/**
	 * Map a Tuple to another Tuple with a mapper function per component.
	 *
	 * @param mapper1 mapper for component 1
	 * @param mapper2 mapper for component 2
	 * @param <R1> resulting type of component 1
	 * @param <R2> resulting type of component 2
	 * @return new Tuple with mapped components
	 */
	public <R1, R2> Tuple2<R1, R2> mapTuple(
		@NotNull Function<? super T1, ? extends R1> mapper1, 
		@NotNull Function<? super T2, ? extends R2> mapper2)
	{
		return new Tuple2(mapper1.apply(_1), mapper2.apply(_2));
	}

	/**
	 * Create a new Tuple by mapping component 1
	 *
	 * @param mapper1 mapper for component 1
	 * @param <R1> result type for component 1
	 * @return a new Tuple with component 1 mapped
	 */
	public <R1> Tuple2<R1, T2> map_1 (@NotNull Function <? super T1, ? extends R1> mapper1)
	{
		return new Tuple2(mapper1.apply(_1), _2);
	}

	/**
	 * Create a new Tuple by mapping component 2
	 *
	 * @param mapper2 mapper for component 2
	 * @param <R2> result type for component 2
	 * @return a new Tuple with component 2 mapped
	 */
	public <R2> Tuple2<T1, R2> map_2 (@NotNull Function <? super T2, ? extends R2> mapper2)
	{
		return new Tuple2(_1, mapper2.apply(_2));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("(");
		sb.append((null != _1) ? _1 : "null");
		sb.append((null != _2) ? _2 : "null");
		sb.append(')');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple2<?,?> tuple2 = (Tuple2<?,?>) that;

		if (_1 != null ? !_1.equals(tuple2._1) : tuple2._1 != null) return false;
		if (_2 != null ? !_2.equals(tuple2._2) : tuple2._2 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = _1 != null ? _1.hashCode() : 0;
		result = 31 * result + (_2 != null ? _2.hashCode() : 0);
		return result;
	}

}

