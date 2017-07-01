package com.lumpofcode.collection.vector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by emurphy on 6/30/17.
 */
public class VectorGeneratorApp
{
	public static void main(String[] args) throws IOException
	{
		final int nodeSize = (args.length > 0) ? Integer.valueOf(args[0]) : 16;
		final String fileFolder = (args.length > 1) ? args[1] : "./src/main/java/com/lumpofcode/collection/vector/impl/";
		
//		vectorTemplateSystemOut(nodeSize);
		vectorTemplateFileWriter(nodeSize, fileFolder);
	}
	
	public static void vectorTemplateSystemOut(final int nodeSize)
	{
		final VectorTemplate template = new VectorTemplate();
		final Writer writer = new StringWriter();
		
		for(int i = 1; i <= nodeSize; i += 1)
		{
			template.generate(writer, i, nodeSize);
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
	public static void vectorTemplateFileWriter(final int nodeSize, final String fileFolder) throws IOException
	{
		
		//
		// create directory structure './src/generated/java/com/lumpofcode/collection/vector/' starting at './src/generated'
		//
		final File folder = new File(fileFolder);
		if(!folder.exists())
		{
			if (!folder.mkdir())
			{
				throw new RuntimeException("Unable to create folder for generated sources.");
			}
		}
		
		final VectorTemplate template = new VectorTemplate();
		for(int i = 1; i <= nodeSize; i += 1)
		{
			//
			// delete existing file and recreate
			//
			final String fileName = "VectorOf{{size}}.java".replace("{{size}}", String.valueOf(i));
			final File file = new File(folder, fileName);
			if(file.exists())
			{
				file.delete();
			}
			
			final Writer writer = new FileWriter(file.getPath());
			template.generate(writer, i, nodeSize);
			writer.flush();
			writer.close();
		}
		
	}
	
}
