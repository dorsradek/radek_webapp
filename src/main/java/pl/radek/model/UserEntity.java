package pl.radek.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
		@NamedQuery(name = "UserEntity.findById", query = "SELECT u FROM UserEntity u WHERE u.id = :id"),
		@NamedQuery(name = "UserEntity.findByFirstName", query = "SELECT u FROM UserEntity u WHERE u.firstName = :firstName"),
		@NamedQuery(name = "UserEntity.findByFamilyName", query = "SELECT u FROM UserEntity u WHERE u.familyName = :familyName"),
		@NamedQuery(name = "UserEntity.findByDob", query = "SELECT u FROM UserEntity u WHERE u.dob = :dob"),
		@NamedQuery(name = "UserEntity.findByPassword", query = "SELECT u FROM UserEntity u WHERE u.password = :password"),
		@NamedQuery(name = "UserEntity.findByUsername", query = "SELECT u FROM UserEntity u WHERE u.username = :username"),
		@NamedQuery(name = "UserEntity.findByConfirmPassword", query = "SELECT u FROM UserEntity u WHERE u.confirmPassword = :confirmPassword"),
		@NamedQuery(name = "UserEntity.findByActive", query = "SELECT u FROM UserEntity u WHERE u.active = :active") })
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "family_name")
	private String familyName;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Basic(optional = false)
	@Column(name = "password")
	private String password;

	@Basic(optional = false)
	@Column(name = "username")
	private String username;

	@Basic(optional = false)
	@Column(name = "confirm_password")
	private String confirmPassword;

	@Basic(optional = false)
	@Column(name = "active")
	private boolean active;

	@JoinTable(name = "user_security_role", joinColumns = {

	@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {

	@JoinColumn(name = "security_role_id", referencedColumnName = "id") })
	@ManyToMany
	private Set<SecurityRoleEntity> securityRoleCollection;

	public UserEntity() {
	}

	public UserEntity(Integer id) {
		this.id = id;
	}

	public UserEntity(Integer id, String password, String username, String confirmPassword, boolean active) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.confirmPassword = confirmPassword;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<SecurityRoleEntity> getSecurityRoleCollection() {
		return securityRoleCollection;
	}

	public void setSecurityRoleCollection(Set<SecurityRoleEntity> securityRoleCollection) {
		this.securityRoleCollection = securityRoleCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserEntity)) {
			return false;
		}
		UserEntity other = (UserEntity) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.intan.pedigree.form.User[id=" + id + "]";
	}

}