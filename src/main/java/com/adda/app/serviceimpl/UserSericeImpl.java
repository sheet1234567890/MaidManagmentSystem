package com.adda.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adda.app.Entity.User;
import com.adda.app.Service.userService;
import com.adda.app.reposatory.UserRepo;
@Service
public class UserSericeImpl implements userService,UserDetailsService{
   @Autowired
	private UserRepo urepo;
   @Autowired
   public BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User SaveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getPassword());
		ArrayList a = new ArrayList();
		a.add("USER");
		user.setRole(a);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return this.urepo.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getOneUserById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = this.urepo.getUserByName(email);
		if(user.isEmpty()) 
		{
			throw new UsernameNotFoundException(email +"Not Exist User ");
		}
		User u = user.get();
		List<GrantedAuthority> authority = u.getRole().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(email,u.getPassword(),authority);
	}

	@Override
	public User getCurrentUser(String email) {
		// TODO Auto-generated method stub
		return this.urepo.getUserByEmail(email);
	}

}
