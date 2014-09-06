package br.com.jlabs.publish.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@javax.persistence.Entity
@Table(name="TB_ADDR")
public class Address implements Entity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1415460243177287335L;

	/**
	 * Address id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SE_ADDR")
	@SequenceGenerator(name="SE_ADDR", sequenceName="SE_ADDR", allocationSize=1, initialValue=1)
	@Column(name="sq_addr", length=12)
	private Long id;
	
	/**
	 * City.
	 */
	@Column(name="no_city", length=255)
	private String city;
	
	/**
	 * State.
	 */
	@Column(name="no_stat", length=2)
	private String state;
	
	/**
	 * Country.
	 */
	@Column(name="no_cntr", length=255)
	private String country;
	
	/**
	 * Street.
	 */
	@Column(name="no_stre", length=255)
	private String street;
	
	/**
	 * Number.
	 */
	@Column(name="no_numb", length=10)
	private String number;
	
	/**
	 * Extra information to locate the address
	 */
	@Column(name="no_extr", length=600)
	private String extra;
	
	/**
	 * CEP
	 */
	@Column(name="no_cep", length=8)
	private String cep;
	
	/**
	 * Optimistick lock control.
	 */
	@Version
	@Column(name="nu_vers", length=10)
	private Integer version;
	
	public Address() {
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
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
		Address other = (Address) obj;
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
	    return "Address [id=" + id + ", city=" + city + ", state=" + state
	            + ", country=" + country + ", street=" + street + ", number="
	            + number + ", extra=" + extra + ", cep=" + cep + ", version="
	            + version + "]";
    }
}
