package com.lumpofcode.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * simplistic symbol table for macro processing
 */
public final class Macros
{
	private final Map<String, String> symbols = new HashMap<>();
	
	public Macros with(final String symbol, final String value)
	{
		symbols.put(symbol, value);
		return this;
	}
	public Macros with(final String symbol, final int value)
	{
		return with(symbol, String.valueOf(value));
	}
	public Macros unset(final String symbol)
	{
		symbols.remove(symbol);
		return this;
	}
	
	public String apply(final String string)
	{
		String fixed = string;
		for(String symbol : symbols.keySet())
		{
			fixed = fixed.replace("{{" + symbol + "}}", symbols.get(symbol));
		}
		return fixed;
	}
}
