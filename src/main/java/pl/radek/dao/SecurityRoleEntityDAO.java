package pl.radek.dao;

import java.util.List;

import pl.radek.model.SecurityRoleEntity;

public interface SecurityRoleEntityDAO {

	SecurityRoleEntity getSecurityRoleEntityById(Integer id);

	void removeSecurityRoleEntity(Integer id);

	List<SecurityRoleEntity> listSecurityRoleEntity();

	void addSecurityRoleEntity(SecurityRoleEntity securityRoleEntity);

}
