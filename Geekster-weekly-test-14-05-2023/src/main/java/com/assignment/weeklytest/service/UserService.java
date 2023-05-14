package com.assignment.weeklytest.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.weeklytest.dto.Sign;
import com.assignment.weeklytest.dto.SignIn;
import com.assignment.weeklytest.dto.SignUp;
import com.assignment.weeklytest.model.AuthenticationToken;
import com.assignment.weeklytest.model.User;
import com.assignment.weeklytest.repository.UserRepo;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TokenService tokenService;
	

	public Sign save(SignUp signUp) {
		// check if user exists or not based on email
		User user= userRepo.findFirstByUserEmail(signUp.getEmail());
		if (user != null) {
			throw new IllegalStateException("user already exists!!!!...sign in instead");
		}
		// encryption
		String encryptPassword=null;
		try {
			encryptPassword = encryptPassword(signUp.getPassword());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user= new User(signUp.getFirstName(), signUp.getLastName(),signUp.getAge(),
				signUp.getEmail(), encryptPassword, signUp.getPhoneNumber());
		userRepo.save(user);
		
		AuthenticationToken token = new AuthenticationToken();

		tokenService.saveToken(token,user);
		userRepo.save(user);

		return new Sign("User registed!....."," User registed successfully");
	}

	private String encryptPassword(String Password) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(Password.getBytes());
		byte[] digested = md5.digest();
		String hash = DatatypeConverter.printHexBinary(digested);
		return hash;
	}

	public Sign userSignIn(SignIn signIn) {
		// get email
				User user = userRepo.findFirstByUserEmail(signIn.getEmail());
				if(user == null) {
					throw new IllegalStateException("User invalid!!!!...sign up instead");
				}
				//encrypt password
				String encryptedPassword=null;
				try {
					encryptedPassword = encryptPassword(signIn.getPassword());
				}catch(NoSuchAlgorithmException e) {
		            e.printStackTrace();

		        }
				//match it with database encrypted password

		        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());
		        if(!isPasswordValid)
		        {
		            throw new IllegalStateException("User invalid!!!!...sign up instead");
		        }

		        //figure out the token
		       AuthenticationToken authToken=tokenService.getToken(user);

		        //set up output response
		        return new Sign("Authentication Successfull !!!",authToken.getToken());
	}

	public boolean updateUserById(Integer userId, User user) {
		// TODO Auto-generated method stub
		User getUser=userRepo.findByUserId(userId);
		if(getUser!=null) {
			if(user.getUserFirstName()!=null) getUser.setUserFirstName(user.getUserFirstName());
			if(user.getUserLastName()!=null) getUser.setUserLastName(user.getUserLastName());
			if(user.getUserAge()!=null) getUser.setUserAge(user.getUserAge());
			if(user.getUserPhoneNumber()!=null) getUser.setUserPhoneNumber(user.getUserPhoneNumber());
			return true;
		}
		return false;
	}
	
}
