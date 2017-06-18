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
	public void VectorOf6Test()
	{
		final Vector<Integer> vectorOf6 = new VectorOf6(0, 1, 2, 3, 4, 5);
		assertVector(vectorOf6, 6);
		assertBounds(vectorOf6, 6);
		
		final Vector<Integer> vectorOf7 = vectorOf6.set(6, 6);
		assertVector(vectorOf7, 7);
	}
	
	@Test
	public void VectorOf7Test()
	{
		final Vector<Integer> vectorOf7 = new VectorOf7(0, 1, 2, 3, 4, 5, 6);
		assertVector(vectorOf7, 7);
		assertBounds(vectorOf7, 7);
		
		final Vector<Integer> vectorOf8 = vectorOf7.set(7, 7);
		assertVector(vectorOf8, 8);
	}
	
	@Test
	public void VectorOf8Test()
	{
		final Vector<Integer> vectorOf8 = new VectorOf8(0, 1, 2, 3, 4, 5, 6, 7);
		assertVector(vectorOf8, 8);
		assertBounds(vectorOf8, 8);
		
		final Vector<Integer> vectorOf9 = vectorOf8.set(8, 8);
		assertVector(vectorOf9, 9);
	}
	
	@Test
	public void VectorOf9Test()
	{
		final Vector<Integer> vectorOf9 =
			new VectorOf9(
				0, 1, 2, 3, 4, 5, 6, 7,
				8);
		assertVector(vectorOf9, 9);
		assertBounds(vectorOf9, 9);
		
		final Vector<Integer> vectorOf10 = vectorOf9.set(9, 9);
		assertVector(vectorOf10, 10);
	}
	
	@Test
	public void VectorOf10Test()
	{
		final Vector<Integer> vector =
			new VectorOf10(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9);
		assertVector(vector, 10);
		assertBounds(vector, 10);
		
		final Vector<Integer> nextVector = vector.set(10, 10);
		assertVector(nextVector, 11);
	}
	
	@Test
	public void VectorOf11Test()
	{
		final Vector<Integer> vector =
			new VectorOf11(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10);
		assertVector(vector, 11);
		assertBounds(vector, 11);
		
		final Vector<Integer> nextVector = vector.set(11, 11);
		assertVector(nextVector, 12);
	}
	
	@Test
	public void VectorOf12Test()
	{
		final Vector<Integer> vector =
			new VectorOf12(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11);
		assertVector(vector, 12);
		assertBounds(vector, 12);
		
		final Vector<Integer> nextVector = vector.set(12, 12);
		assertVector(nextVector, 13);
	}
	
	@Test
	public void VectorOf13Test()
	{
		final Vector<Integer> vector =
			new VectorOf13(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12);
		assertVector(vector, 13);
		assertBounds(vector, 13);
		
		final Vector<Integer> nextVector = vector.set(13, 13);
		assertVector(nextVector, 14);
	}
	
	@Test
	public void VectorOf14Test()
	{
		final Vector<Integer> vector =
			new VectorOf14(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13);
		assertVector(vector, 14);
		assertBounds(vector, 14);
		
		final Vector<Integer> nextVector = vector.set(14, 14);
		assertVector(nextVector, 15);
	}
	
	@Test
	public void VectorOf15Test()
	{
		final Vector<Integer> vector =
			new VectorOf15(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13, 14);
		assertVector(vector, 15);
		assertBounds(vector, 15);
		
		final Vector<Integer> nextVector = vector.set(15, 15);
		assertVector(nextVector, 16);
	}
	
	@Test
	public void VectorOf16Test()
	{
		final Vector<Integer> vector =
			new VectorOf16(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13, 14, 15);
		assertVector(vector, 16);
		assertBounds(vector, 16);
		
		final Vector<Integer> nextVector = vector.set(16, 16);
		assertVector(nextVector, 17);
	}
	
	
	@Test
	public void VectorTrieTest()
	{
		Vector<Integer> vector = Vectors.empty;
		final int n = Integer.MAX_VALUE;
		for(int i = 0; i < n; i += 1)
		{
			final long loopStart = System.currentTimeMillis();
			assertVector(vector, i);
			final long loopDuration = System.currentTimeMillis() - loopStart;
			
			final long start = System.currentTimeMillis();
			vector = vector.set(vector.size(), vector.size());
			final long duration = System.currentTimeMillis() - start;
			
			if(0 == (i % 1000))
			{
				System.out.print(i);                // length of vector
				System.out.print(':');
				System.out.print(loopDuration);   // time to loop through vector
				System.out.print(':');
				System.out.println(duration);       // time to add one element to end of vector
			}
			
			
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
		//System.out.println(vector.toString());
		//System.out.println("-------------------------");
		
		assertTrue(size == vector.size());
		for(int j = 0; j < vector.size(); j += 1)
		{
			assertTrue(j == vector.get(j));
		}
	}
	
}
