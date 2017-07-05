package com.lumpofcode.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple builder to generate code source files.
 *
 * Created by emurphy on 7/2/17.
 */
public class SourceBuilder
{
	private final Writer builder;
	private int blockFrame = 0; // for balancing block open and close
	private int listFrame = 0;  // for balancing list open and close
	private final Map<String, String> values = new HashMap<>();
	
	/**
	 * Construct with given Writer
	 *
	 * @param builder Writer that will get the text
	 */
	public SourceBuilder(final Writer builder)
	{
		this.builder = builder;
	}
	
	//
	// emit arbitrary text
	//
	public SourceBuilder emit(final String string)
	{
		try
		{
			builder.write(string);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		
		return this;
	}
	public SourceBuilder emit(final char c)
	{
		try
		{
			builder.write(c);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		
		return this;
	}
	
	//
	// line with proper indentation and new line at end
	//
	public SourceBuilder line(final String string)
	{
		return indent().emit(string).eol();
	}
	
	//
	// indent based on current block
	//
	public SourceBuilder indent()
	{
		return tabs(blockFrame);
	}
	public SourceBuilder indent(final String string)
	{
		return indent().emit(string);
	}
	
	//
	// end of line
	//
	public SourceBuilder eol()
	{
		return emit('\n');
	}
	public SourceBuilder eol(final String string)
	{
		return emit(string).eol();
	}
	
	//
	// arbitrary tabs
	//
	public SourceBuilder tab()
	{
		return emit('\t');
	}
	public SourceBuilder tabs(final int count)
	{
		for(int i = 0; i < count; i += 1)
		{
			emit('\t');
		}
		
		return this;
	}
	
	//
	// {} block
	//
	public SourceBuilder block(final String string)
	{
		return line(string).block();
	}
	public SourceBuilder block()
	{
		line("{");
		blockFrame += 1;
		return this;
	}
	
	public SourceBuilder endBlock()
	{
		return endBlock(true);
	}
	public SourceBuilder endBlock(final boolean extraEndLine)
	{
		if(blockFrame <= 0) throw new IllegalStateException();
		blockFrame -= 1;
		return extraEndLine ? line("}").eol() : line("}");
	}
	
	//
	// argument list
	//
	public SourceBuilder args()
	{
		return list("(");
	}
	public SourceBuilder args(final String prepend)
	{
		return emit(prepend).list("(");
	}
	public SourceBuilder arg(final int argNumber, final String arg)
	{
		return item(argNumber, arg, ", ");
	}
	public SourceBuilder endArgs()
	{
		return endList(")");
	}
	public SourceBuilder endArgs(final String append)
	{
		return endList(")").emit(append);
	}
	
	//
	// general list.  Allows custom brackets and delimiters
	//
	public SourceBuilder list()
	{
		return list("");
	}
	public SourceBuilder list(final String openBracket)
	{
		listFrame += 1;
		return ((null != openBracket) && !openBracket.isEmpty()) ? emit(openBracket) : this;
	}
	public SourceBuilder item(final int argNumber, final String arg, final String delimiter)
	{
		// if arg count > 0, then prepend with a comma
		if(argNumber > 0)
		{
			emit(delimiter);
		}
		return emit(arg);
	}
	public SourceBuilder endList()
	{
		return endList("");
	}
	public SourceBuilder endList(final String closeBracket)
	{
		if(listFrame <= 0) throw new IllegalStateException();  // more endArgs than startArgs!
		if((null != closeBracket) && !closeBracket.isEmpty()) emit(closeBracket);
		listFrame -= 1;
		return this;
	}
}
