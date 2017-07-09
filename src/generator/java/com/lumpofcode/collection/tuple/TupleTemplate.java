package com.lumpofcode.collection.tuple;

import com.lumpofcode.generator.Macros;
import com.lumpofcode.generator.SourceBuilder;

import java.io.Writer;

/**
 * Created by emurphy on 7/6/17.
 */
public class TupleTemplate
{
	public void generateTupleOfNN(final Writer writer, final int size, final boolean useJson)
	{
		if(size < 1) throw new IllegalArgumentException();
		
		final Macros m = new Macros();
		final SourceBuilder b = new SourceBuilder(writer, m);
		
		//
		// set up common symbols
		//
		b.with("size", size);
		b.with("size-1", size - 1);
		b.with("size+1", size + 1);
		
		b.line("package com.lumpofcode.collection.tuple;").eol();

		b.line("import com.fasterxml.jackson.annotation.JsonCreator;");
		b.line("import com.fasterxml.jackson.annotation.JsonProperty;").eol();
		b.line("import com.lumpofcode.annotation.NotNull;");
		
		b.line("import java.util.function.Function;").eol();
		
		//
		// class declaration with generic element types
		//
		b.line("/**");
		b.line(" * A finite ordered collection of elements with independent types.");
		b.line(" *");
		b.line(" * Created by emurphy on 6/25/17.");
		b.line(" */");
		b.indent("public final class Tuple{{size}}").list("<");
		for(int i = 1; i <= size; i += 1)
		{
			b.with("i", i).item(i-1, "T{{i}}", ", ");
		}
		b.endList(">").eol();
		b.block();
		{
			//
			// public final element properties
			//
			for (int i = 1; i <= size; i += 1)
			{
				b.with("i", i).line("public final T{{i}} _{{i}};");
			}
			b.eol();
			
			//
			// complete constructor, optionally annotated for Jackson json mapper
			//
			b.line("/**");
			b.line(" * Complete constructor");
			b.line(" *");
			for (int i = 1; i <= size; i += 1)
			{
				b.with("i", i).line(" * @param t{{i}} component {{i}} of type T{{i}}");
			}
			b.line(" */");
			if (useJson) b.line("@JsonCreator");
			b.indent("public Tuple{{size}}").args();
			for (int i = 1; i <= size; i += 1)
			{
				//
				// if using json, then format the annotation to put in front of the argument, otherwise leave it blank
				//
				b.with("i", i);
				b.with("json", useJson ? m.apply("@JsonProperty(\"t{{i}}\") ") : "");
				
				b.arg(i - 1, "{{json}}T{{i}} t{{i}}");
			}
			b.endArgs().eol();
			b.block();
			{
				//
				// assign properties
				//
				for (int i = 1; i <= size; i += 1)
				{
					b.with("i", i).line("_{{i}} = t{{i}};");
				}
			}
			b.endBlock();
			
			//
			/// size() method
			//
			b.line("public int size() { return {{size}}; }").eol();
			
			//
			// getters
			//
			for (int i = 1; i <= size; i += 1)
			{
				b.with("i", i);
				b.line("/**");
				b.line(" * get component {{i}}");
				b.line(" *");
				b.line(" * @return value of component {{i}}");
				b.line(" */");
				b.line("public T{{i}} _{{i}}() { return _{{i}}; }").eol();
			}
		
			
			//
			// map() method with single mapper
			//
			b.line("/**");
			b.line(" * Map a Tuple3 to a value of type R given a mapper function.");
			b.line(" *");
			b.line(" * @param mapper function to map Tuple3 to an R value");
			b.line(" * @param <R> result type");
			b.line(" * @return a value of type R");
			b.line(" */");
			b.indent("public <R> R map(@NotNull Function<? super Tuple{{size}}");
			b.list("<");
			for(int i = 1; i <= size; i += 1)
			{
				b.with("i", i).item(i-1, "? super T{{i}}", ", ");
			}
			b.endList(">").emit(", ? extends R> mapper)").eol();
			b.block();
			{
				b.line("return mapper.apply(this);");
			}
			b.endBlock();
			
			//
			// mapTuple() method with mapper per component
			//
			b.line("/**");
			b.line(" * Map a Tuple to another Tuple with a mapper function per component.");
			b.line(" *");
			for(int i = 1; i <= size; i += 1)
			{
				b.with("i", i).line(" * @param mapper{{i}} mapper for component {{i}}");
			}
			for(int i = 1; i <= size; i += 1)
			{
				b.with("i", i).line(" * @param <R{{i}}> resulting type of component {{i}}");
			}
			b.line(" * @return new Tuple with mapped components");
			b.line(" */");
			b.indent("public ").list("<");
			for(int i = 1; i <= size; i += 1)
			{
				b.with("i", i).item(i-1, "R{{i}}", ", ");
			}
			b.endList(">").emit(" Tuple{{size}}").list("<");
			for(int i = 1; i <= size; i += 1)
			{
				b.with("i", i).item(i-1, "R{{i}}", ", ");
			}
			b.endList(">").args(" mapTuple");
			for(int i = 1; i <= size; i += 1)
			{
				b.with("i", i).with("tabs", "\n\t\t").arg(i-1, "{{tabs}}@NotNull Function<? super T{{i}}, ? extends R{{i}}> mapper{{i}}");
			}
			b.endArgs().eol();
			b.block();
			{
				b.indent("return new Tuple{{size}}").args();
				for(int i = 1; i <= size; i += 1)
				{
					b.with("i", i).arg(i-1, "mapper{{i}}.apply(_{{i}})");
				}
				b.endArgs().eol(";");
			}
			b.endBlock();
			
			//
			// family of map_NN to create a new Tuple by mapping a single component
			//
			for(int j = 1; j <= size; j += 1)
			{
				b.with("j", j);
				b.line("/**");
				b.line(" * Create a new Tuple by mapping component {{j}}");
				b.line(" *");
				b.line(" * @param mapper{{j}} mapper for component {{j}}");
				b.line(" * @param <R{{j}}> result type for component {{j}}");
				b.line(" * @return a new Tuple with component {{j}} mapped");
				b.line(" */");
				b.indent().list("public <R{{j}}> Tuple{{size}}<");
				for(int i = 1; i <= size; i += 1)
				{
					b.with("i", i).item(i - 1, (i == j) ? "R{{j}}" : "T{{i}}", ", ");
				}
				b.endList(">").emit(" map_{{j}} (@NotNull Function <? super T{{j}}, ? extends R{{j}}> mapper{{j}})").eol();
				b.block();
				{
					b.indent("return new Tuple{{size}}").args();
					for(int i = 1; i <= size; i += 1)
					{
						b.with("i", i).arg(i - 1, (i == j) ? "mapper{{j}}.apply(_{{j}})" : "_{{i}}");
					}
					b.endArgs().eol(";");
				}
				b.endBlock();
			}
			
			//
			// toString() method
			//
			b.line("public String toString()");
			b.block();
			{
				b.line("final StringBuffer sb = new StringBuffer(\"(\");");
				for(int i = 1; i <= size; i += 1)
				{
					b.with("i", i).with("sep", (1 == i) ? "" : ", ");
					b.line("sb.append((null != _{{i}}) ? _{{i}} : \"null\");");
				}
				b.line("sb.append(')');").eol();
				b.line("return sb.toString();");
			}
			b.endBlock();
			
			//
			// equals() method
			//
			b.line("public boolean equals(Object that)");
			b.block();
			{
				b.line("if (this == that) return true;");
				b.line("if (that == null || getClass() != that.getClass()) return false;").eol();
				
				b.indent("Tuple{{size}}").list("<");
				for(int i = 1; i <= size; i += 1) b.item(i-1, "?", ",");
				b.endList(">").emit(" tuple{{size}} = (Tuple{{size}}").list("<");
				for(int i = 1; i <= size; i += 1) b.item(i-1, "?", ",");
				b.endList(">").eol(") that;").eol();
				
				for(int i = 1; i <= size; i += 1)
				{
					b.with("i", i);
					b.line("if (_{{i}} != null ? !_{{i}}.equals(tuple{{size}}._{{i}}) : tuple{{size}}._{{i}} != null) return false;");
				}
				b.eol();
				
				
				b.line("return true;");
			}
			b.endBlock();
			
			//
			// hashcode() method
			//
			b.line("public int hashCode()");
			b.block();
			{
				b.line("int result = _1 != null ? _1.hashCode() : 0;");
				for(int i = 2; i <= size; i += 1)
				{
					b.with("i", i).line("result = 31 * result + (_{{i}} != null ? _{{i}}.hashCode() : 0);");
				}
				b.line("return result;");
			}
			b.endBlock();
			
			
		}
		b.endBlock();   // end of class TupleNN
		
		
		
	}
}
