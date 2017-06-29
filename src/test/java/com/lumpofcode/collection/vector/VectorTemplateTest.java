package com.lumpofcode.collection.vector;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

/**
 * Created by emurphy on 6/21/17.
 */
public class VectorTemplateTest
{
	@Test
	public void vectorTemplateTest()
	{
		final VectorTemplate template = new VectorTemplate();
		final Writer writer = new StringWriter();
		
		for(int i = 1; i <= Vectors.VECTOR_NODE_SIZE; i += 1)
		{
			template.generate(writer, i);
			final String vectorOf = writer.toString();
			System.out.println(vectorOf);
		}
		
	}
	
}
