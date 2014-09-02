package br.com.jlabs.publish.entity.view;

/**
 * Simple view of company.
 * 
 * @author sandro
 *
 */
public class CompanyView {

	/**
	 * Company.id
	 */
	private Long id;

	/**
	 * Company.name
	 */
	private String name;
	
	/**
	 * Company.cnpj
	 */
	private String cnpj;
	
	/**
	 * Additional information.
	 */
	private String comment;
	
	/**
	 * Optimistic lock control
	 */
	private Integer version;
	
	/**
	 * Default constructor
	 */
	public CompanyView() {
		super();
	}
	
	/**
	 * Constructor with fields.
	 * @param id
	 * @param name
	 * @param cnpj
	 */
	public CompanyView(Long id, String name, String cnpj) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
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
	 * @return the cnpj
	 */
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
	 * @return the comment
	 */
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
	
}
