package pl.radek.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.radek.dao.SecurityRoleEntityDAO;
import pl.radek.model.SecurityRoleEntity;

@Repository
public class SecurityRoleEntityDAOImpl implements SecurityRoleEntityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addSecurityRoleEntity(SecurityRoleEntity securityRoleEntity) {
		try {
			sessionFactory.getCurrentSession().save(securityRoleEntity);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityRoleEntity> listSecurityRoleEntity() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SecurityRoleEntity.class);
		criteria.add(Restrictions.ne("name", "ROLE_ADMIN"));
		return criteria.list();
	}

	@Override
	public SecurityRoleEntity getSecurityRoleEntityById(Integer id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SecurityRoleEntity.class);
		criteria.add(Restrictions.eq("id", id));
		return (SecurityRoleEntity) criteria.uniqueResult();
	}

	@Override
	public void removeSecurityRoleEntity(Integer id) {
		SecurityRoleEntity securityRoleEntity = (SecurityRoleEntity) sessionFactory.getCurrentSession().load(SecurityRoleEntity.class, id);
		if (null != securityRoleEntity) {
			sessionFactory.getCurrentSession().delete(securityRoleEntity);
		}
	}
}