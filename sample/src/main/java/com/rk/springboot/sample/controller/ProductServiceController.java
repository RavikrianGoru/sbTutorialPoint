package com.rk.springboot.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springboot.sample.exception.ProductNotfoundException;
import com.rk.springboot.sample.model.Product;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductServiceController {
	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);

		Product ravi = new Product();
		ravi.setId("3");
		ravi.setName("Ravi");
		productRepo.put(ravi.getId(), ravi);

	}

	//@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}

	//Access to XMLHttpRequest at 'http://localhost:9090/products' from origin 'http://localhost:8080' has been blocked by 
	//CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' 
	//header is present on the requested resource.
	//@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productRepo.put(product.getId(), product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		if (!productRepo.containsKey(id)) {
			throw new ProductNotfoundException();
		}
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<Object>("Product is updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
		productRepo.remove(id);
		return new ResponseEntity<Object>("Product is deleted successfully", HttpStatus.OK);
	}
}
