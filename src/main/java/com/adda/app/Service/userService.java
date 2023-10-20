package com.adda.app.Service;

import java.util.List;

import com.adda.app.Entity.User;

public interface userService {

	public User SaveUser(User user);
	public void deleteUser(Long id);
	public List<User> getAllUser();
	public User getOneUserById(Long Id);
	public User getCurrentUser(String name);
}
