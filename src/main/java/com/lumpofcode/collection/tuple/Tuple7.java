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
public final class Tuple7<T1, T2, T3, T4, T5, T6, T7>
{
	public final T1 _1;
	public final T2 _2;
	public final T3 _3;
	public final T4 _4;
	public final T5 _5;
	public final T6 _6;
	public final T7 _7;

	/**
	 * Complete constructor
	 *
	 * @param t1 component 1 of type T1
	 * @param t2 component 2 of type T2
	 * @param t3 component 3 of type T3
	 * @param t4 component 4 of type T4
	 * @param t5 component 5 of type T5
	 * @param t6 component 6 of type T6
	 * @param t7 component 7 of type T7
	 */
	@JsonCreator
	public Tuple7(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3, @JsonProperty("t4") T4 t4, @JsonProperty("t5") T5 t5, @JsonProperty("t6") T6 t6, @JsonProperty("t7") T7 t7)
	{
		_1 = t1;
		_2 = t2;
		_3 = t3;
		_4 = t4;
		_5 = t5;
		_6 = t6;
		_7 = t7;
	}

	public int size() { return 7; }

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
	 * get component 5
	 *
	 * @return value of component 5
	 */
	public T5 _5() { return _5; }

	/**
	 * get component 6
	 *
	 * @return value of component 6
	 */
	public T6 _6() { return _6; }

	/**
	 * get component 7
	 *
	 * @return value of component 7
	 */
	public T7 _7() { return _7; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNull Function<? super Tuple7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7>, ? extends R> mapper)
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
	 * @param mapper5 mapper for component 5
	 * @param mapper6 mapper for component 6
	 * @param mapper7 mapper for component 7
	 * @param <R1> resulting type of component 1
	 * @param <R2> resulting type of component 2
	 * @param <R3> resulting type of component 3
	 * @param <R4> resulting type of component 4
	 * @param <R5> resulting type of component 5
	 * @param <R6> resulting type of component 6
	 * @param <R7> resulting type of component 7
	 * @return new Tuple with mapped components
	 */
	public <R1, R2, R3, R4, R5, R6, R7> Tuple7<R1, R2, R3, R4, R5, R6, R7> mapTuple(
		@NotNull Function<? super T1, ? extends R1> mapper1, 
		@NotNull Function<? super T2, ? extends R2> mapper2, 
		@NotNull Function<? super T3, ? extends R3> mapper3, 
		@NotNull Function<? super T4, ? extends R4> mapper4, 
		@NotNull Function<? super T5, ? extends R5> mapper5, 
		@NotNull Function<? super T6, ? extends R6> mapper6, 
		@NotNull Function<? super T7, ? extends R7> mapper7)
	{
		return new Tuple7(mapper1.apply(_1), mapper2.apply(_2), mapper3.apply(_3), mapper4.apply(_4), mapper5.apply(_5), mapper6.apply(_6), mapper7.apply(_7));
	}

	/**
	 * Create a new Tuple by mapping component 1
	 *
	 * @param mapper1 mapper for component 1
	 * @param <R1> result type for component 1
	 * @return a new Tuple with component 1 mapped
	 */
	public <R1> Tuple7<R1, T2, T3, T4, T5, T6, T7> map_1 (@NotNull Function <? super T1, ? extends R1> mapper1)
	{
		return new Tuple7(mapper1.apply(_1), _2, _3, _4, _5, _6, _7);
	}

	/**
	 * Create a new Tuple by mapping component 2
	 *
	 * @param mapper2 mapper for component 2
	 * @param <R2> result type for component 2
	 * @return a new Tuple with component 2 mapped
	 */
	public <R2> Tuple7<T1, R2, T3, T4, T5, T6, T7> map_2 (@NotNull Function <? super T2, ? extends R2> mapper2)
	{
		return new Tuple7(_1, mapper2.apply(_2), _3, _4, _5, _6, _7);
	}

