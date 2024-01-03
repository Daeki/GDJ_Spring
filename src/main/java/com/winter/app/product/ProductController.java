package com.winter.app.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void getList() {
		
	} 
	
	//detail
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public void getDetail(ProductDTO productDTO) {
		
	}

}
