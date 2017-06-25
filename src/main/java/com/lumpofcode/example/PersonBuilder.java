package com.lumpofcode.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.lumpofcode.date.DateOfBirth;

/**
 * Fluent Builder for Person instances
 *
 * Used by as pojo builder by Jackson
 *
 * Created by emurphy on 6/10/17.
 */
@JsonPOJOBuilder(withPrefix="")
public final class PersonBuilder
{
	//
	// properties are private and given defaults
	//
	private int id = 0;
	private String firstName = null;
	private String lastName = null;
	private DateOfBirth dateOfBirth = null;
	
	public Person build()
	{
		return new Person(
			this.id,
			this.firstName,
			this.lastName,
			this.dateOfBirth);
	}
	
	public PersonBuilder with(final Person that)
	{
		this.id = that.getId();
		this.firstName = that.getFirstName();
		this.lastName = that.getLastName();
		this.dateOfBirth = that.getDateOfBirth();
		return this;
	}
	
	public PersonBuilder id(@JsonProperty("id") final int id)
	{
		this.id = id;
		return this;
	}
	
	public PersonBuilder firstName(@JsonProperty("firstName") final String firstName)
	{
		this.firstName = firstName;
		return this;
	}
	
	public PersonBuilder lastName(@JsonProperty("lastName") final String lastName)
	{
		this.lastName = lastName;
		return this;
	}
	
	public PersonBuilder dateOfBirth(@JsonProperty("dateOfBirth") final DateOfBirth dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
		return this;
	}
}
