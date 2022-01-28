/**
 * 
 */
package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.User;

/**
 * @author Habib Zerai
 *
 */
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void testRetrieveAllUsers() {

		List<User> users = userService.retrieveAllUsers();
		Assertions.assertEquals(users.size(), 0);
		
	}

}
