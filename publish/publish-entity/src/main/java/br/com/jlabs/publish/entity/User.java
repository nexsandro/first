package br.com.jlabs.publish.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="TB_USER")
public class User implements Entity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8462381506247270618L;

	/**
	 * Id, key.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SE_USER")
	@SequenceGenerator(name="SE_USER", sequenceName="SE_USER", initialValue=1, allocationSize=1)
	@Column(name="sq_user", length=12)
	private Long id;
	
	/**
	 * Login.
	 */
	@Column(name="no_logn", length=255)
	private String login;
	
	/**
	 * Password.
	 */
	@Column(name="no_pass", length=255)
	private String password;
	
	/**
	 * Name
	 */
	@Column(name="no_name", length=255)
	private String name;
	
	/**
	 * Email.
	 */
	@Column(name="no_mail", length=255)
	private String email;

	/**
	 * Phone.
	 */
	@Column(name="no_phon", length=255)
	private String phone;
	
	/**
	 * Company.
	 */
	@OneToOne
	@JoinColumn(name="sq_comp", nullable=true)
	private Company company;
	
	/**
	 * Roles.
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="tb_user_role",
		joinColumns={@JoinColumn(name="sq_user", referencedColumnName="sq_user")},
		inverseJoinColumns={@JoinColumn(name="sq_role", referencedColumnName="sq_role")}
			)
	private Set<Role> roles;
	
	/**
	 * Version
	 */
	@Column(name="nu_vers", length=10)
	private String version;
	
	/**
	 * Default constructor
	 */
	public User() {
		super();
	}
	
	/**
	 * Constructor with fields
	 * @param logon
	 * @param password
	 */
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the logon
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param logon the logon to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", email=" + email + "]";
	}

}
