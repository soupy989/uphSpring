package DAO;

import java.util.List;
import javax.sql.DataSource;

import models.User;

public interface UserDAO {
	
	public void create(String name, Integer number);
	
	public User getUser(Integer id);
	
	public void delete(Integer id);
	
	public void update(Integer id, Integer number, String name);
}
