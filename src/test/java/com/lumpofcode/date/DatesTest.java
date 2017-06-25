package com.lumpofcode.date;

import com.lumpofcode.date.Dates;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by emurphy on 6/12/17.
 */
public class DatesTest
{
	@Test
	public void leapYearTest()
	{
		assertTrue(Dates.isLeapYear(1996));
		assertTrue(Dates.isLeapYear(2000));
		assertTrue(Dates.isLeapYear(2004));
		
		assertFalse(Dates.isLeapYear(1900));
		assertFalse(Dates.isLeapYear(1977));
		assertFalse(Dates.isLeapYear(2100));
	}
}
