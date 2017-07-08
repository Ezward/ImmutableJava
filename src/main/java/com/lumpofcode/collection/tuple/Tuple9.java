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
public final class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
{
	public final T1 _1;
	public final T2 _2;
	public final T3 _3;
	public final T4 _4;
	public final T5 _5;
	public final T6 _6;
	public final T7 _7;
	public final T8 _8;
	public final T9 _9;

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
	 * @param t8 component 8 of type T8
	 * @param t9 component 9 of type T9
	 */
	@JsonCreator
	public Tuple9(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3, @JsonProperty("t4") T4 t4, @JsonProperty("t5") T5 t5, @JsonProperty("t6") T6 t6, @JsonProperty("t7") T7 t7, @JsonProperty("t8") T8 t8, @JsonProperty("t9") T9 t9)
	{
		_1 = t1;
		_2 = t2;
		_3 = t3;
		_4 = t4;
		_5 = t5;
		_6 = t6;
		_7 = t7;
		_8 = t8;
		_9 = t9;
	}

	public int size() { return 9; }

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
	 * get component 8
	 *
	 * @return value of component 8
	 */
	public T8 _8() { return _8; }

	/**
	 * get component 9
	 *
	 * @return value of component 9
	 */
	public T9 _9() { return _9; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNullable Function<? super Tuple9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9>, ? extends R> mapper)
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
	 * @param mapper8 mapper for component 8
	 * @param mapper9 mapper for component 9
	 * @param <R1> resulting type of component 1
	 * @param <R2> resulting type of component 2
	 * @param <R3> resulting type of component 3
	 * @param <R4> resulting type of component 4
	 * @param <R5> resulting type of component 5
	 * @param <R6> resulting type of component 6
	 * @param <R7> resulting type of component 7
	 * @param <R8> resulting type of component 8
	 * @param <R9> resulting type of component 9
	 * @return new Tuple with mapped components
	 */
	public <R1, R2, R3, R4, R5, R6, R7, R8, R9> Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTuple(
		@NotNullable Function<? super T1, ? extends R1> mapper1, 
		@NotNullable Function<? super T2, ? extends R2> mapper2, 
		@NotNullable Function<? super T3, ? extends R3> mapper3, 
		@NotNullable Function<? super T4, ? extends R4> mapper4, 
		@NotNullable Function<? super T5, ? extends R5> mapper5, 
		@NotNullable Function<? super T6, ? extends R6> mapper6, 
		@NotNullable Function<? super T7, ? extends R7> mapper7, 
		@NotNullable Function<? super T8, ? extends R8> mapper8, 
		@NotNullable Function<? super T9, ? extends R9> mapper9)
	{
		return new Tuple9(mapper1.apply(_1), mapper2.apply(_2), mapper3.apply(_3), mapper4.apply(_4), mapper5.apply(_5), mapper6.apply(_6), mapper7.apply(_7), mapper8.apply(_8), mapper9.apply(_9));
	}

