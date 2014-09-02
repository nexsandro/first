/**
 * 
 */
package br.com.jlabs.publish.search.company;

import java.io.Serializable;

/**
 * @author sandro
 *
 */
public class CompanySearchFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7658111250130687743L;
	
	/**
	 * Search company by text excerpt.
	 */
	public String text;

	/**
	 * Constructor with fields
	 * @param text text to search for
	 */
	public CompanySearchFilter(String text) {
		super();
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
