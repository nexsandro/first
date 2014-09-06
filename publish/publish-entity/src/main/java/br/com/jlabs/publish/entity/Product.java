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
@Table(name="TB_PRDT")
public class Product implements Entity {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -5977464661575138898L;

	/**
	 * Product Id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SE_PRDT")
	@SequenceGenerator(name="SE_PRDT", allocationSize=1, initialValue=1, sequenceName="SE_PRDT")
	@Column(name="sq_prdt", length=12)
	private Long id;
	
	/**
	 * Product Name.
	 */
	@Column(name="no_name", nullable=false, length=255)
	private String name;
	
	/**
	 * Product brand.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_brnd", referencedColumnName="sq_brnd")
	private Brand brand;
	
	/**
	 * Product Manufacturer.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_manf", referencedColumnName="sq_manf")
	private Manufacturer manufacturer;
	
	/**
	 * Product version.
	 */
    @Version
    @Column(name="no_vers", nullable=false, length=12)
    private Integer version;
    
	/**
	 * Default constructor.
	 */
	public Product() {
	    super();
    }

	/**
	 * Constructor with fields.
	 * @param id id
	 * @param name name
	 * @param brand brand
	 * @param manufacturer manufacturer
	 */
	public Product(Long id, String name, Brand brand, Manufacturer manufacturer, Integer version) {
	    super();
	    this.id = id;
	    this.name = name;
	    this.brand = brand;
	    this.manufacturer = manufacturer;
		this.version = version;
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
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
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
	    Product other = (Product) obj;
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
	    return "Product [id=" + id + ", name=" + name + ", brand=" + brand
	            + ", manufacturer=" + manufacturer + "]";
    }

}
