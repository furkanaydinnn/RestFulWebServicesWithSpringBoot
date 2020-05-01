package com.web.services.restfulWebServices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {

	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "jpa/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id : " + id);
		}
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		// here is for hateoas later..
		return user.get();
	}
	/*
	 * @GetMapping("/users") public User
	 * retrieveUserByRequestParam(@RequestParam("id") int id) { return
	 * service.findOne(id); }
	 */

	@PostMapping("jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "jpa/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		 userRepository.deleteById(id);
	}

}