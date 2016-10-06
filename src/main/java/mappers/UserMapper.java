package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import models.User;

public class UserMapper implements RowMapper<User>
{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setNumber(rs.getInt("number"));
		return user;
	}
}
