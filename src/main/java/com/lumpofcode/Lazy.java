package com.lumpofcode;

import java.util.function.Supplier;

/**
 * Lazy calculated value.
 *
 * Created by emurphy on 6/12/17.
 */
public final class Lazy<T>
{
	private final Supplier<T> supplier;
	private final Once<T> value = new Once<>();
	
	/**
	 * Construct a value that will be lazily initialized the
	 * first time the getter is called.
	 *
	 * NOTE: it is possible in a multi-threaded environment
	 *       that the supplier may be called more then once.
	 *       Ideally, it should return the same value no
	 *       matter how many times it is called.  In practice,
	 *       the value provided by the first call will be
	 *       the value that is set to the lazy value.
	 *
	 * @param supplier the function that supplies the value.
	 */
	public Lazy(final Supplier<T> supplier)
	{
		if(null == supplier) throw new IllegalArgumentException("Illegal attempt to construct Lazy with a null supplier");
		this.supplier = supplier;
	}
	
	/**
	 * Get the value.  The first time this is called,
	 * the will be called to supply the value.
	 *
	 * @returns the value (which may be null)
	 */
	public T get()
	{
		if(!this.value.isSet())
		{
			this.value.set(this.supplier.get());
		}
		return this.value.get();
	}
}
