/**
 * 
 */
package tn.esprit.spring.services;

import java.util.Date;
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
	
	//should test find & delete user before
	@Test
	public void testAddUser() {

		User userTest = new User();
		userTest.setDateNaissance(new Date());
		userTest.setLastName("UserLastNameTest");
		userTest = userService.addUser(userTest);
		User retrievedUser = userService.retrieveUser(userTest.getId());
		Assertions.assertNotNull(retrievedUser);
		userService.deleteUser(userTest.getId());

	}

}
