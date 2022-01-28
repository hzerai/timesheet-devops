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

	private static Long USER_TEST_ID = 999999L;

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
		userTest.setId(USER_TEST_ID);
		userTest.setDateNaissance(new Date());
		userTest.setLastName("UserLastNameTest");
		userService.addUser(userTest);
		User retrievedUser = userService.retrieveUser(String.valueOf(USER_TEST_ID));
		Assertions.assertNotNull(retrievedUser);
		userService.deleteUser(String.valueOf(USER_TEST_ID));

	}

}
