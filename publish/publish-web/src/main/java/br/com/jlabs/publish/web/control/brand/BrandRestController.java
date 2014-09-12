package br.com.jlabs.publish.web.control.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jlabs.publish.business.brand.BrandBusiness;
import br.com.jlabs.publish.entity.Brand;

@Controller
@RequestMapping(value="/rest")
public class BrandRestController {

	@Autowired
	private BrandBusiness brandBusiness;

	@RequestMapping(value="/brands", method=RequestMethod.GET)
	public @ResponseBody List<Brand> search() {
		
		return brandBusiness.list();
		
	}

	@RequestMapping(value="/brands", method=RequestMethod.POST)
	public @ResponseBody Brand save(@RequestBody Brand brand) {
		
		brandBusiness.save(brand);
		
		return brand;
		
	}
	
	@RequestMapping(value="/brand/{brandId}", method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long brandId) {

		brandBusiness.delete(brandId);
		
	}

	@RequestMapping(value="/brand/{id}", method=RequestMethod.GET)
	public @ResponseBody Brand get(@PathVariable Long id) {

		return brandBusiness.findOne(id);
		
	}	
}
