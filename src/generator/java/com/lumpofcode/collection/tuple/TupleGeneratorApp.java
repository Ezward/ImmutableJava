package com.lumpofcode.collection.tuple;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by emurphy on 7/6/17.
 */
public class TupleGeneratorApp
{
	public static void main(String[] args) throws IOException
	{
		final int size = (args.length > 0) ? Integer.valueOf(args[0]) : 8;
		final String fileFolder = (args.length > 1) ? args[1] : "./src/main/java/com/lumpofcode/collection/tuple/";

		//tupleTemplateSystemOut(size);
		tupleTemplateFileWriter(size, fileFolder);
	}
	
	public static void tupleTemplateSystemOut(final int size)
	{
		if(size < 2) throw new IllegalArgumentException();
		
		final TupleTemplate template = new TupleTemplate();
		
		for(int i = 1; i <= size; i += 1)
		{
			final Writer writer = new StringWriter();
			template.generateTupleOfNN(writer, i, true);
			final String vectorOf = writer.toString();
			System.out.println(vectorOf);
		}
	}
	
	/**
	 * Run this in order to generate
	 * the family of TupleNN.java files
	 * in 'com/lumpofcode/collection/tuple'
	 *
	 * @throws IOException
	 */
	public static void tupleTemplateFileWriter(final int size, final String fileFolder) throws IOException
	{
		if(size < 2) throw new IllegalArgumentException();
		
		//
		// create directory structure './src/main/java/com/lumpofcode/collection/tuple/'
		//
		final File folder = new File(fileFolder);
		if(!folder.exists())
		{
			if (!folder.mkdir())
			{
				throw new RuntimeException("Unable to create folder for generated sources.");
			}
		}
		
		final TupleTemplate template = new TupleTemplate();
		
		
		//
		// write the Tuple## source files in the tuple folder
		//
		for(int i = 2; i <= size; i += 1)
		{
			//
			// delete existing file and recreate
			//
			final String fileName = "Tuple{{size}}.java".replace("{{size}}", String.valueOf(i));
			final File file = new File(folder, fileName);
			if(file.exists())
			{
				file.delete();
			}
			
			final Writer writer = new FileWriter(file.getPath());
			template.generateTupleOfNN(writer, i, true);
			writer.flush();
			writer.close();
		}
	}
	
}
