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
		
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf1 = vector.set(0, 0);
		assertTrue(null != vectorOf1);
		assertTrue(1 == vectorOf1.size());
		assertTrue(0 == vectorOf1.get(0));
		
		// explicit push
		assertVector(vector.push(0), 1);
	}
	
	@Test
	public void VectorOf1Test()
	{
		final Vector<Integer> vectorOf1 = Vectors.asVector(0);
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
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf2 = vectorOf1.set(1, 1);
		assertTrue(null != vectorOf2);
		assertTrue(2 == vectorOf2.size());
		assertTrue(0 == vectorOf2.get(0));
		assertTrue(1 == vectorOf2.get(1));
		
		// explicit push
		assertVector(vectorOf1.push(1), 2);
	}
	
	@Test
	public void VectorOf2Test()
	{
		final Vector<Integer> vectorOf2 = Vectors.asVector(0, 1);
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
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf3 = vectorOf2.set(2, 2);
		assertTrue(null != vectorOf3);
		assertTrue(3 == vectorOf3.size());
		assertTrue(0 == vectorOf3.get(0));
		assertTrue(1 == vectorOf3.get(1));
		assertTrue(2 == vectorOf3.get(2));
		
		// explicit push
		assertVector(vectorOf2.push(2), 3);
	}
	
	@Test
	public void VectorOf3Test()
	{
		final Vector<Integer> vectorOf3 = Vectors.asVector(0, 1, 2);
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
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf4 = vectorOf3.set(3, 3);
		assertTrue(null != vectorOf4);
		assertTrue(4 == vectorOf4.size());
		assertTrue(0 == vectorOf4.get(0));
		assertTrue(1 == vectorOf4.get(1));
		assertTrue(2 == vectorOf4.get(2));
		assertTrue(3 == vectorOf4.get(3));
		
		// explicit push
		assertVector(vectorOf3.push(3), 4);
	}
	
	@Test
	public void VectorOf4Test()
	{
		final Vector<Integer> vectorOf4 = Vectors.asVector(0, 1, 2, 3);
		assertVector(vectorOf4, 4);
		assertBounds(vectorOf4, 4);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf5 = vectorOf4.set(4, 4);
		assertVector(vectorOf5, 5);
		
		// explicit push
		assertVector(vectorOf4.push(4), 5);
	}
	
	@Test
	public void VectorOf5Test()
	{
		final Vector<Integer> vectorOf5 = Vectors.asVector(0, 1, 2, 3, 4);
		assertVector(vectorOf5, 5);
		assertBounds(vectorOf5, 5);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf6 = vectorOf5.set(5, 5);
		assertVector(vectorOf6, 6);
		
		// explicit push
		assertVector(vectorOf5.push(5), 6);
	}
	
	@Test
	public void VectorOf6Test()
	{
		final Vector<Integer> vectorOf6 = Vectors.asVector(0, 1, 2, 3, 4, 5);
		assertVector(vectorOf6, 6);
		assertBounds(vectorOf6, 6);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf7 = vectorOf6.set(6, 6);
		assertVector(vectorOf7, 7);
		
		// explicit push
		assertVector(vectorOf6.push(6), 7);
	}
	
	@Test
	public void VectorOf7Test()
	{
		final Vector<Integer> vectorOf7 = Vectors.asVector(0, 1, 2, 3, 4, 5, 6);
		assertVector(vectorOf7, 7);
		assertBounds(vectorOf7, 7);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf8 = vectorOf7.set(7, 7);
		assertVector(vectorOf8, 8);
		
		// explicit push
		assertVector(vectorOf7.push(7), 8);
	}
	
	@Test
	public void VectorOf8Test()
	{
		final Vector<Integer> vectorOf8 = Vectors.asVector(0, 1, 2, 3, 4, 5, 6, 7);
		assertVector(vectorOf8, 8);
		assertBounds(vectorOf8, 8);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf9 = vectorOf8.set(8, 8);
		assertVector(vectorOf9, 9);
		
		// explicit push
		assertVector(vectorOf8.push(8), 9);
	}
	
	@Test
	public void VectorOf9Test()
	{
		final Vector<Integer> vectorOf9 =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8);
		assertVector(vectorOf9, 9);
		assertBounds(vectorOf9, 9);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf10 = vectorOf9.set(9, 9);
		assertVector(vectorOf10, 10);
		
		// explicit push
		assertVector(vectorOf9.push(9), 10);
	}
	
	@Test
	public void VectorOf10Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9);
		assertVector(vector, 10);
		assertBounds(vector, 10);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(10, 10);
		assertVector(nextVector, 11);
		
		// explicit push
		assertVector(vector.push(10), 11);
	}
	
	@Test
	public void VectorOf11Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10);
		assertVector(vector, 11);
		assertBounds(vector, 11);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(11, 11);
		assertVector(nextVector, 12);
		
		// explicit push
		assertVector(vector.push(11), 12);
	}
	
	@Test
	public void VectorOf12Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11);
		assertVector(vector, 12);
		assertBounds(vector, 12);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(12, 12);
		assertVector(nextVector, 13);
		
		// explicit push
		assertVector(vector.push(12), 13);
	}
	
	@Test
	public void VectorOf13Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12);
		assertVector(vector, 13);
		assertBounds(vector, 13);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(13, 13);
		assertVector(nextVector, 14);
		
		// explicit push
		assertVector(vector.push(13), 14);
	}
	
	@Test
	public void VectorOf14Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13);
		assertVector(vector, 14);
		assertBounds(vector, 14);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(14, 14);
		assertVector(nextVector, 15);
		
		// explicit push
		assertVector(vector.push(14), 15);
	}
	
	@Test
	public void VectorOf15Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13, 14);
		assertVector(vector, 15);
		assertBounds(vector, 15);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(15, 15);
		assertVector(nextVector, 16);
		
		// explicit push
		assertVector(vector.push(15), 16);
	}
	
	@Test
	public void VectorOf16Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13, 14, 15);
		assertVector(vector, 16);
		assertBounds(vector, 16);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> nextVector = vector.set(16, 16);
		assertVector(nextVector, 17);
		
		// explicit push
		assertVector(vector.push(16), 17);
	}
	
	
	@Test
	public void VectorTrieTest()
	{
		Vector<Integer> vector = Vectors.empty;
		final int n = 10000;
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
