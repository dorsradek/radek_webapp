package pl.radek.service;

import java.util.List;

import pl.radek.model.SecurityRoleEntity;

public interface SecurityRoleEntityService {

	void removeSecurityRoleEntity(Integer id);

	SecurityRoleEntity getSecurityRoleEntityById(Integer id);

	List<SecurityRoleEntity> listSecurityRoleEntity();

	void addSecurityRoleEntity(SecurityRoleEntity securityRoleEntity);

}
