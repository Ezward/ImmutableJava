package com.lumpofcode.annotation;

import com.lumpofcode.collection.binarytree.BinaryTree;
import com.lumpofcode.collection.list.LinkList;
import com.lumpofcode.collection.tuple.Tuple2;
import com.lumpofcode.collection.tuple.Tuple3;
import com.lumpofcode.collection.vector.VectorOfSize;
import com.lumpofcode.collection.vector.VectorOverlay;
import com.lumpofcode.collection.vector.VectorTrie;
import com.lumpofcode.collection.vector.VectorView;
import com.lumpofcode.lazy.Lazy;
import com.lumpofcode.lazy.Once;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by emurphy on 6/26/17.
 */
public class ImmutableTest
{
	public String mutableField;
	
	//
	// this class is Immutable
	//
	public static final class ImmutableClass
	{
		private final int i;
		private final String s;
		private final Object o;
		
		public ImmutableClass(int i, String s, Object o)
		{
			this.i = i;
			this.s = s;
			this.o = o;
		}
	}
	
	//
	// this class is NOT immutable, because it is
	// a child class that is not marked static,
	// it has an implicit relationship to outer class
	// which in this case is not final
	//
	public final class NotImmutableChildClass{}
	
	public static class GenericClass<T>
	{
		final T field;
		
		public GenericClass(final T field)
		{
			this.field = field;
		}
	}
	
	
	public static final class PersistentGenericClass extends GenericClass<ImmutableClass>
	{
		public PersistentGenericClass(final ImmutableClass field)
		{
			super(field);
		}
	}
	
	public static final class MutableFieldClass
	{
		private String mutable;
	}
	
	public static class NotFinalClass
	{
		
	}
	
	@Test
	public void testPersistent()
	{
		assertTrue(Immutables.isPersistent(ImmutableClass.class));
		
		assertTrue(Immutables.isPersistent(PersistentGenericClass.class));
		
		assertFalse(Immutables.isPersistent(MutableFieldClass.class));
		
		// class is not final
		assertFalse(Immutables.isPersistent(NotFinalClass.class));
		
		// inner class with mutable outer class
		// ??? assertFalse(Immutables.isPersistent(NotImmutableChildClass.class));
		
		//
		// check that our persistent data structures are persistent
		//
		assertTrue(Immutables.isPersistent(LinkList.class));
		assertTrue(Immutables.isPersistent(BinaryTree.class));
		assertTrue(Immutables.isPersistent(VectorOfSize.class));
		assertTrue(Immutables.isPersistent(VectorTrie.class));
		assertTrue(Immutables.isPersistent(VectorTrie.class));
		assertTrue(Immutables.isPersistent(VectorView.class));
		assertTrue(Immutables.isPersistent(VectorOverlay.class));
		
		assertTrue(Immutables.isPersistent(String.class));
		assertTrue(Immutables.isPersistent(Long.class));
		assertTrue(Immutables.isPersistent(Integer.class));
		assertTrue(Immutables.isPersistent(Boolean.class));
		assertTrue(Immutables.isPersistent(Void.class));
		
		assertTrue(Immutables.isPersistent(Once.class));
		assertTrue(Immutables.isPersistent(Lazy.class));
		
		assertTrue(Immutables.isPersistent(Tuple2.class));
		assertTrue(Immutables.isPersistent(Tuple3.class));
	}
	
	public void foo()
	{
		final Map<String, String > map = new HashMap<>();
	}
}
