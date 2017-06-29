
package com.lumpofcode.collection.vector;

import java.io.IOException;
import java.io.Writer;

/**
 * Class to generate java source file for a Vector class of a given size.
 */
public final class VectorTemplate
{
	/**
	 * Generate java source for a vector class of a given size.
	 * This will write to the given writer.
	 *
	 * To create a string, supply a new StringWriter(),
	 * the when generate finishes, get the string from
	 * the writer.
	 *
	 * @param writer a Writer that gets the vector source.
	 * @param size the size of the vector 1..Vectors.VECTOR_NODE_SIZE
	 */
	public void generate(final Writer writer, final int size)
	{
		final VectorBuilder build = new VectorBuilder(writer);
		
		//
		// package and imports
		//
		build.line("package com.lumpofcode.collection.vector;").endLine();
		build.line("import java.util.Iterator;").endLine();
		
		//
		// class definition
		//
		build.line("public final class VectorOf{{size}}<T> implements Vector<T>, Iterable<T>".replace("{{size}}", String.valueOf(size)));
		build.beginBlock();
		{
			//
			// private properties for each element
			//
			for (int i = 0; i < size; i += 1)
			{
				build.line("private final T element{{i}};".replace("{{i}}", String.valueOf(i)));
			}
			build.endLine();
			
			//
			// constructor
			//
			build.startLine("public VectorOf{{size}}".replace("{{size}}", String.valueOf(size)));
			build.startArgs();
			if (size > 0)
			{
				for (int i = 0; i < size - 1; i += 1)
				{
					build.arg(i, "T element{{i}}".replace("{{i}}", String.valueOf(i)));
				}
				build.arg(size - 1, "T element{{size-1}}".replace("{{size-1}}", String.valueOf(size - 1)));
			}
			build.endArgs();
			build.endLine();
			
			// constructor body; assign each argument to corresponding property
			build.beginBlock();
			{
				for (int i = 0; i < size; i += 1)
				{
					build.line("this.element{{i}} = element{{i}};".replace("{{i}}", String.valueOf(i)));
				}
			}
			build.endBlock();
			
			//
			// size() method
			//
			build.line("public int size() { return {{size}}; }".replace("{{size}}", String.valueOf(size))).endLine();
			
			//
			// get() method
			//
			build.beginBlock("public T get(int index)");
			{
				build.beginBlock("switch(index)");
				{
					for (int i = 0; i < size; i += 1)
					{
						build.line("case {{i}}: return element{{i}};".replace("{{i}}", String.valueOf(i)));
					}
					build.endBlock();
				}
				build.line("throw new IndexOutOfBoundsException();");
			}
			build.endBlock();
			
			//
			// set() method
			//
			build.beginBlock("public Vector<T> set(int index, T value)");
			{
				build.beginBlock("switch(index)");
				{
					for (int i = 0; i < size; i += 1)
					{
						build.startLine("case {{i}}: return new VectorOf{{size}}".replace("{{i}}", String.valueOf(i)).replace("{{size}}", String.valueOf(size)));
						build.startArgs();
						if (size > 0)
						{
							// use current values except for the index we are setting
							build.arg(0, (0 == i) ? "value" : "element0");
							for (int j = 1; j < size; j += 1)
							{
								build.arg(j, (i == j) ? "value" : "element{{j}}".replace("{{j}}", String.valueOf(j)));
							}
						}
						build.endArgs().endLine(";");
					}
					build.line("case {{size}}: return push(value);".replace("{{size}}", String.valueOf(size)));
				}
				build.endBlock();
				
				build.line("throw new IndexOutOfBoundsException();");
			}
			build.endBlock();
			
			//
			// push() method
			//
			build.beginBlock("public Vector<T> push(T value)");
			{
				if (size < Vectors.VECTOR_NODE_SIZE)
				{
					build.startLine("return new VectorOf{{size+1}}".replace("{{size+1}}", String.valueOf(size + 1)));
					build.startArgs();
					for (int i = 0; i < size; i += 1)
					{
						build.arg(i, "element{{i}}".replace("{{i}}", String.valueOf(i)));
					}
					build.arg(size, "value");
					build.endArgs().endLine(";");
				}
				else
				{
					build.line("return new VectorTrie(1, this, new VectorOf1(value));");
				}
			}
			build.endBlock();
			
			//
			// pushAll() method
			//
			build.line("public Vector<T> pushAll(final Vector<T> vector)");
			build.beginBlock();
			{
				build.line("Vector<T> result = this;");
				build.line("for(T element : vector)");
				build.beginBlock();
				{
					build.line("result = result.push(element);");
				}
				build.endBlock();
				build.line("return result;");
			}
			build.endBlock();
			
			//
			// map() method
			//
			build.line("public <R> Vector<R> map(Function<? super T, ? extends R> mapper)");
			build.beginBlock();
			{
				build.startLine("return new VectorOf{{size}}".replace("{{size}}", String.valueOf(size)));
				build.startArgs();
				for (int i = 0; i < size; i += 1)
				{
					build.arg(i, "mapper.apply(element{{i}})".replace("{{i}}", String.valueOf(i)));
				}
				build.endArgs();
				build.endLine(";");
			}
			build.endBlock();
			
			//
			// flatmap() method
			//
			build.line("public <R> Vector<R> flatmap(Function<T, Vector<R>> mapper)");
			build.beginBlock();
			{
				build.line("Vector<R> result = mapper.apply(element0);");
				for (int i = 1; i < size; i += 1)
				{
					build.line("result = result.pushAll(mapper.apply(element{{i}}));".replace("{{i}}", String.valueOf(i)));
				}
				build.line("return result;");
			}
			build.endBlock();
			
			
			//
			// toString() method
			//
			build.beginBlock("public String toString()");
			{
				build.startLine("return ").openList("\"[\" + ");
				if (size > 0)
				{
					for (int i = 0; i < size - 1; i += 1)
					{
						build.item(i, "element{{i}}.toString() + ".replace("{{i}}", String.valueOf(i)), "\", \" + ");
					}
					build.item(size - 1, "element{{size-1}}.toString() + ".replace("{{size-1}}", String.valueOf(size - 1)), "\", \" + ");
				}
				build.closeList("\"]\"").endLine(";\n");
			}
			build.endBlock();
			
			
			//
			// iterator() method
			//
			build.line("public Iterator<T> iterator() { return new VectorIterator<T>(this); }");
			
			
			//
			// close class
			//
		}
		build.endBlock();
	}
	
	
	private static class VectorBuilder
	{
		private final Writer builder;
		private int blockFrame = 0; // for balancing block open and close
		private int listFrame = 0;  // for balancing list open and close
		
