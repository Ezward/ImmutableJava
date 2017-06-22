
package com.lumpofcode.collection.vector;

import java.util.LinkedList;

public final class VectorTemplate
{
	public String generate(final int size)
	{
		final VectorBuilder builder = new VectorBuilder();
		
		
		builder.line("package com.lumpofcode.collection.vector;").endLine();
		builder.line("import java.util.Iterator;").endLine();
		
		//
		// class definition
		//
		builder.line("public final class VectorOf{{size}}<T> implements Vector<T>, Iterable<T>".replace("{{size}}", String.valueOf(size)));
		builder.beginBlock();
		
		//
		// private properties for each element
		//
		for(int i = 0; i < size; i += 1)
		{
			builder.line("private final T element{{i}};".replace("{{i}}", String.valueOf(i)));
		}
		builder.endLine();
			
		//
		// constructor
		//
		builder.startLine("public VectorOf{{size}}".replace("{{size}}", String.valueOf(size)));
		builder.startArgs();
		if(size > 0)
		{
			for (int i = 0; i < size - 1; i += 1)
			{
				builder.arg("T element{{i}}".replace("{{i}}", String.valueOf(i)));
			}
			builder.arg("T element{{size-1}}".replace("{{size-1}}", String.valueOf(size - 1)));
		}
		builder.endArgs();
		builder.endLine();
		
		// constructor body; assign each argument to corresponding property
		builder.beginBlock();
		for (int i = 0; i < size; i += 1)
		{
			builder.line("this.element{{i}} = element{{i}};".replace("{{i}}", String.valueOf(i)));
		}
		builder.endBlock();
			
		//
		// size() method
		//
		builder.line("public int size() { return {{size}}; }".replace("{{size}}", String.valueOf(size))).endLine();

		//
		// get() method
		//
		builder.beginBlock("public T get(int index)");
		builder.beginBlock("switch(index)");
		for(int i = 0; i < size; i += 1)
		{
			builder.line("case {{i}}: return element{{i}};".replace("{{i}}", String.valueOf(i)));
		}
		builder.endBlock();
		builder.line("throw new IndexOutOfBoundsException();");
		builder.endBlock();

		//
		// set() method
		//
		builder.beginBlock("public Vector<T> set(int index, T value)");
		builder.beginBlock("switch(index)");
		for(int i = 0; i < size; i += 1)
		{
			builder.startLine("case {{i}}: return new VectorOf{{size}}".replace("{{i}}", String.valueOf(i)).replace("{{size}}", String.valueOf(size)));
			builder.startArgs();
			if(size > 0)
			{
				// use current values except for the index we are setting
				builder.arg((0 == i) ? "value" : "element0");
				for (int j = 1; j < size; j += 1)
				{
					builder.arg((i == j) ? "value" : "element{{j}}".replace("{{j}}", String.valueOf(j)));
				}
			}
			builder.endArgs().endLine(";");
		}
		builder.line("case {{size}}: return push(value);".replace("{{size}}", String.valueOf(size)));
		builder.endBlock();
		
		builder.line("throw new IndexOutOfBoundsException();");
		builder.endBlock();
		
		//
		// push() method
		//
		builder.beginBlock("public Vector<T> push(T value)");
		if(size < Vectors.VECTOR_NODE_SIZE)
		{
			builder.startLine("return new VectorOf{{size+1}}".replace("{{size+1}}", String.valueOf(size + 1)));
			builder.startArgs();
			for(int i = 0; i < size; i += 1)
			{
				builder.arg("element{{i}}".replace("{{i}}", String.valueOf(i)));
			}
			builder.arg("value");
			builder.endArgs().endLine(";");
		}
		else
		{
			builder.line("return new VectorTrie(1, this, new VectorOf1(value));");
		}
		builder.endBlock();
		
		//
		// pushAll() method
		//
		builder.line("public Vector<T> pushAll(final Vector<T> vector)");
		builder.beginBlock();
		builder.line("Vector<T> result = this;");
		builder.line("for(T element : vector)");
		builder.beginBlock();
		builder.line("result = result.push(element);");
		builder.endBlock();
		builder.line("return result;");
		builder.endBlock();
		
		//
		// map() method
		//
		builder.line("public <R> Vector<R> map(Function<? super T, ? extends R> mapper)");
		builder.beginBlock();
		{
			builder.startLine("return new VectorOf{{size}}".replace("{{size}}", String.valueOf(size)));
			builder.startArgs();
			for (int i = 0; i < size; i += 1)
			{
				builder.arg("mapper.apply(element{{i}})".replace("{{i}}", String.valueOf(i)));
			}
			builder.endArgs();
			builder.endLine(";");
		}
		builder.endBlock();
		
		//
		// flatmap() method
		//
		builder.line("public <R> Vector<R> flatmap(Function<T, Vector<R>> mapper)");
		builder.beginBlock();
		{
			builder.line("Vector<R> result = mapper.apply(element0);");
			for(int i = 1; i < size; i += 1)
			{
				builder.line("result = result.pushAll(mapper.apply(element{{i}}));".replace("{{i}}", String.valueOf(i)));
			}
			builder.line("return result;");
		}
		builder.endBlock();
		
		
		//
		// toString() method
		//
		builder.beginBlock("public String toString()");
		builder.startLine("return \"[\" + ");
		if(size > 0)
		{
			for (int i = 0; i < size - 1; i += 1)
			{
				builder.emit("element{{i}}.toString() + \", \" + ".replace("{{i}}", String.valueOf(i)));
			}
			builder.emit("element{{size-1}}.toString() + ".replace("{{size-1}}", String.valueOf(size - 1)));
		}
		builder.endLine("\"]\";\n");
		builder.endBlock();
		

		//
		// iterator() method
		//
		builder.line("public Iterator<T> iterator() { return new VectorIterator<T>(this); }");
		
		
		//
		// close class
		//
		builder.endBlock();
		
		return builder.toString();
		
	}
	
	
	private static class VectorBuilder
	{
		private final StringBuilder builder;
		
