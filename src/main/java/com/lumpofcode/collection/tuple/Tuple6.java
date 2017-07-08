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
public final class Tuple6<T1, T2, T3, T4, T5, T6>
{
	public final T1 t1;
	public final T2 t2;
	public final T3 t3;
	public final T4 t4;
	public final T5 t5;
	public final T6 t6;

	/**
	 * Complete constructor
	 *
	 * @param t1
	 * @param t2
	 * @param t3
	 * @param t4
	 * @param t5
	 * @param t6
	 */
	@JsonCreator
	public Tuple6(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3, @JsonProperty("t4") T4 t4, @JsonProperty("t5") T5 t5, @JsonProperty("t6") T6 t6)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
	}

	public int size() { return 6; }

	public T1 _1() { return this.t1; }
	public T2 _2() { return this.t2; }
	public T3 _3() { return this.t3; }
	public T4 _4() { return this.t4; }
	public T5 _5() { return this.t5; }
	public T6 _6() { return this.t6; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNullable Function<? super Tuple6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6>, ? extends R> mapper)
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
	 * @param mapper5 mapper for element 5
	 * @param mapper6 mapper for element 6
	 * @param <R1> resulting type of element 1
	 * @param <R2> resulting type of element 2
	 * @param <R3> resulting type of element 3
	 * @param <R4> resulting type of element 4
	 * @param <R5> resulting type of element 5
	 * @param <R6> resulting type of element 6
	 * @return new Tuple with mapped elements
	 */
	public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> map(
		@NotNullable Function<? super T1, ? extends R1> mapper1, 
		@NotNullable Function<? super T2, ? extends R2> mapper2, 
		@NotNullable Function<? super T3, ? extends R3> mapper3, 
		@NotNullable Function<? super T4, ? extends R4> mapper4, 
		@NotNullable Function<? super T5, ? extends R5> mapper5, 
		@NotNullable Function<? super T6, ? extends R6> mapper6)
	{
		return new Tuple6(mapper1.apply(t1), mapper2.apply(t2), mapper3.apply(t3), mapper4.apply(t4), mapper5.apply(t5), mapper6.apply(t6));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("{");
		sb.append("t1: ").append((null != t1) ? t1 : "null");
		sb.append(", t2: ").append((null != t2) ? t2 : "null");
		sb.append(", t3: ").append((null != t3) ? t3 : "null");
		sb.append(", t4: ").append((null != t4) ? t4 : "null");
		sb.append(", t5: ").append((null != t5) ? t5 : "null");
		sb.append(", t6: ").append((null != t6) ? t6 : "null");
		sb.append('}');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple6<?,?,?,?,?,?> tuple6 = (Tuple6<?,?,?,?,?,?>) that;

		if (t1 != null ? !t1.equals(tuple6.t1) : tuple6.t1 != null) return false;
		if (t2 != null ? !t2.equals(tuple6.t2) : tuple6.t2 != null) return false;
		if (t3 != null ? !t3.equals(tuple6.t3) : tuple6.t3 != null) return false;
		if (t4 != null ? !t4.equals(tuple6.t4) : tuple6.t4 != null) return false;
		if (t5 != null ? !t5.equals(tuple6.t5) : tuple6.t5 != null) return false;
		if (t6 != null ? !t6.equals(tuple6.t6) : tuple6.t6 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = t1 != null ? t1.hashCode() : 0;
		result = 31 * result + (t2 != null ? t2.hashCode() : 0);
		result = 31 * result + (t3 != null ? t3.hashCode() : 0);
		result = 31 * result + (t4 != null ? t4.hashCode() : 0);
		result = 31 * result + (t5 != null ? t5.hashCode() : 0);
		result = 31 * result + (t6 != null ? t6.hashCode() : 0);
		return result;
	}

}

