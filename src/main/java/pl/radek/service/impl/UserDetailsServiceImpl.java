package pl.radek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.radek.dao.UserEntityDAO;
import pl.radek.model.UserEntity;
import pl.radek.service.Assembler;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserEntityDAO dao;

	@Autowired
	private Assembler assembler;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserEntity userEntity = dao.findByName(username);
		if (userEntity == null)
			throw new UsernameNotFoundException("user not found");
		return assembler.buildUserFromUserEntity(userEntity);
	}

}