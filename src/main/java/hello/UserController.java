package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import models.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable(value="id", required = true)Integer id)
    {
    	User user = userDAO.getUser(id);
    	//System.out.println(user.getName());
    	return user;
    }
}