		/**
		 * Construct with given builders (allows appending or prepending)
		 *
		 * @param builder
		 */
		public VectorBuilder(final Writer builder)
		{
			this.builder = builder;
		}
		
		//
		// emit arbitrary text
		//
		public VectorBuilder emit(final String string)
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
		public VectorBuilder emit(final char c)
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
		public VectorBuilder line(final String string)
		{
			return startLine().emit(string).endLine();
		}
		
		private VectorBuilder startLine()
		{
			return tabs(blockFrame);
		}
		private VectorBuilder startLine(final String string)
		{
			return startLine().emit(string);
		}
		
		public VectorBuilder endLine()
		{
			return emit('\n');
		}
		public VectorBuilder endLine(final String string)
		{
			return emit(string).endLine();
		}
		
		//
		// arbitrary tabs
		//
		public VectorBuilder tab()
		{
			return emit('\t');
		}
		
		public VectorBuilder tabs(final int count)
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
		public VectorBuilder beginBlock(final String string)
		{
			return line(string).beginBlock();
		}
		public VectorBuilder beginBlock()
		{
			line("{");
			blockFrame += 1;
			return this;
		}
		
		public VectorBuilder endBlock()
		{
			if(blockFrame <= 0) throw new IllegalStateException();
			blockFrame -= 1;
			return line("}").endLine();
		}
		
		//
		// argument list
		//
		public VectorBuilder startArgs()
		{
			return openList("(");
		}
		public VectorBuilder arg(final int argNumber, final String arg)
		{
			return item(argNumber, arg, ", ");
		}
		public VectorBuilder endArgs()
		{
			return closeList(")");
		}
		
		//
		// bracketed, delimited list
		//
		public VectorBuilder openList(final String openBracket)
		{
			listFrame += 1;
			return ((null != openBracket) && !openBracket.isEmpty()) ? emit(openBracket) : this;
		}
		public VectorBuilder item(final int argNumber, final String arg, final String delimiter)
		{
			// if arg count > 0, then prepend with a comma
			if(argNumber > 0)
			{
				emit(delimiter);
			}
			return emit(arg);
		}
		public VectorBuilder closeList(final String closeBracket)
		{
			if(listFrame <= 0) throw new IllegalStateException();  // more endArgs than startArgs!
			if((null != closeBracket) && !closeBracket.isEmpty()) emit(closeBracket);
			listFrame -= 1;
			return this;
		}
		
	}
	
	
	
}
