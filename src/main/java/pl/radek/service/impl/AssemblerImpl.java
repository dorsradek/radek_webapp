package pl.radek.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.radek.model.SecurityRoleEntity;
import pl.radek.model.UserEntity;
import pl.radek.service.Assembler;

@Service("assembler")
public class AssemblerImpl implements Assembler {

	@Transactional(readOnly = true)
	@Override
	public User buildUserFromUserEntity(UserEntity userEntity) {
		String username = userEntity.getUsername();
		String password = userEntity.getPassword();
		boolean enabled = userEntity.getActive();
		boolean accountNonExpired = userEntity.getActive();
		boolean credentialsNonExpired = userEntity.getActive();
		boolean accountNonLocked = userEntity.getActive();
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (SecurityRoleEntity role : userEntity.getSecurityRoleCollection()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return user;
	}
}