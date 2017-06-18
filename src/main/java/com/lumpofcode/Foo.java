package com.lumpofcode;

/**
 * Created by emurphy on 6/16/17.
 */
public final class Foo
{
	public interface Data
	{
		String getName();
		Long getId();
	}
	
	/**
	 * Implementation is completely private
	 *
	 */
	private static final class DataImpl implements Data
	{
		private final String name;
		private final Long id;
		
		public DataImpl(final String name, final Long id)
		{
			this.name = name;
			this.id = id;
		}
		
		@Override
		public String getName()
		{
			return null;
		}
		
		@Override
		public Long getId()
		{
			return null;
		}
	}
	
	/**
	 * Factory for DataClass (could use builder pattern instead if warranted).
	 *
	 * @param name
	 * @param id
	 * @return
	 */
	public static Foo.Data newFoo(final String name, final Long id)
	{
		return new DataImpl(name, id);
	}
	
	/*
	 * Other static business methods can go here.
	 */
}
