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
public final class Tuple4<T1, T2, T3, T4>
{
	public final T1 _1;
	public final T2 _2;
	public final T3 _3;
	public final T4 _4;

	/**
	 * Complete constructor
	 *
	 * @param t1 component 1 of type T1
	 * @param t2 component 2 of type T2
	 * @param t3 component 3 of type T3
	 * @param t4 component 4 of type T4
	 */
	@JsonCreator
	public Tuple4(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3, @JsonProperty("t4") T4 t4)
	{
		_1 = t1;
		_2 = t2;
		_3 = t3;
		_4 = t4;
	}

	public int size() { return 4; }

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
	 * get component 3
	 *
	 * @return value of component 3
	 */
	public T3 _3() { return _3; }

	/**
	 * get component 4
	 *
	 * @return value of component 4
	 */
	public T4 _4() { return _4; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNullable Function<? super Tuple4<? super T1, ? super T2, ? super T3, ? super T4>, ? extends R> mapper)
	{
		return mapper.apply(this);
	}

	/**
	 * Map a Tuple to another Tuple with a mapper function per component.
	 *
	 * @param mapper1 mapper for component 1
	 * @param mapper2 mapper for component 2
	 * @param mapper3 mapper for component 3
	 * @param mapper4 mapper for component 4
	 * @param <R1> resulting type of component 1
	 * @param <R2> resulting type of component 2
	 * @param <R3> resulting type of component 3
	 * @param <R4> resulting type of component 4
	 * @return new Tuple with mapped components
	 */
	public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> mapTuple(
		@NotNullable Function<? super T1, ? extends R1> mapper1, 
		@NotNullable Function<? super T2, ? extends R2> mapper2, 
		@NotNullable Function<? super T3, ? extends R3> mapper3, 
		@NotNullable Function<? super T4, ? extends R4> mapper4)
	{
		return new Tuple4(mapper1.apply(_1), mapper2.apply(_2), mapper3.apply(_3), mapper4.apply(_4));
	}

	/**
	 * Create a new Tuple by mapping component 1
	 *
	 * @param mapper1 mapper for component 1
	 * @param <R1> result type for component 1
	 * @return a new Tuple with component 1 mapped
	 */
	public <R1> Tuple4<R1, T2, T3, T4> map_1 (@NotNullable Function <? super T1, ? extends R1> mapper1)
	{
		return new Tuple4(mapper1.apply(_1), _2, _3, _4);
	}

	/**
	 * Create a new Tuple by mapping component 2
	 *
	 * @param mapper2 mapper for component 2
	 * @param <R2> result type for component 2
	 * @return a new Tuple with component 2 mapped
	 */
	public <R2> Tuple4<T1, R2, T3, T4> map_2 (@NotNullable Function <? super T2, ? extends R2> mapper2)
	{
		return new Tuple4(_1, mapper2.apply(_2), _3, _4);
	}

	/**
	 * Create a new Tuple by mapping component 3
	 *
	 * @param mapper3 mapper for component 3
	 * @param <R3> result type for component 3
	 * @return a new Tuple with component 3 mapped
	 */
	public <R3> Tuple4<T1, T2, R3, T4> map_3 (@NotNullable Function <? super T3, ? extends R3> mapper3)
	{
		return new Tuple4(_1, _2, mapper3.apply(_3), _4);
	}

	/**
	 * Create a new Tuple by mapping component 4
	 *
	 * @param mapper4 mapper for component 4
	 * @param <R4> result type for component 4
	 * @return a new Tuple with component 4 mapped
	 */
	public <R4> Tuple4<T1, T2, T3, R4> map_4 (@NotNullable Function <? super T4, ? extends R4> mapper4)
	{
		return new Tuple4(_1, _2, _3, mapper4.apply(_4));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("(");
		sb.append((null != _1) ? _1 : "null");
		sb.append((null != _2) ? _2 : "null");
		sb.append((null != _3) ? _3 : "null");
		sb.append((null != _4) ? _4 : "null");
		sb.append(')');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple4<?,?,?,?> tuple4 = (Tuple4<?,?,?,?>) that;

		if (_1 != null ? !_1.equals(tuple4._1) : tuple4._1 != null) return false;
		if (_2 != null ? !_2.equals(tuple4._2) : tuple4._2 != null) return false;
		if (_3 != null ? !_3.equals(tuple4._3) : tuple4._3 != null) return false;
		if (_4 != null ? !_4.equals(tuple4._4) : tuple4._4 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = _1 != null ? _1.hashCode() : 0;
		result = 31 * result + (_2 != null ? _2.hashCode() : 0);
		result = 31 * result + (_3 != null ? _3.hashCode() : 0);
		result = 31 * result + (_4 != null ? _4.hashCode() : 0);
		return result;
	}

}

