package br.com.jlabs.publish.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@javax.persistence.Entity
@Table(name="TB_BRND")
public class Brand implements Entity {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -309205390280517565L;

	/**
	 * Brand id.
	 */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SE_BRND")
    @SequenceGenerator(name="SE_BRND", allocationSize=1, initialValue=1, sequenceName="SE_BRND")
    @Column(name="sq_brnd", length=12)
	private Long id;
	
	/**
	 * Brand name.
	 */
    @Column(name="no_name", nullable=false, length=255)
	private String name;
	
	/**
	 * Brand version
	 */
    @Version
    @Column(name="no_vers", nullable=false, length=12)
	private Integer version;
	
	/**
	 * Constructor with fields.
	 */
	public Brand() {
	    super();
    }

	/**
	 * Constructor with fields.
	 * @param id brand id
	 * @param name brand name
	 */
	public Brand(Long id, String name, Integer version) {
	    super();
	    this.id = id;
	    this.name = name;
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
	    Brand other = (Brand) obj;
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
	    return "Brand [id=" + id + ", name=" + name + "]";
    }

}
