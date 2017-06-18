package com.lumpofcode;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Data class is final with all private final fields.
 * Used PersonBuilder class to create instances using fluent interface.
 *
 * ThreadSafe
 *
 * Created by emurphy on 6/9/17.
 */
@JsonDeserialize(builder = PersonBuilder.class)
public final class Person
{
	//
	// Properties are private, final and fully initialized in constructor.
	// If all properties are immutable, then the data class is immutable
	//
	private final int id;
	private final String firstName;
	private final String lastName;
	private final DateOfBirth dateOfBirth;
	
	/**
	 * Default constructor is required by Jackson
	 * (or we have to annotate arguments to our constructor.)
	 */
	public Person()
	{
		id = 0;
		lastName = null;
		firstName = null;
		dateOfBirth = null;
	}
	
	/**
	 * Complete constructor takes values for all fields.
	 *
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 */
	public Person(final int id, final String firstName, final String lastName, final DateOfBirth dateOfBirth)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Accessor uses java bean getter.
	 *
	 * @return
	 */
	public int getId()
	{
		return id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public DateOfBirth getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Person person = (Person) o;
		
		if (id != person.id) return false;
		if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
		if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
		return dateOfBirth != null ? dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth == null;
	}
	
	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "{\"id\":{id},\"firstName\":{firstName},\"lastName\":{lastName},\"dateOfBirth\":{dateOfBirth}}"
			.replace("{id}", String.valueOf(id))
			.replace("{firstName}", (null != firstName) ? ('\"' + firstName + '\"') : "null")
			.replace("{lastName}", (null != lastName) ? ('\"' + lastName + '\"') : "null")
			.replace("{dateOfBirth}", (null != dateOfBirth) ? dateOfBirth.toString() : "null");
	}
	
}
