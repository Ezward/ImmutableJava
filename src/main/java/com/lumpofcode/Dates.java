package com.lumpofcode;

/**
 * Created by emurphy on 6/9/17.
 */
public final class Dates
{
	private Dates() { throw new RuntimeException(); }
	
	/**
	 * Determine if the year is a leap year.
	 *
	 * @param year
	 * @return true if year is leap year, false if not.
	 */
	public static final boolean isLeapYear(final int year)
	{
		if(0 != (year % 4 )) return false;
		if(0 != (year % 100)) return true;
		if(0 != (year % 400)) return false;
		return true;
	}
	
	/**
	 * Determine the number of days in the month
	 *
	 * @param year
	 * @param month 1..12
	 * @return the number of days in the month
	 * @throws IllegalArgumentException if month is out of range
	 */
	public static final int daysInMonth(final int year, final int month)
	{
		if((month < 1) || (month > 12)) throw new IllegalArgumentException();
		
		switch(month)
		{
			// Feb has 28 or 29 in leap years
			case 2: return isLeapYear(year) ? 29 : 28;

			// 30 days hath Sep, Apr, Jun and Nov
			case 4:
			case 6:
			case 9:
			case 11: return 30;
			
			// all the rest have 31
			default: return 31;
		}
	}
	
	/**
	 * Validate a date.
	 * @param year
	 * @param month 1..12
	 * @param day day of month 1..daysInMonth
	 * @return  true if valid, false if not.
	 */
	public static final boolean isDateValid(final int year, final int month, final int day)
	{
		// we don't validate the year
		if((month < 1) || (month > 12)) return false;
		if((day < 1) || (day > daysInMonth(year, month))) return false;
		
		return true;
	}
}
