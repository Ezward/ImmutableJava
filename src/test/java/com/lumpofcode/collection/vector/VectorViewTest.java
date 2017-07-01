package com.lumpofcode.collection.vector;

import com.lumpofcode.range.IntegerRange;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by emurphy on 6/30/17.
 */
public class VectorViewTest
{
	@Test
	public void testVectorView()
	{
		//
		// starting with empty, built a vector unaligned vectors, then add 16000 elements, 16 elements at a time
		// and verify the vector after each group fo 16 elements is added.
		//
		for(int i = 1; i <= 512; i += 1)
		{
			Vector<Integer> vector = Vectors.asVector(new IntegerRange(0, i));
			for(int k = 0; k < (vector.size() - 1) / 2; k += 1)
			{
				final VectorView view = new VectorView(vector, k, vector.size() - k);
				System.out.println("i={{i}}, k={{k}}"
					.replace("{{i}}", String.valueOf(i))
					.replace("{{k}}", String.valueOf(k)));
				
				assertVector(view, vector.size() - 2 * k, k);
			}
		}
	}
	
	@Test
	public void testPush()
	{
		//
		// this tests the view and the overlays
		//
		
		//
		// starting with empty, built a vector unaligned vectors, then add 16000 elements, 16 elements at a time
		// and verify the vector after each group fo 16 elements is added.
		//
		for(int i = 1; i <= 48; i += 1)
		{
			//
			// build vector of length i with values 0..i-1 inclusive
			//
			Vector<Integer> vector = Vectors.asVector(new IntegerRange(0, i));
			for(int k = 0; k < (vector.size() - 1) / 2; k += 1)
			{
				//
				// create a view by truncating the first and last k elements
				//
				final VectorView<Integer> view = new VectorView(vector, k, i - k);
				
				for(int j = 1; j < 2 * i; j += 1)
				{
					//
					// push values onto the end.
					//
					final Vector extendedView = view.pushAll(new IntegerRange(i - k, j));
					System.out.println("i={{i}}, k={{k}}, j={{j}}"
						.replace("{{i}}", String.valueOf(i))
						.replace("{{k}}", String.valueOf(k))
						.replace("{{j}}", String.valueOf(j)));
					assertVector(extendedView, i - 2 * k + j, k);
				}
				
				
			}
		}
	}
	
	private void assertBounds(final Vector<Integer> vector, final int size)
	{
		assertTrue("size should be " + size, size == vector.size());
		assertTrue("should only be empty if size is zero", (0 == size) == vector.isEmpty());
		
		//
		// get out of bounds throws
		//
		try
		{
			vector.get(vector.size());
			fail("should have throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);   // success
		}
		catch(Exception e)
		{
			fail("unexpected exception.");
		}
		
		//
		// attempt to set out of bounds throws
		//
		try
		{
			vector.set(vector.size() + 1, vector.size() + 1);
			fail("should have throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);   // success
		}
		catch(Exception e)
		{
			fail("unexpected exception.");
		}
		
	}
	
	private void assertVector(final Vector<Integer> vector, final int size, final int k)
	{
		assertVector(vector, size, 0, k);
	}
	private void assertVector(final Vector<Integer> vector, final int size, final int offset, final int k)
	{
		//System.out.println(vector.toString());
		//System.out.println("-------------------------");
		
		assertBounds(vector, size);
		
		int j = 0;
		for(Integer value : vector)
		{
			assertTrue(j + "th element should match the iteration", value == vector.get(j));
			assertTrue(j + "th element should be " + j + offset + k, value == (j + offset + k));
			
			j += 1;
		}
		
		assertTrue("size should be " + j, j == vector.size());
		assertTrue("j should be " + size, j == size);
	}
	
}