	/**
	 * Create a new Tuple by mapping component 3
	 *
	 * @param mapper3 mapper for component 3
	 * @param <R3> result type for component 3
	 * @return a new Tuple with component 3 mapped
	 */
	public <R3> Tuple7<T1, T2, R3, T4, T5, T6, T7> map_3 (@NotNull Function <? super T3, ? extends R3> mapper3)
	{
		return new Tuple7(_1, _2, mapper3.apply(_3), _4, _5, _6, _7);
	}

	/**
	 * Create a new Tuple by mapping component 4
	 *
	 * @param mapper4 mapper for component 4
	 * @param <R4> result type for component 4
	 * @return a new Tuple with component 4 mapped
	 */
	public <R4> Tuple7<T1, T2, T3, R4, T5, T6, T7> map_4 (@NotNull Function <? super T4, ? extends R4> mapper4)
	{
		return new Tuple7(_1, _2, _3, mapper4.apply(_4), _5, _6, _7);
	}

	/**
	 * Create a new Tuple by mapping component 5
	 *
	 * @param mapper5 mapper for component 5
	 * @param <R5> result type for component 5
	 * @return a new Tuple with component 5 mapped
	 */
	public <R5> Tuple7<T1, T2, T3, T4, R5, T6, T7> map_5 (@NotNull Function <? super T5, ? extends R5> mapper5)
	{
		return new Tuple7(_1, _2, _3, _4, mapper5.apply(_5), _6, _7);
	}

	/**
	 * Create a new Tuple by mapping component 6
	 *
	 * @param mapper6 mapper for component 6
	 * @param <R6> result type for component 6
	 * @return a new Tuple with component 6 mapped
	 */
	public <R6> Tuple7<T1, T2, T3, T4, T5, R6, T7> map_6 (@NotNull Function <? super T6, ? extends R6> mapper6)
	{
		return new Tuple7(_1, _2, _3, _4, _5, mapper6.apply(_6), _7);
	}

	/**
	 * Create a new Tuple by mapping component 7
	 *
	 * @param mapper7 mapper for component 7
	 * @param <R7> result type for component 7
	 * @return a new Tuple with component 7 mapped
	 */
	public <R7> Tuple7<T1, T2, T3, T4, T5, T6, R7> map_7 (@NotNull Function <? super T7, ? extends R7> mapper7)
	{
		return new Tuple7(_1, _2, _3, _4, _5, _6, mapper7.apply(_7));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("(");
		sb.append((null != _1) ? _1 : "null");
		sb.append((null != _2) ? _2 : "null");
		sb.append((null != _3) ? _3 : "null");
		sb.append((null != _4) ? _4 : "null");
		sb.append((null != _5) ? _5 : "null");
		sb.append((null != _6) ? _6 : "null");
		sb.append((null != _7) ? _7 : "null");
		sb.append(')');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple7<?,?,?,?,?,?,?> tuple7 = (Tuple7<?,?,?,?,?,?,?>) that;

		if (_1 != null ? !_1.equals(tuple7._1) : tuple7._1 != null) return false;
		if (_2 != null ? !_2.equals(tuple7._2) : tuple7._2 != null) return false;
		if (_3 != null ? !_3.equals(tuple7._3) : tuple7._3 != null) return false;
		if (_4 != null ? !_4.equals(tuple7._4) : tuple7._4 != null) return false;
		if (_5 != null ? !_5.equals(tuple7._5) : tuple7._5 != null) return false;
		if (_6 != null ? !_6.equals(tuple7._6) : tuple7._6 != null) return false;
		if (_7 != null ? !_7.equals(tuple7._7) : tuple7._7 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = _1 != null ? _1.hashCode() : 0;
		result = 31 * result + (_2 != null ? _2.hashCode() : 0);
		result = 31 * result + (_3 != null ? _3.hashCode() : 0);
		result = 31 * result + (_4 != null ? _4.hashCode() : 0);
		result = 31 * result + (_5 != null ? _5.hashCode() : 0);
		result = 31 * result + (_6 != null ? _6.hashCode() : 0);
		result = 31 * result + (_7 != null ? _7.hashCode() : 0);
		return result;
	}

}

