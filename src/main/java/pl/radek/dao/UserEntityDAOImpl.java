package pl.radek.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.radek.model.SecurityRoleEntity;
import pl.radek.model.UserEntity;

@Repository
public class UserEntityDAOImpl implements UserEntityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(UserEntity user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public UserEntity findByName(String username) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession()
				.createQuery("select u from UserEntity u where u.username = '" + username + "'").uniqueResult();
		return user;
	}

	@Override
	public UserEntity getUserByID(Integer id) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().createQuery("select u from UserEntity u where id = '" + id + "'")
				.uniqueResult();
		return user;
	}

	@Override
	public String activateUser(Integer id) {
		String hql = "update UserEntityset active = :active where id = :id";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("active", "Y");
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		return "";
	}

	@Override
	public String disableUser(Integer id) {
		String hql = "update UserEntity set active = :active where id = :id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("active", 0);
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		return "";
	}

	@Override
	public void updateUser(UserEntity user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
	}

	@Override
	public void removeUser(Integer id) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().load(UserEntity.class, id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public Set<SecurityRoleEntity> getSecurityRolesForUsername(String username) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession()
				.createQuery("select u from UserEntity u where u.username = '" + username + "'").uniqueResult();
		if (user != null) {
			Set<SecurityRoleEntity> roles = (Set<SecurityRoleEntity>) user.getSecurityRoleCollection();
			if (roles != null && roles.size() > 0) {
				return roles;
			}
		}
		return null;
	}
}