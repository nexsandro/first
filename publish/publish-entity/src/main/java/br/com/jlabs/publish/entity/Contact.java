package br.com.jlabs.publish.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@javax.persistence.Entity
@Table(name="TB_CTCT")
public class Contact implements Entity {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -7232692322460031290L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SE_CTCT")
	@SequenceGenerator(name="SE_CTCT", sequenceName="SE_CTCT", allocationSize=1, initialValue=1)
	@Column(name="sq_ctct", length=12)
	private Long id;
	
	@Column(name="no_name", length=255)
	private String name;
	
	@Column(name="no_fon1", length=12)
	private String fone1;
	
	@Column(name="no_fon2", length=12)
	private String fone2;
	
	@Column(name="no_mai1", length=255)
	private String email1;
	
	@Column(name="no_mai2", length=255)
	private String email2;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="sq_comp", referencedColumnName="sq_comp")
	private Company company;

	@Version
	@Column(name="nu_vers", length=12)
	private Integer version;
	
	/**
	 * 
	 */
	public Contact() {
	    super();
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
	 * @return the fone1
	 */
	public String getFone1() {
		return fone1;
	}

	/**
	 * @param fone1 the fone1 to set
	 */
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	/**
	 * @return the fone2
	 */
	public String getFone2() {
		return fone2;
	}

	/**
	 * @param fone2 the fone2 to set
	 */
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	/**
	 * @return the email1
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @param email1 the email1 to set
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/**
	 * @return the email2
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2 the email2 to set
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
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
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
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
	    Contact other = (Contact) obj;
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
	    return "Contact [id=" + id + ", name=" + name + ", fone1=" + fone1
	            + ", fone2=" + fone2 + ", email1=" + email1 + ", email2="
	            + email2 + ", version=" + version + "]";
    }

}