		private int blockCount = 0;
		private LinkedList<Integer> argFrame = new LinkedList<>();
		
		public VectorBuilder(final StringBuilder builder)
		{
			this.builder = builder;
		}
		public VectorBuilder()
		{
			this(new StringBuilder());
		}
		
		public String toString()
		{
			return builder.toString();
		}
		
		public VectorBuilder emit(final String string)
		{
			builder.append(string);
			
			return this;
		}
		
		public VectorBuilder line(final String string)
		{
			return startLine().emit(string).endLine();
		}
		
		private VectorBuilder startLine()
		{
			return tabs(blockCount);
		}
		private VectorBuilder startLine(final String string)
		{
			return startLine().emit(string);
		}
		public VectorBuilder endLine()
		{
			builder.append('\n');
			return this;
		}
		public VectorBuilder endLine(final String string)
		{
			return emit(string).endLine();
		}
		
		public VectorBuilder tab()
		{
			builder.append('\t');
			return this;
		}
		
		public VectorBuilder tabs(final int count)
		{
			for(int i = 0; i < count; i += 1)
			{
				builder.append('\t');
			}
			
			return this;
		}
		
		public VectorBuilder beginBlock(final String string)
		{
			return line(string).beginBlock();
		}
		
		public VectorBuilder beginBlock()
		{
			line("{");
			blockCount += 1;
			return this;
		}
		
		public VectorBuilder endBlock()
		{
			if(blockCount <= 0) throw new IllegalStateException();
			blockCount -= 1;
			return line("}").endLine();
		}
		
		public VectorBuilder startArgs()
		{
			argFrame.addFirst(0);
			return emit("(");
		}
		public VectorBuilder arg(final String arg)
		{
			if(argFrame.getFirst() > 0)
			{
				emit(", ");
			}
			argFrame.set(0, argFrame.getFirst() + 1);
			return emit(arg);
		}
		public VectorBuilder endArgs()
		{
			if(argFrame.isEmpty()) throw new IllegalStateException();
			emit(")");
			argFrame.removeFirst();
			return this;
		}
	}
	
	
	
}
