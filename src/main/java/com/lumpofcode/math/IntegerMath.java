package com.lumpofcode.math;

/**
 * Created by emurphy on 6/17/17.
 */
public final class IntegerMath
{
	private IntegerMath() { throw new RuntimeException(); }
	
	public static final int power(final int value, final int exponent)
	{
		if(exponent < 0) throw new IllegalArgumentException();
		if(0 == exponent) return 1;
		
		int v = value;
		for(int i = 1; i < exponent; i += 1)
		{
			v *= value;
		}
		return v;
	}
	
}
