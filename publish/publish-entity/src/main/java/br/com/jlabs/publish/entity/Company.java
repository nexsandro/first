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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@javax.persistence.Entity
@Table(name="TB_COMP")
public class Company implements Entity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 3482659694515211890L;

	/**
	 * Id, key.
	 */
	private Long id;
	
	/**
	 * Name.
	 */
	private String name;
	
	/**
	 * CNPJ.
	 */
	private String cnpj;
	
	/**
	 * Address.
	 */
	private Address address;
	
	/**
	 * Comments.
	 */
	private String comment;
	
	/**
	 * Products.
	 */
	private Set<Product> products;
	
	/**
	 * 
	 */
	private Set<MarketSegment> marketSegments;
	
	/**
	 * Company Version.
	 */
	private Integer version;
	
	/**
	 * Default constructor
	 */
	public Company() {
		super();
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SE_COMP")
	@SequenceGenerator(name="SE_COMP", sequenceName="SE_COMP", allocationSize=1, initialValue=1)
	@Column(name="sq_comp",  length=11)
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
	 * @return the nameString
	 */
	@Column(name="no_name", length=400)
	public String getName() {
		return name;
	}

	/**
	 * @param nameString the nameString to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cnpj
	 */
	@Column(name="no_cnpj", length=14)
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the address
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_addr")
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the comment
	 */
	@Column(name="tx_comm")
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the products
	 */
	@ManyToMany
	@JoinTable(name="TB_COMP_PRDT",
			joinColumns=@JoinColumn(name="sq_comp", referencedColumnName="sq_comp"),
			inverseJoinColumns=@JoinColumn(name="sq_prdt", referencedColumnName="sq_prdt"))
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * @return the marketSegments
	 */
	@ManyToMany
	@JoinTable(name="TB_COMP_MRKT_SEGM",
		joinColumns=@JoinColumn(name="sq_comp", referencedColumnName="sq_comp"),
		inverseJoinColumns=@JoinColumn(name="sq_mrkt_segm", referencedColumnName="sq_mrkt_segm"))
	public Set<MarketSegment> getMarketSegments() {
		return marketSegments;
	}

	/**
	 * @param marketSegments the marketSegments to set
	 */
	public void setMarketSegments(Set<MarketSegment> marketSegments) {
		this.marketSegments = marketSegments;
	}

	/**
	 * @return the version
	 */
	@Version
	@Column(name="nu_vers")
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
		Company other = (Company) obj;
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
	    return "Company [id=" + id + ", name=" + name + ", cnpj=" + cnpj
	            + ", address=" + address + ", comment=" + comment
	            + ", products=" + products + ", marketSegments="
	            + marketSegments + ", version=" + version + "]";
    }

}
