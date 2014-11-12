package br.com.jlabs.publish.web.control.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jlabs.publish.business.product.ProductBusiness;
import br.com.jlabs.publish.entity.Product;

@Controller
@RequestMapping(value="/rest")
public class ProductRestController {

	@Autowired
	private ProductBusiness productBusiness;

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public @ResponseBody List<Product> search() {
		
		return productBusiness.findAll();
		
	}
	
	@RequestMapping(value="/products/name={partialName}", method=RequestMethod.GET)
	public @ResponseBody List<Product> search(@PathVariable("partialName") String partialName) {
		
		return productBusiness.search(partialName);
	}
	
	@RequestMapping(value="/product/{productId}", method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long productId) {

		productBusiness.delete(productId);
		
	}

	@RequestMapping(value="/products", method=RequestMethod.POST)
	public @ResponseBody Product save(@RequestBody Product product) {
		
		productBusiness.save(product);
		
		return product;
		
	}

	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public @ResponseBody Product get(@PathVariable Long id) {

		return productBusiness.findOne("id", id, new String[] {"brand", "manufacturer"});
		
	}	
}
