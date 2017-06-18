package com.lumpofcode.collection.vector;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by emurphy on 6/17/17.
 */
public class VectorTest
{
	@Test
	public void EmptyVectorTest()
	{
		final Vector<Integer> vector = Vectors.empty;
		
		assertTrue(0 == vector.size());
		
		//
		// get should throw for empty vector
		//
		try
		{
			vector.get(0);
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
			vector.set(1, 1);
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
		
		
		final Vector<Integer> vectorOf1 = vector.set(0, 0);
		assertTrue(null != vectorOf1);
		assertTrue(1 == vectorOf1.size());
		assertTrue(0 == vectorOf1.get(0));
		
		//
		// attempt to set out of bounds throws
		//
	}
	
	@Test
	public void VectorOf1Test()
	{
		final Vector<Integer> vectorOf1 = new VectorOf1(0);
		assertTrue(null != vectorOf1);
		assertTrue(1 == vectorOf1.size());
		assertTrue(0 == vectorOf1.get(0));
		
		//
		// get out of bounds throws
		//
		try
		{
			vectorOf1.get(1);
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
			vectorOf1.set(2, 2);
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
		
		final Vector<Integer> vectorOf2 = vectorOf1.set(1, 1);
		assertTrue(null != vectorOf2);
		assertTrue(2 == vectorOf2.size());
		assertTrue(0 == vectorOf2.get(0));
		assertTrue(1 == vectorOf2.get(1));
	}
	
	@Test
	public void VectorOf2Test()
	{
		final Vector<Integer> vectorOf2 = new VectorOf2(0, 1);
		assertTrue(null != vectorOf2);
		assertTrue(2 == vectorOf2.size());
		assertTrue(0 == vectorOf2.get(0));
		assertTrue(1 == vectorOf2.get(1));
		
		//
		// get out of bounds throws
		//
		try
		{
			vectorOf2.get(2);
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
			vectorOf2.set(3, 3);
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
		
		final Vector<Integer> vectorOf3 = vectorOf2.set(2, 2);
		assertTrue(null != vectorOf3);
		assertTrue(3 == vectorOf3.size());
		assertTrue(0 == vectorOf3.get(0));
		assertTrue(1 == vectorOf3.get(1));
		assertTrue(2 == vectorOf3.get(2));
	}
	
	@Test
	public void VectorOf3Test()
	{
		final Vector<Integer> vectorOf3 = new VectorOf3(0, 1, 2);
		assertTrue(null != vectorOf3);
		assertTrue(3 == vectorOf3.size());
		assertTrue(0 == vectorOf3.get(0));
		assertTrue(1 == vectorOf3.get(1));
		assertTrue(2 == vectorOf3.get(2));
		
		//
		// get out of bounds throws
		//
		try
		{
			vectorOf3.get(3);
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
			vectorOf3.set(4, 4);
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
		
		final Vector<Integer> vectorOf4 = vectorOf3.set(3, 3);
		assertTrue(null != vectorOf4);
		assertTrue(4 == vectorOf4.size());
		assertTrue(0 == vectorOf4.get(0));
		assertTrue(1 == vectorOf4.get(1));
		assertTrue(2 == vectorOf4.get(2));
		assertTrue(3 == vectorOf4.get(3));
	}
	
	@Test
	public void VectorOf4Test()
	{
		final Vector<Integer> vectorOf4 = new VectorOf4(0, 1, 2, 3);
		assertVector(vectorOf4, 4);
		assertBounds(vectorOf4, 4);
		
		final Vector<Integer> vectorOf5 = vectorOf4.set(4, 4);
		assertVector(vectorOf5, 5);
	}
	
	@Test
	public void VectorOf5Test()
	{
		final Vector<Integer> vectorOf5 = new VectorOf5(0, 1, 2, 3, 4);
		assertVector(vectorOf5, 5);
		assertBounds(vectorOf5, 5);
		
		final Vector<Integer> vectorOf6 = vectorOf5.set(5, 5);
		assertVector(vectorOf6, 6);
	}
	
	
	@Test
	public void VectorTrieTest()
	{
		Vector<Integer> vector = Vectors.empty;
		for(int i = 0; i < 100; i += 1)
		{
			assertVector(vector, i);
			
			vector = vector.set(vector.size(), vector.size());
		}
		
	}
	
	private void assertBounds(final Vector<Integer> vector, final int size)
	{
		assertTrue(size == vector.size());

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
	
	private void assertVector(final Vector<Integer> vector, final int size)
	{
		System.out.println(vector.toString());
		System.out.println("-------------------------");
		
		assertTrue(size == vector.size());
		for(int j = 0; j < vector.size(); j += 1)
		{
			assertTrue(j == vector.get(j));
		}
	}
	
}
