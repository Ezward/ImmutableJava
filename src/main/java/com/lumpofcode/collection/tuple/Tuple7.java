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
	 * @param t1
	 * @param t2
	 * @param t3
	 * @param t4
	 * @param t5
	 * @param t6
	 * @param t7
	 */
	@JsonCreator
	public Tuple7(@JsonProperty("t1") T1 t1, @JsonProperty("t2") T2 t2, @JsonProperty("t3") T3 t3, @JsonProperty("t4") T4 t4, @JsonProperty("t5") T5 t5, @JsonProperty("t6") T6 t6, @JsonProperty("t7") T7 t7)
	{
		this._1 = t1;
		this._2 = t2;
		this._3 = t3;
		this._4 = t4;
		this._5 = t5;
		this._6 = t6;
		this._7 = t7;
	}

	public int size() { return 7; }

	public T1 _1() { return this._1; }
	public T2 _2() { return this._2; }
	public T3 _3() { return this._3; }
	public T4 _4() { return this._4; }
	public T5 _5() { return this._5; }
	public T6 _6() { return this._6; }
	public T7 _7() { return this._7; }

	/**
	 * Map a Tuple3 to a value of type R given a mapper function.
	 *
	 * @param mapper function to map Tuple3 to an R value
	 * @param <R> result type
	 * @return a value of type R
	 */
	public <R> R map(@NotNullable Function<? super Tuple7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7>, ? extends R> mapper)
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
	 * @param mapper7 mapper for element 7
	 * @param <R1> resulting type of element 1
	 * @param <R2> resulting type of element 2
	 * @param <R3> resulting type of element 3
	 * @param <R4> resulting type of element 4
	 * @param <R5> resulting type of element 5
	 * @param <R6> resulting type of element 6
	 * @param <R7> resulting type of element 7
	 * @return new Tuple with mapped elements
	 */
	public <R1, R2, R3, R4, R5, R6, R7> Tuple7<R1, R2, R3, R4, R5, R6, R7> map(
		@NotNullable Function<? super T1, ? extends R1> mapper1, 
		@NotNullable Function<? super T2, ? extends R2> mapper2, 
		@NotNullable Function<? super T3, ? extends R3> mapper3, 
		@NotNullable Function<? super T4, ? extends R4> mapper4, 
		@NotNullable Function<? super T5, ? extends R5> mapper5, 
		@NotNullable Function<? super T6, ? extends R6> mapper6, 
		@NotNullable Function<? super T7, ? extends R7> mapper7)
	{
		return new Tuple7(mapper1.apply(this._1), mapper2.apply(this._2), mapper3.apply(this._3), mapper4.apply(this._4), mapper5.apply(this._5), mapper6.apply(this._6), mapper7.apply(this._7));
	}

	public String toString()
	{
		final StringBuffer sb = new StringBuffer("{");
		sb.append("this._1: ").append((null != this._1) ? this._1 : "null");
		sb.append(", this._2: ").append((null != this._2) ? this._2 : "null");
		sb.append(", this._3: ").append((null != this._3) ? this._3 : "null");
		sb.append(", this._4: ").append((null != this._4) ? this._4 : "null");
		sb.append(", this._5: ").append((null != this._5) ? this._5 : "null");
		sb.append(", this._6: ").append((null != this._6) ? this._6 : "null");
		sb.append(", this._7: ").append((null != this._7) ? this._7 : "null");
		sb.append('}');

		return sb.toString();
	}

	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (that == null || getClass() != that.getClass()) return false;

		Tuple7<?,?,?,?,?,?,?> tuple7 = (Tuple7<?,?,?,?,?,?,?>) that;

		if (this._1 != null ? !this._1.equals(tuple7._1) : tuple7._1 != null) return false;
		if (this._2 != null ? !this._2.equals(tuple7._2) : tuple7._2 != null) return false;
		if (this._3 != null ? !this._3.equals(tuple7._3) : tuple7._3 != null) return false;
		if (this._4 != null ? !this._4.equals(tuple7._4) : tuple7._4 != null) return false;
		if (this._5 != null ? !this._5.equals(tuple7._5) : tuple7._5 != null) return false;
		if (this._6 != null ? !this._6.equals(tuple7._6) : tuple7._6 != null) return false;
		if (this._7 != null ? !this._7.equals(tuple7._7) : tuple7._7 != null) return false;

		return true;
	}

	public int hashCode()
	{
		int result = this._1 != null ? this._1.hashCode() : 0;
		result = 31 * result + (this._2 != null ? this._2.hashCode() : 0);
		result = 31 * result + (this._3 != null ? this._3.hashCode() : 0);
		result = 31 * result + (this._4 != null ? this._4.hashCode() : 0);
		result = 31 * result + (this._5 != null ? this._5.hashCode() : 0);
		result = 31 * result + (this._6 != null ? this._6.hashCode() : 0);
		result = 31 * result + (this._7 != null ? this._7.hashCode() : 0);
		return result;
	}

}