	/**
	 * Create a new Tuple by mapping component 1
	 *
	 * @param mapper1 mapper for component 1
	 * @param <R1> result type for component 1
	 * @return a new Tuple with component 1 mapped
	 */
	public <R1> Tuple9<R1, T2, T3, T4, T5, T6, T7, T8, T9> map_1 (@NotNullable Function <? super T1, ? extends R1> mapper1)
	{
		return new Tuple9(mapper1.apply(_1), _2, _3, _4, _5, _6, _7, _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 2
	 *
	 * @param mapper2 mapper for component 2
	 * @param <R2> result type for component 2
	 * @return a new Tuple with component 2 mapped
	 */
	public <R2> Tuple9<T1, R2, T3, T4, T5, T6, T7, T8, T9> map_2 (@NotNullable Function <? super T2, ? extends R2> mapper2)
	{
		return new Tuple9(_1, mapper2.apply(_2), _3, _4, _5, _6, _7, _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 3
	 *
	 * @param mapper3 mapper for component 3
	 * @param <R3> result type for component 3
	 * @return a new Tuple with component 3 mapped
	 */
	public <R3> Tuple9<T1, T2, R3, T4, T5, T6, T7, T8, T9> map_3 (@NotNullable Function <? super T3, ? extends R3> mapper3)
	{
		return new Tuple9(_1, _2, mapper3.apply(_3), _4, _5, _6, _7, _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 4
	 *
	 * @param mapper4 mapper for component 4
	 * @param <R4> result type for component 4
	 * @return a new Tuple with component 4 mapped
	 */
	public <R4> Tuple9<T1, T2, T3, R4, T5, T6, T7, T8, T9> map_4 (@NotNullable Function <? super T4, ? extends R4> mapper4)
	{
		return new Tuple9(_1, _2, _3, mapper4.apply(_4), _5, _6, _7, _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 5
	 *
	 * @param mapper5 mapper for component 5
	 * @param <R5> result type for component 5
	 * @return a new Tuple with component 5 mapped
	 */
	public <R5> Tuple9<T1, T2, T3, T4, R5, T6, T7, T8, T9> map_5 (@NotNullable Function <? super T5, ? extends R5> mapper5)
	{
		return new Tuple9(_1, _2, _3, _4, mapper5.apply(_5), _6, _7, _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 6
	 *
	 * @param mapper6 mapper for component 6
	 * @param <R6> result type for component 6
	 * @return a new Tuple with component 6 mapped
	 */
	public <R6> Tuple9<T1, T2, T3, T4, T5, R6, T7, T8, T9> map_6 (@NotNullable Function <? super T6, ? extends R6> mapper6)
	{
		return new Tuple9(_1, _2, _3, _4, _5, mapper6.apply(_6), _7, _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 7
	 *
	 * @param mapper7 mapper for component 7
	 * @param <R7> result type for component 7
	 * @return a new Tuple with component 7 mapped
	 */
	public <R7> Tuple9<T1, T2, T3, T4, T5, T6, R7, T8, T9> map_7 (@NotNullable Function <? super T7, ? extends R7> mapper7)
	{
		return new Tuple9(_1, _2, _3, _4, _5, _6, mapper7.apply(_7), _8, _9);
	}

	/**
	 * Create a new Tuple by mapping component 8
	 *
	 * @param mapper8 mapper for component 8
	 * @param <R8> result type for component 8
	 * @return a new Tuple with component 8 mapped
	 */
	public <R8> Tuple9<T1, T2, T3, T4, T5, T6, T7, R8, T9> map_8 (@NotNullable Function <? super T8, ? extends R8> mapper8)
	{
		return new Tuple9(_1, _2, _3, _4, _5, _6, _7, mapper8.apply(_8), _9);
	}

	/**
	 * Create a new Tuple by mapping component 9
	 *
	 * @param mapper9 mapper for component 9
	 * @param <R9> result type for component 9
	 * @return a new Tuple with component 9 mapped
	 */
	public <R9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, R9> map_9 (@NotNullable Function <? super T9, ? extends R9> mapper9)
	{
		return new Tuple9(_1, _2, _3, _4, _5, _6, _7, _8, mapper9.apply(_9));
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
		sb.append((null != _8) ? _8 : "null");
		sb.append((null != _9) ? _9 : "null");
		sb.append(')');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple9<?,?,?,?,?,?,?,?,?> tuple9 = (Tuple9<?,?,?,?,?,?,?,?,?>) that;

		if (_1 != null ? !_1.equals(tuple9._1) : tuple9._1 != null) return false;
		if (_2 != null ? !_2.equals(tuple9._2) : tuple9._2 != null) return false;
		if (_3 != null ? !_3.equals(tuple9._3) : tuple9._3 != null) return false;
		if (_4 != null ? !_4.equals(tuple9._4) : tuple9._4 != null) return false;
		if (_5 != null ? !_5.equals(tuple9._5) : tuple9._5 != null) return false;
		if (_6 != null ? !_6.equals(tuple9._6) : tuple9._6 != null) return false;
		if (_7 != null ? !_7.equals(tuple9._7) : tuple9._7 != null) return false;
		if (_8 != null ? !_8.equals(tuple9._8) : tuple9._8 != null) return false;
		if (_9 != null ? !_9.equals(tuple9._9) : tuple9._9 != null) return false;

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
		result = 31 * result + (_8 != null ? _8.hashCode() : 0);
		result = 31 * result + (_9 != null ? _9.hashCode() : 0);
		return result;
	}

}

