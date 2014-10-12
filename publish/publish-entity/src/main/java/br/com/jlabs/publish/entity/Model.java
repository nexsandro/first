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
@Table(name="TB_MODL")
public class Model implements Entity {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -4537088233091182543L;

	/**
	 * Model id.
	 */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SE_MODL")
    @SequenceGenerator(name="SE_MODL", allocationSize=1, initialValue=1, sequenceName="SE_MODL")
    @Column(name="sq_modl")
	private Long id;
	
	/**
	 * Model name.
	 */
    @Column(name="no_name", nullable=false, length=255)
	private String name;
	
	/**
	 * 
	 */
    @Version
    @Column(name="nu_vers", length=10)
	private Integer version;
	
	/**
	 * Default constructor
	 */
	public Model() {
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
	    Model other = (Model) obj;
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
	    return "Model [id=" + id + ", name=" + name + "]";
    }

}
