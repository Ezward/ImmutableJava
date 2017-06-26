package com.lumpofcode.collection.tuple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lumpofcode.annotation.NotNull;
import com.lumpofcode.collection.vector.Vector;

import java.util.function.Function;

/**
 * Created by emurphy on 6/25/17.
 */
public final class Tuple3<T1, T2, T3>
{
	//
	// Note that since properties are final, we don't need getter
	// we can just refer to the field directly.
	//
	public final T1 t1;
	public final T2 t2;
	public final T3 t3;
	
	//
	// annotate constructor for Jackson json mapper
	//
	@JsonCreator
	public Tuple3(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
	}
	
	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNull Function<? super Tuple3<T1, T2, T3>, ? extends R> mapper)
	{
		return mapper.apply(this);
	}
	
	/**
	 * Map a Tuple3 into a Vector with elements of type R
	 *
	 * @param mapper function that takes a Tuple3 and returns a Vector with elements of type R
	 * @param <R> the result type
	 * @return a Vector with elements of type R
	 */
	public <R> Vector<R> flatmap(@NotNull Function<Tuple3<T1, T2, T3>, Vector<R>> mapper)
	{
		return mapper.apply(this);
	}
	
	
	@Override
	public String toString()
	{
		final StringBuffer sb = new StringBuffer("{");
		sb.append("t1: ").append((null != t1) ? t1 : "null");
		sb.append(", t2: ").append((null != t2) ? t2 : "null");
		sb.append(", t3: ").append((null != t3) ? t3 : "null");
		sb.append('}');
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
		
		if (t1 != null ? !t1.equals(tuple3.t1) : tuple3.t1 != null) return false;
		if (t2 != null ? !t2.equals(tuple3.t2) : tuple3.t2 != null) return false;
		return t3 != null ? t3.equals(tuple3.t3) : tuple3.t3 == null;
	}
	
	@Override
	public int hashCode()
	{
		int result = t1 != null ? t1.hashCode() : 0;
		result = 31 * result + (t2 != null ? t2.hashCode() : 0);
		result = 31 * result + (t3 != null ? t3.hashCode() : 0);
		return result;
	}
}
