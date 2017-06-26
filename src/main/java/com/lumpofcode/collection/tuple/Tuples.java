package com.lumpofcode.collection.tuple;

/**
 * Created by emurphy on 6/25/17.
 */
public final class Tuples
{
	private Tuples() { throw new RuntimeException(); }
	
	/**
	 * Factory to create a Tuple with 2 elements.
	 *
	 * @param t1 first element
	 * @param t2 second element
	 * @param <T1> type of first element
	 * @param <T2> type of second element
	 * @return Tuple with 2 elements
	 */
	public static <T1, T2> Tuple2<T1, T2> asTuple(final T1 t1, final T2 t2)
	{
		return new Tuple2<T1, T2>(t1, t2);
	}
	
	/**
	 * Factory to create a Tuple with 3 elements.
	 *
	 * @param t1 first element
	 * @param t2 second element
	 * @param t3 third element
	 * @param <T1> type of first element
	 * @param <T2> type of second element
	 * @param <T3> type of third element
	 * @return Tuple with 3 elements
	 */
	public static <T1, T2, T3> Tuple3<T1, T2, T3> asTuple(final T1 t1, final T2 t2, final T3 t3)
	{
		return new Tuple3<T1, T2, T3>(t1, t2, t3);
	}
	
}
