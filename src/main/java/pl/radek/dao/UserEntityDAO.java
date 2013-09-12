package pl.radek.dao;

import java.util.List;
import java.util.Set;

import pl.radek.model.SecurityRoleEntity;
import pl.radek.model.UserEntity;

public interface UserEntityDAO {

	void addUser(UserEntity user);

	UserEntity findByName(String username);

	UserEntity getUserByID(Integer id);

	String activateUser(Integer id);

	String disableUser(Integer id);

	void updateUser(UserEntity user);

	List<UserEntity> listUser();

	void removeUser(Integer id);

	Set<SecurityRoleEntity> getSecurityRolesForUsername(String username);

}
