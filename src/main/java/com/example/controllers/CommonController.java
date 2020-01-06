package com.example.controllers;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.JwtUserDetailsService;
import com.example.utility.JWTUtility;
import com.example.beans.Organisation;
import com.example.beans.User;
import com.example.dao.DetailValidateDao;
import com.example.dao.UserDao;
import com.example.model.JwtRequest;
import com.example.model.JwtResponse;

@RestController
@CrossOrigin
public class CommonController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTUtility jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private UserDao userDao;	
	@Autowired
	private DetailValidateDao dvDao;

	/**
	 * method for authentication of user
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST , consumes = {"application/JSON"} , produces = {"application/JSON"})
	public ResponseEntity<?> userLogin(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("Username,Password : "+authenticationRequest.getUsername()+","+authenticationRequest.getPassword());
		/*authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());*/
		/*final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());*/
		User userDetails=userDao.getUserByName(authenticationRequest.getUsername());
		
		System.out.println("userDetails"+userDetails);
		
		if(userDetails!=null) {
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		}else {
			return ResponseEntity.ok("User not found");
		}
	}


	/**
	 * Method for Registration of new Users and 
	 * Check for already Existing User
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/newUserRegistration", method = RequestMethod.POST)
	public ResponseEntity<?> registration(@RequestBody User user){
		if(dvDao.isAlreadyRegistered(user))
			return ResponseEntity.ok("User Alredy Registered");
		else {
			if(userDao.doRegistration(user)) 
				return ResponseEntity.ok("Registration Done");
			else
				return ResponseEntity.ok("Problem in Registration please try again later");
		}
	}


}

