package com.lumpofcode.collection.tuple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lumpofcode.annotation.NotNull;
import com.lumpofcode.collection.vector.Vector;

import java.util.function.Function;

/**
 * Created by emurphy on 12/1/16.
 */
public final class Tuple2<T1, T2>
{
	//
	// Note that since properties are final, we don't need getter
	// we can just refer to the field directly.
	//
	public final T1 t1;
	public final T2 t2;
	
	//
	// annotate constructor for Jackson json mapper
	//
	@JsonCreator
	public Tuple2(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2)
	{
		this.t1 = t1;
		this.t2 = t2;
	}
	
	/**
	 * Map a Tuple2 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple2 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNull Function<? super Tuple2<T1, T2>, ? extends R> mapper)
	{
		return mapper.apply(this);
	}
	
	/**
	 * Map a Tuple2 into a Vector with elements of type R
	 *
	 * @param mapper function that takes a Tuple2 and returns a Vector with elements of type R
	 * @param <R> the result type
	 * @return a Vector with elements of type R
	 */
	public <R> Vector<R> flatmap(@NotNull Function<Tuple2<T1, T2>, Vector<R>> mapper)
	{
		return mapper.apply(this);
	}
	
	
	@Override
	public String toString()
	{
		final StringBuffer sb = new StringBuffer("{");
		sb.append("t1: ").append((null != t1) ? t1 : "null");
		sb.append(", t2: ").append((null != t2) ? t2 : "null");
		sb.append('}');
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
		
		if (t1 != null ? !t1.equals(tuple2.t1) : tuple2.t1 != null) return false;
		return t2 != null ? t2.equals(tuple2.t2) : tuple2.t2 == null;
	}
	
	@Override
	public int hashCode()
	{
		int result = t1 != null ? t1.hashCode() : 0;
		result = 31 * result + (t2 != null ? t2.hashCode() : 0);
		return result;
	}
}
