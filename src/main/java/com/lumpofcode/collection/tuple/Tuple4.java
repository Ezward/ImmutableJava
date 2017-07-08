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
	 * @param t1
	 * @param t2
	 * @param t3
	 * @param t4
	 */
	@JsonCreator
	public Tuple4(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3, @JsonProperty("t4") T4 t4)
	{
		this._1 = t1;
		this._2 = t2;
		this._3 = t3;
		this._4 = t4;
	}

	public int size() { return 4; }

	public T1 _1() { return this._1; }
	public T2 _2() { return this._2; }
	public T3 _3() { return this._3; }
	public T4 _4() { return this._4; }

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
	 * Map a Tuple to another Tuple with a mapper function per element.
	 *
	 * @param mapper1 mapper for element 1
	 * @param mapper2 mapper for element 2
	 * @param mapper3 mapper for element 3
	 * @param mapper4 mapper for element 4
	 * @param <R1> resulting type of element 1
	 * @param <R2> resulting type of element 2
	 * @param <R3> resulting type of element 3
	 * @param <R4> resulting type of element 4
	 * @return new Tuple with mapped elements
	 */
	public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> map(
		@NotNullable Function<? super T1, ? extends R1> mapper1, 
		@NotNullable Function<? super T2, ? extends R2> mapper2, 
		@NotNullable Function<? super T3, ? extends R3> mapper3, 
		@NotNullable Function<? super T4, ? extends R4> mapper4)
	{
		return new Tuple4(mapper1.apply(this._1), mapper2.apply(this._2), mapper3.apply(this._3), mapper4.apply(this._4));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("{");
		sb.append("this._1: ").append((null != this._1) ? this._1 : "null");
		sb.append(", this._2: ").append((null != this._2) ? this._2 : "null");
		sb.append(", this._3: ").append((null != this._3) ? this._3 : "null");
		sb.append(", this._4: ").append((null != this._4) ? this._4 : "null");
		sb.append('}');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple4<?,?,?,?> tuple4 = (Tuple4<?,?,?,?>) that;

		if (this._1 != null ? !this._1.equals(tuple4._1) : tuple4._1 != null) return false;
		if (this._2 != null ? !this._2.equals(tuple4._2) : tuple4._2 != null) return false;
		if (this._3 != null ? !this._3.equals(tuple4._3) : tuple4._3 != null) return false;
		if (this._4 != null ? !this._4.equals(tuple4._4) : tuple4._4 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = this._1 != null ? this._1.hashCode() : 0;
		result = 31 * result + (this._2 != null ? this._2.hashCode() : 0);
		result = 31 * result + (this._3 != null ? this._3.hashCode() : 0);
		result = 31 * result + (this._4 != null ? this._4.hashCode() : 0);
		return result;
	}

}

