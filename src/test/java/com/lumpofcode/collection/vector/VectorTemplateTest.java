package com.lumpofcode.collection.vector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Ignore;
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
			template.generate(writer, i, Vectors.VECTOR_NODE_SIZE);
			final String vectorOf = writer.toString();
			System.out.println(vectorOf);
		}
		
		System.out.println(Integer.MAX_VALUE / 24);
		System.out.println(Integer.MAX_VALUE % 24);
		
	}
	
	/**
	 * Run this test manually in order to generate
	 * the VectorOfNN.java files in
	 * com/lumpofcode/collection/vector/impl
	 *
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void vectorTemplateWriter() throws IOException
	{
		final VectorTemplate template = new VectorTemplate();
		
		//
		// create directory structure './src/generated/java/com/lumpofcode/collection/vector/' starting at './src/generated'
		//
//		final File dir = new File("./src/main/java/com/lumpofcode/collection/vector/impl");
//
//		// attempt to create the directory here
//		if(!dir.exists())
//		{
//			if (!dir.mkdir())
//			{
//				throw new RuntimeException("Unable to create folder for generated sources.");
//			}
//		}
		
		for(int i = 1; i <= Vectors.VECTOR_NODE_SIZE; i += 1)
		{
			final String filePath = "./src/main/java/com/lumpofcode/collection/vector/impl/VectorOf{{size}}.java".replace("{{size}}", String.valueOf(i));
			final Writer writer = new FileWriter(filePath);
			template.generate(writer, i, Vectors.VECTOR_NODE_SIZE);
			writer.flush();
			writer.close();
		}
		
	}
	
}
