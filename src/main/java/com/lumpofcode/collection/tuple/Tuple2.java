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
public final class Tuple2<T1, T2>
{
	public final T1 t1;
	public final T2 t2;

	/**
	 * Complete constructor
	 *
	 * @param t1
	 * @param t2
	 */
	@JsonCreator
	public Tuple2(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2)
	{
		this.t1 = t1;
		this.t2 = t2;
	}

	public int size() { return 2; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNullable Function<? super Tuple2<? super T1, ? super T2>, ? extends R> mapper)
	{
		return mapper.apply(this);
	}

	/**
	 * Map a Tuple to another Tuple with a mapper function per element.
	 *
	 * @param mapper1 mapper for element 1
	 * @param mapper2 mapper for element 2
	 * @param <R1> resulting type of element 1
	 * @param <R2> resulting type of element 2
	 * @return new Tuple with mapped elements
	 */
	public <R1, R2> Tuple2<R1, R2> map(
		@NotNullable Function<? super T1, ? extends R1> mapper1, 
		@NotNullable Function<? super T2, ? extends R2> mapper2)
	{
		return new Tuple2(mapper1.apply(t1), mapper2.apply(t2));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("{");
		sb.append("t1: ").append((null != t1) ? t1 : "null");
		sb.append(", t2: ").append((null != t2) ? t2 : "null");
		sb.append('}');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple2<?,?> tuple2 = (Tuple2<?,?>) that;

		if (t1 != null ? !t1.equals(tuple2.t1) : tuple2.t1 != null) return false;
		if (t2 != null ? !t2.equals(tuple2.t2) : tuple2.t2 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = t1 != null ? t1.hashCode() : 0;
		result = 31 * result + (t2 != null ? t2.hashCode() : 0);
		return result;
	}

}

