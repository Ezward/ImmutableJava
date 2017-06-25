package com.lumpofcode.date;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lumpofcode.annotation.Immutable;
import com.lumpofcode.lazy.Once;

/**
 * Effectively immutable year/month/day class.
 *
 * This is only 'effectively' immutable because
 * we do a lazy calculation within toString()
 * and cache the result in a mutable field to
 * avoid the calculation in the future calls.
 *
 * Created by emurphy on 6/9/17.
 */
@Immutable
public final class DateOfBirth
{
	private final int year;
	private final int month;  // 1..12
	private final int day;    // 1..31
	
	// depending on how Jackson is configured, you may want this marked @JsonIgnore
	private final Once<String> string = new Once<String>();
	
	/**
	 * Complete constructor takes values for all properties.
	 *
	 * This is annotated so that Jackson can use the constructor
	 * when deserializing.  See Person and PersonBuilder for an
	 * example of how to use the builder pattern to avoid excessive
	 * annotations in the pojo.
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @throws IllegalStateException is date is not valid
	 */
	@JsonCreator
	public DateOfBirth(@JsonProperty("year") final int year, @JsonProperty("month") final int month, @JsonProperty("day") final int day)
	{
		if(!Dates.isDateValid(year, month, day)) throw new IllegalStateException("invalid date");
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * NOTE: getters are java bean compliant.
	 *
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	/**
	 * format the value as a String.
	 *
	 * NOTE: in this case, the calculation is expensive, so
	 *       the result is cached in a Once.
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		//
		// Even though there is technically a race condition here,
		// the result always calculates and sets same value (since the instance is immutable).
		// We may very rarely make more than one call to string.set() in
		// a multi-threaded execution environment, but the resulting values are the same
		// (the call to string.set() is effectively idempotent).
		//
		if(!string.isSet())
		{
			string.set("{\"year\":{year},\"month\":{month},\"day\":{day}}"
				.replace("{year}", String.valueOf(year))
				.replace("{month}", String.valueOf(month))
				.replace("{day}", String.valueOf(day)));
		}
		return string.get();
	}
	
	/**
	 * Calculate the hash code.
	 *
	 * NOTE: in this case, the calculation is not expensive, so we don't cache it in a Once.
	 *
	 * @return unique hash code for the date
	 */
	@Override
	public int hashCode()
	{
		int result = year;
		result = 31 * result + month;
		result = 31 * result + day;
		return result;
	}
	
	@Override
	public boolean equals(final Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		final DateOfBirth that = (DateOfBirth) o;
		
		if (year != that.year) return false;
		if (month != that.month) return false;
		return day == that.day;
	}
}
