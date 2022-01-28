package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
 	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			
			l.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (User user : users) {
				l.debug("user :" + user.getLastName()); 
			} 
			l.info("Out of Method retrieveAllUsers with Success" + users.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e); 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		
		User u_saved = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			u_saved = userRepository.save(u); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in addUser() : " + e);
		}
		
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) {
		
		User userUpdated = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			userUpdated = userRepository.save(u); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in updateUser() : " + e);
		}
		
		return userUpdated; 
	}

	@Override
	public void deleteUser(String id) {
		
		try {
			// TODO Log à ajouter en début de la méthode 
			userRepository.deleteById(Long.parseLong(id)); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in deleteUser() : " + e);
		}
		
	}

	@Override
	public User retrieveUser(String id) {
		User u = null; 
		try {
			// TODO Log à ajouter en début de la méthode 
			u =  userRepository.findById(Long.parseLong(id)).get(); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveUser() : " + e);
		}

		return u; 
	}

}
