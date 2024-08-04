package org.dnyanyog.services;


import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {

	@Autowired
	UsersRepository userRepo;

	@Autowired
	UserResponse userResponse;

	@Autowired
	List<String> userNames;

	public UserResponse addUpdateUser(UserRequest request) {

		Users usersTable = new Users();
		usersTable.setUserrole(request.getUserrole());
		usersTable.setEmailID(request.getEmailID());
		usersTable.setPasswords(request.getPasswords());
		usersTable.setUsername(request.getUsername());
		usersTable.setConfirmPassword(request.getConfirmPassword());
		// long currentBeforeTimeMillis = System.currentTimeMillis();
		
		usersTable = userRepo.save(usersTable);

		userResponse.getUserData().setUserrole(usersTable.getUserrole());
		userResponse.getUserData().setEmailID(usersTable.getEmailID());
		userResponse.getUserData().setPasswords(usersTable.getPasswords());
		userResponse.getUserData().setUsername(usersTable.getUsername());
		userResponse.getUserData().setConfirmPassword(usersTable.getConfirmPassword());
		userResponse.setMessage("User Added Successfuly");
		userResponse.setStatus("Success");
		
		return userResponse;
		
	}
	public UserResponse updateUser(String nameToSearch, UserRequest request) {

        List<Users> existingUser = userRepo.findByUsername(nameToSearch);

        if (existingUser.isEmpty()) {
            userResponse.setMessage("User Not Found");
            userResponse.setStatus("Failed");
        } else {
            Users user = existingUser.get(0);

            user.setUserrole(request.getUserrole());
            user.setEmailID(request.getEmailID());
            user.setPasswords(request.getPasswords());
            user.setConfirmPassword(request.getConfirmPassword());
            user.setUsername(request.getUsername());
           
            userRepo.save(user);

            userResponse.setMessage("User Updated Successfully");
            userResponse.setStatus("Success");
            userResponse.setUserId(user.getUserID());
        }
        return userResponse;
    }

	public UserResponse getSingleUser(String nameToSearch) {

		List<Users> receivedData = userRepo.findByUsername(nameToSearch);

		if (receivedData.isEmpty()) {
			userResponse.setStatus("fail");
			userResponse.setMessage("User Not Found");
		} else {
			Users user = receivedData.get(0);
			userResponse.setMessage("Success");
			userResponse.setStatus("User Found");

			UserData userData = userResponse.getUserData();

			userData.setEmailID(user.getEmailID());
			userData.setUserrole(user.getUserrole());
			userData.setPasswords(user.getPasswords());
			userData.setUsername(user.getUsername());
			userData.setConfirmPassword(user.getConfirmPassword());
			userData.setUserId(user.getUserID());
		}
		return userResponse;
	}

	
	public List<Users> getAllUser() {
		return userRepo.findAll();
	}

	public List<String> getAllUserNames() {
		List<Users> users = userRepo.findAll();

		for (Users user : users) {
			userNames.add(user.getUsername());
		}
		return userNames;
	}
	
	public UserResponse deleteUser(String nameToSearch) {

		List<Users> existingUser = userRepo.findByUsername(nameToSearch);

		if (existingUser.isEmpty()) {
			userResponse.setMessage("User Not Found");
			userResponse.setStatus("Failed");
		} else {
			Users user = existingUser.get(0);

			userRepo.delete(user);

			userResponse.setMessage("User Deleted Successfully");
			userResponse.setStatus("Success");
			userResponse.setUserId(user.getUserID());
		}
		return userResponse;
	}

		

}
