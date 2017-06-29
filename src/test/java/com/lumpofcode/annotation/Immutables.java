package com.lumpofcode.annotation;

import com.lumpofcode.lazy.Lazy;
import com.lumpofcode.lazy.Once;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by emurphy on 6/26/17.
 */
public final class Immutables
{
	
	//
	// singleton - prevent construction
	//
	private Immutables() { throw new RuntimeException(); }
	
	/**
	 * A persistent class has only final properties.
	 *
	 * @param theClass
	 * @return true if all properties are final
	 */
	public static boolean isPersistent(final Class<?> theClass)
	{
		if(isKnownImmutable(theClass)) return true;
		if(isEffectivelyImmutable(theClass)) return true;
		
		//
		// Class must be final
		//
		if (!Modifier.isFinal(theClass.getModifiers()))
		{
			debug(theClass.getName() + " is not final.");
				
			return false;
		}
		
		//
		// all fields in this and super classes must be final
		//
		if(!areFieldsFinal(theClass))
		{
			debug(theClass.getName() + " has a non-final field.");

			return false;
		}
		
		//
		// is the generic class peristent
		//
		if(!isGenericPersistent(theClass))
		{
			debug(theClass.getName() + " has a non-final generic type parameter.");

			return false;
		}
		
		return true;
	}
	
	/**
	 * Check that all fields are final
	 *
	 * @param theClass
	 * @return
	 */
	private static boolean areFieldsFinal(final Class<?> theClass)
	{
		if(isKnownImmutable(theClass)) return true;
		if(isEffectivelyImmutable(theClass)) return true;
		
		//
		// Check all fields are final
		//
		final Field[] theFields = theClass.getDeclaredFields();
		for (Field theField : theFields)
		{
			if (!Modifier.isFinal(theField.getModifiers()))
			{
				debug("the field " + theField.getName() + " of class " + theClass.getName() + " is not final.");

				return false;
			}
		}
		
		//
		// the super class must also have final fields
		//
		final Class<?> theSuperClass = theClass.getSuperclass();
		if(null != theSuperClass)
		{
			if(! areFieldsFinal(theSuperClass))
			{
				debug("A field of the superclass " + theSuperClass.getName() + " of class " + theClass.getName() + " is not final.");

				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isGenericPersistent(final Class<?> theClass)
	{
		if(isKnownImmutable(theClass)) return true;
		if(isEffectivelyImmutable(theClass)) return true;
		
		//
		// If this is generic, check that generic type is immutable
		//
		final TypeVariable[] theTypeVariables = theClass.getTypeParameters();
		for(TypeVariable theTypeVariable : theTypeVariables)
		{
			for(Type theType : theTypeVariable.getBounds())
			{
				//
				// get the class given the type name
				// and check that it is immutable
				//
				final Class<?> theTypeClass = classForName(theType.getTypeName());
				if(!isPersistent(theTypeClass))
				{
					debug("The generic type parameber " + theTypeClass.getName() + " of class " + theClass.getName() + " is not final.");

					return false;
				}
			}
		}
		
		return true;
	}
	
	
	private static Class<?> classForName(final String className)
	{
		try
		{
			return Class.forName(className);
		}
		catch (ClassNotFoundException e)
		{
			return null;
		}
	}
	
	private static boolean isKnownImmutable(Class<?> theClass)
	{
		if(theClass.isPrimitive()) return true;         // primitive
		return false;
	}
	
	private static boolean isEffectivelyImmutable(Class<?> theClass)
	{
		// Check for all allowed property types...
		if(Object.class.equals(theClass)) return true;
		if(String.class.equals(theClass)) return true;  // string
		if(Once.class.equals(theClass)) return true;
		if(Lazy.class.equals(theClass)) return true;
		return false;
	}
	
	private static void debug(final String line)
	{
		System.out.println(line);
	}
	
}
