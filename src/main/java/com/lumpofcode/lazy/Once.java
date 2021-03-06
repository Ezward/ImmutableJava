package com.lumpofcode.lazy;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A nullable value that can be set only once.
 *
 * ThreadSafe
 *
 * Created by emurphy on 6/10/17.
 */
public final class Once<T>
{
	private AtomicReference<Optional<T>> value = new AtomicReference<>();
	
	/**
	 * Attempt to set the value.
	 *
	 * This is safe to call more than once, but only the
	 * first call actually sets the value. Subsequent calls
	 * simply return the first set value.
	 *
	 * @param value value to set, may be null
	 * @return the value, which may differ from what was passed
	 *         if the value had been previously set.
	 */
	public T set(final T value)
	{
		this.value.compareAndSet(null, Optional.ofNullable(value));  // set the value if the current value is null
		return this.value.get().orElse(null);   // use orElse to allow null to be returned
	}
	
	/**
	 * Determine if the value is set.
	 *
	 * NOTE: set() will arbitrate multiple setters and return the first set value, so
	 *       constructs like if(!once.isSet()) once.set(myValue) create a race condition and
	 *       are generally not necessary provided that you are always setting the same value
	 *       or are happy to use whatever value was set.
	 *       If you wish to determine if your value was set, then you might try this
	 *         if(!myValue.equals(once.set(myValue))) { System.out.println("someone already set a different value"); }
	 *
	 * @return true if the value was already set, false if not
	 */
	public boolean isSet()
	{
		return null != this.value.get();
	}
	
	/**
	 * Attempt to get the value.
	 * If the value is not yet set, then this is an error.
	 *
	 * @return the set value
	 * @throws NoSuchElementException if the value has not been set.
	 */
	public T get()
	{
		if(!isSet()) throw new NoSuchElementException("Illegal attempt to access uninitialized Once value.");
		return this.value.get().orElse(null);
	}
}
