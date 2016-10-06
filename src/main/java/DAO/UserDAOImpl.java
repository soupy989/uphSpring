package DAO;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mappers.UserMapper;
import models.User;

public class UserDAOImpl implements UserDAO{
	
	private JdbcTemplate jdbcTemplateObject;
	
	public UserDAOImpl(DataSource dataSource)
	{
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer number) {
		String SQL = "insert into User (name, number) values(?,?)";
		
		jdbcTemplateObject.update(SQL, name, number);
		System.out.println("Created record name=" + name + " number=" + number);
		return;
	}
	
	@Override
	public User getUser(Integer id) {
		String SQL = "select * from User where id = ?";
		User user = jdbcTemplateObject.queryForObject(SQL,  new Object[]{id}, new UserMapper());
		return user;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from User where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
		return;	
	}

	@Override
	public void update(Integer id, Integer number, String name) {
		String SQL = "update User set number = ?, name= ? where id= ?";
		jdbcTemplateObject.update(SQL, number, name, id);
		System.out.println("Updated Record with ID = " + id );
		return;	
	}

}
