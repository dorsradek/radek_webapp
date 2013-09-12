package pl.radek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.radek.dao.SecurityRoleEntityDAO;
import pl.radek.model.SecurityRoleEntity;
import pl.radek.service.SecurityRoleEntityService;

@Service
public class SecurityRoleEntityServiceImpl implements SecurityRoleEntityService {

	@Autowired
	private SecurityRoleEntityDAO securityRoleEntityDAO;

	@Transactional
	@Override
	public void addSecurityRoleEntity(SecurityRoleEntity securityRoleEntity) {
		securityRoleEntityDAO.addSecurityRoleEntity(securityRoleEntity);
	}

	@Transactional
	@Override
	public List<SecurityRoleEntity> listSecurityRoleEntity() {
		return securityRoleEntityDAO.listSecurityRoleEntity();
	}

	@Transactional
	@Override
	public void removeSecurityRoleEntity(Integer id) {
		securityRoleEntityDAO.removeSecurityRoleEntity(id);
	}

	@Transactional
	@Override
	public SecurityRoleEntity getSecurityRoleEntityById(Integer id) {
		return securityRoleEntityDAO.getSecurityRoleEntityById(id);
	}
}