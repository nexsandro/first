/**
 * 
 */
package br.com.jlabs.publish.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author sandro
 *
 */
@javax.persistence.Entity
@Table(name="TB_MANF")
public class Manufacturer implements Entity {


	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -918378452179096046L;

	/**
	 * Keyword id.
	 */
	private Long id;
	
	/**
	 * Keyword name.
	 */
	private String name;
	
    /**
     * Manufacturer version.
     */
    private Integer version;
	
	/**
	 * Default constructor
	 */
	public Manufacturer() {
	    super();
    }
	
	/**
	 * Constructor with fields.
	 * @param id keyword id
	 * @param name keyword name
	 */
	public Manufacturer(Long id, String name, Integer version) {
	    super();
	    this.id = id;
	    this.name = name;
		this.version = version;
    }
	
	/**
	 * @return the id
	 */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SE_MANF")
    @SequenceGenerator(name="SE_MANF", allocationSize=1, initialValue=1, sequenceName="SE_MANF")
    @Column(name="sq_manf")
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
    @Column(name="no_name", nullable=false)
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
	 * @return the version
	 */
    @Version
    @Column(name="no_vers", nullable=false)
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
	    Manufacturer other = (Manufacturer) obj;
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
	    return "Manufacturer [id=" + id + ", name=" + name + "]";
    }
	
}
