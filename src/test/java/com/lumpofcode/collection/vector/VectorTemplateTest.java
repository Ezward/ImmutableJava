package com.lumpofcode.collection.vector;

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
		
		for(int i = 1; i <= Vectors.VECTOR_NODE_SIZE; i += 1)
		{
			final String vectorOf = template.generate(i);
			System.out.println(vectorOf);
		}
		
	}
	
}
