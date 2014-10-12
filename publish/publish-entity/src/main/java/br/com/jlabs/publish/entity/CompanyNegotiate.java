/**
 * 
 */
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

/**
 * @author sandro
 *
 */
@javax.persistence.Entity
@Table(name="TB_COMP_NEGO")
public class CompanyNegotiate implements Entity {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = 7622734439820402598L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SE_COMP_NEGO")
	@SequenceGenerator(name="SE_COMP_NEGO", sequenceName="SE_COMP_NEGO", allocationSize=1, initialValue=1)
	@Column(name="sq_comp_nego", length=12)
	private Long id;
	
	/**
	 * Product brand.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_brnd", referencedColumnName="sq_brnd")
	private Brand brand;

	/**
	 * Product model.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_modl", referencedColumnName="sq_modl")
	private Model model;

	/**
	 * Company who negotiates.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_comp", referencedColumnName="sq_comp")
	private Company company;
	
	/**
	 * Products.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_prod", referencedColumnName="sq_prod")
	private Product product;

	/**
	 * Proposed value.
	 */
	@Column(name="value", nullable=true, precision=2, length=12)
	private Double value;
	
	@Column(name="in_actv", nullable=false)
	private Boolean active;
	
	@Version
	@Column(name="nu_vers", nullable=false)
	private Integer version;
	
	/**
	 * Default constructor
	 */
	public CompanyNegotiate() {
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
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
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
	    CompanyNegotiate other = (CompanyNegotiate) obj;
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
	    return "CompanyNegotiate [id=" + id + ", brand=" + brand + ", model="
	            + model + ", product=" + product + ", value=" + value
	            + ", active=" + active + "]";
    }

}
