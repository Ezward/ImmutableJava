package com.lumpofcode.collection.vector;

import com.lumpofcode.range.IntegerRange;

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
		
		// push 16
		assertVector(vector.push(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 16);
		
		// map
		assert(vector.map(e -> e + 1).isEmpty());
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assert(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)).isEmpty());
	}
	
	@Test
	public void VectorOf1Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0);
		assertTrue(null != vector);
		assertTrue(!vector.isEmpty());
		assertTrue(1 == vector.size());
		assertTrue(0 == vector.get(0));
		
		//
		// get out of bounds throws
		//
		try
		{
			vector.get(1);
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
			vector.set(2, 2);
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
		final Vector<Integer> vectorOf2 = vector.set(1, 1);
		assertTrue(null != vectorOf2);
		assertTrue(!vector.isEmpty());
		assertTrue(2 == vectorOf2.size());
		assertTrue(0 == vectorOf2.get(0));
		assertTrue(1 == vectorOf2.get(1));
		
		// explicit push
		assertVector(vector.push(1), 2);
		
		// push 16
		assertVector(vector.push(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), 17);
		
		
		// map
		assertVector(vector.map(e -> e + 1), 1, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 1 * 2);
	}
	
	@Test
	public void VectorOf2Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1);
		assertTrue(null != vector);
		assertTrue(2 == vector.size());
		assertTrue(0 == vector.get(0));
		assertTrue(1 == vector.get(1));
		
		//
		// get out of bounds throws
		//
		try
		{
			vector.get(2);
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
			vector.set(3, 3);
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
		final Vector<Integer> vectorOf3 = vector.set(2, 2);
		assertTrue(null != vectorOf3);
		assertTrue(3 == vectorOf3.size());
		assertTrue(0 == vectorOf3.get(0));
		assertTrue(1 == vectorOf3.get(1));
		assertTrue(2 == vectorOf3.get(2));
		
		// explicit push
		assertVector(vector.push(2), 3);
		
		// push 16
		assertVector(vector.push(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17), 18);
		
		// map
		assertVector(vector.map(e -> e + 1), 2, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 2 * 2);
	}
	
	@Test
	public void VectorOf3Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1, 2);
		assertTrue(null != vector);
		assertTrue(3 == vector.size());
		assertTrue(0 == vector.get(0));
		assertTrue(1 == vector.get(1));
		assertTrue(2 == vector.get(2));
		
		//
		// get out of bounds throws
		//
		try
		{
			vector.get(3);
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
			vector.set(4, 4);
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
		final Vector<Integer> vectorOf4 = vector.set(3, 3);
		assertTrue(null != vectorOf4);
		assertTrue(4 == vectorOf4.size());
		assertTrue(0 == vectorOf4.get(0));
		assertTrue(1 == vectorOf4.get(1));
		assertTrue(2 == vectorOf4.get(2));
		assertTrue(3 == vectorOf4.get(3));
		
		// explicit push
		assertVector(vector.push(3), 4);
		
		// push 16
		assertVector(vector.push(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18), 19);
		
		// map
		assertVector(vector.map(e -> e + 1), 3, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 3 * 2);
	}
	
	@Test
	public void VectorOf4Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1, 2, 3);
		assertVector(vector, 4);
		assertBounds(vector, 4);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf5 = vector.set(4, 4);
		assertVector(vectorOf5, 5);
		
		// explicit push
		assertVector(vector.push(4), 5);
		
		// push 16
		assertVector(vector.push(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19), 20);
		
		// map
		assertVector(vector.map(e -> e + 1), 4, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 4 * 2);
	}
	
	@Test
	public void VectorOf5Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1, 2, 3, 4);
		assertVector(vector, 5);
		assertBounds(vector, 5);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf6 = vector.set(5, 5);
		assertVector(vectorOf6, 6);
		
		// explicit push
		assertVector(vector.push(5), 6);
		
		// push 16
		assertVector(vector.push(5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 21);
		
		// map
		assertVector(vector.map(e -> e + 1), 5, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 5 * 2);
	}
	
	@Test
	public void VectorOf6Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1, 2, 3, 4, 5);
		assertVector(vector, 6);
		assertBounds(vector, 6);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf7 = vector.set(6, 6);
		assertVector(vectorOf7, 7);
		
		// explicit push
		assertVector(vector.push(6), 7);
		
		// push 16
		assertVector(vector.push(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21), 22);
		
		// map
		assertVector(vector.map(e -> e + 1), 6, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 6 * 2);
	}
	
	@Test
	public void VectorOf7Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1, 2, 3, 4, 5, 6);
		assertVector(vector, 7);
		assertBounds(vector, 7);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf8 = vector.set(7, 7);
		assertVector(vectorOf8, 8);
		
		// explicit push
		assertVector(vector.push(7), 8);
		
		// push 16
		assertVector(vector.push(7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22), 23);
		
		// map
		assertVector(vector.map(e -> e + 1), 7, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 7 * 2);
	}
	
	@Test
	public void VectorOf8Test()
	{
		final Vector<Integer> vector = Vectors.asVector(0, 1, 2, 3, 4, 5, 6, 7);
		assertVector(vector, 8);
		assertBounds(vector, 8);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf9 = vector.set(8, 8);
		assertVector(vectorOf9, 9);
		
		// explicit push
		assertVector(vector.push(8), 9);
		
		// push 16
		assertVector(vector.push(8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23), 24);
		
		// map
		assertVector(vector.map(e -> e + 1), 8, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 8 * 2);
	}
	
	@Test
	public void VectorOf9Test()
	{
		final Vector<Integer> vector =
			Vectors.asVector(
				0, 1, 2, 3, 4, 5, 6, 7,
				8);
		assertVector(vector, 9);
		assertBounds(vector, 9);
		
		// setting one past capacity does an implicit push
		final Vector<Integer> vectorOf10 = vector.set(9, 9);
		assertVector(vectorOf10, 10);
		
		// explicit push
		assertVector(vector.push(9), 10);
		
		// push 16
		assertVector(vector.push(9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24), 25);
		
		// map
		assertVector(vector.map(e -> e + 1), 9, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 9 * 2);
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
		
		// push 16
		assertVector(vector.push(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25), 26);
		
		// map
		assertVector(vector.map(e -> e + 1), 10, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 10 * 2);
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
		
		// push 16
		assertVector(vector.push(11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26), 27);
		
		// map
		assertVector(vector.map(e -> e + 1), 11, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 11 * 2);
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
		
		// push 16
		assertVector(vector.push(12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27), 28);
		
		// map
		assertVector(vector.map(e -> e + 1), 12, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 12 * 2);
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
		
		// push 16
		assertVector(vector.push(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28), 29);
		
		// map
		assertVector(vector.map(e -> e + 1), 13, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 13 * 2);
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
		
		// push 16
		assertVector(vector.push(14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29), 30);
		
		// map
		assertVector(vector.map(e -> e + 1), 14, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 14 * 2);
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
		
		// push 16
		assertVector(vector.push(15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30), 31);
		
		// map
		assertVector(vector.map(e -> e + 1), 15, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 15 * 2);
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
		
		// push 16
		assertVector(vector.push(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31), 32);
		
		// map
		assertVector(vector.map(e -> e + 1), 16, 1);
		
		// flatmap (make vector of 0, 2, 4, etc, then flatmap to (e,e+1) to get flattened vector of double length
		assertVector(vector.map(e -> e * 2).flatmap(e -> Vectors.asVector(e, e+1)), 16 * 2);
	}
	
	
	@Test
	public void VectorTrieTest()
	{
		//
		// build a vector of 16000 elements one element at a time
		// and verify the vector on each step
		//
		Vector<Integer> vector = Vectors.empty;
		final int n = 16000;
		for(int i = 0; i < n; i += 1)
		{
			assertVector(vector, i);
			vector = vector.set(vector.size(), vector.size());
		}
		assertVector(vector, n);
	}
	
	@Test
	public void push16AlignedTest()
	{
		//
		// starting with empty, built a vector of 16000 elements, 16 elements at a time
		// and verify the vector after each grop fo 16 elements is added.
		//
		Vector<Integer> vector = Vectors.empty;
		final int n = 16000;
		for(int i = 0; i < n; i += 16)
		{
			assertVector(vector, i);
			vector = vector.push(i+0, i+1, i+2, i+3, i+4, i+5, i+6, i+7, i+8, i+9, i+10, i+11, i+12, i+13, i+14, i+15);
		}
		assertVector(vector, n);
		
	}
	
	@Test
	public void push16UnalignedTest()
	{
		//
		// starting with empty, built a vector unaligned vectors, then add 16000 elements, 16 elements at a time
		// and verify the vector after each group fo 16 elements is added.
		//
		for(int j = 1; j <= 15; j += 1)
		{
			final int n = 16000 + j;
			Vector<Integer> vector = Vectors.asVector(new IntegerRange(0, j));
			for (int i = j; i < n; i += 16)
			{
				assertVector(vector, i);
				vector = vector.push(i + 0, i + 1, i + 2, i + 3, i + 4, i + 5, i + 6, i + 7, i + 8, i + 9, i + 10, i + 11, i + 12, i + 13, i + 14, i + 15);
			}
			assertVector(vector, n);
		}
	}
	
	@Test
	public void mapTest()
	{
		final int n = 16000;
		Vector<Integer> vector = Vectors.asVector(new IntegerRange(0, n));
		Vector<Integer> mappedVector = vector.map(e -> e + 1);
		assertVector(mappedVector, n, 1);
	}
	
	@Test
	public void flatmapTest()
	{
		//
		// create a vector like 0, 5, 10, 15 ...
		// flatmap with function that takes value and makes vector (v, v+1, v+2, v+3, v+4)
		// which should produce a flattened vector from 0 to 5 * n
		//
		final int n = 16000;
		Vector<Integer> vector = Vectors.asVector(new IntegerRange(0, n, 5));
		Vector<Integer> mappedVector = vector.flatmap(e -> Vectors.asVector(e, e+1, e+2, e+3, e+4));
		assertVector(mappedVector, n * 5);
	}
	
	@Test
	public void push1Time()
	{
		final long start = System.currentTimeMillis();
		Vector<Integer> vector = Vectors.empty;
		final int n = 1600000;
		for(int i = 0; i < n; i += 1)
		{
			vector = vector.push(i);
		}
		final long duration = System.currentTimeMillis() - start;
		
		final long loopStart = System.currentTimeMillis();
		assertVector(vector, n);
		final long loopDuration = System.currentTimeMillis() - loopStart;
		
		System.out.print(n);                // length of vector
		System.out.print(':');
		System.out.print(duration);         // time to add elements to end of vector
		System.out.print(':');
		System.out.println(loopDuration);   // time to loop through vector
	}
	
	@Test
	public void push16Time()
	{
		//
		// starting with empty
		//
		final long start = System.currentTimeMillis();
		Vector<Integer> vector = Vectors.empty;
		final int n = 1600000;
		for(int i = 0; i < n; i += 16)
		{
			vector = vector.push(i+0, i+1, i+2, i+3, i+4, i+5, i+6, i+7, i+8, i+9, i+10, i+11, i+12, i+13, i+14, i+15);
		}
		final long duration = System.currentTimeMillis() - start;
		
		final long loopStart = System.currentTimeMillis();
		assertVector(vector, n);
		final long loopDuration = System.currentTimeMillis() - loopStart;
		
		System.out.print(n);                // length of vector
		System.out.print(':');
		System.out.print(duration);         // time to add elements to end of vector
		System.out.print(':');
		System.out.println(loopDuration);   // time to loop through vector
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
	
	private void assertVector(final Vector<Integer> vector, final int size)
	{
		assertVector(vector, size, 0);
	}
	private void assertVector(final Vector<Integer> vector, final int size, final int offset)
	{
		//System.out.println(vector.toString());
		//System.out.println("-------------------------");
		
		assertBounds(vector, size);

		int j = 0;
		for(Integer value : vector)
		{
			assertTrue(j + "th element should match the iteration", value == vector.get(j));
			assertTrue(j + "th element should be " + j + offset, value == (j + offset));
			
			j += 1;
		}
		
		assertTrue("size should be " + j, j == vector.size());
		assertTrue("j should be " + size, j == size);
	}
	
}
