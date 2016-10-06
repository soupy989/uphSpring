package models;

public class User {
	private Integer number;
	private Integer id;
	private String name;
	
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	
	public Integer getNumber()
	{
		return this.number;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}
