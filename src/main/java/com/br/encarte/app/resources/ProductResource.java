package com.br.encarte.app.resources;

import com.br.encarte.app.entity.Product;
import com.br.encarte.app.service.inter.ProductServiceAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arthur on 20/05/17.
 */
@RestController
@RequestMapping("/encarte/product")
public class ProductResource {

    private final ProductServiceAO productService;

    @Autowired
    public ProductResource(ProductServiceAO productService) {
        this.productService = productService;

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Product save(@RequestBody Product product) {
        this.productService.save(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Product update(@RequestBody Product product) {
        this.productService.update(product);
        return product;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public final String delete(@PathVariable("id") Long id) {
        this.productService.delete(id);
        return "{}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public final Product findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public final Iterable<Product> findAll() {
        return this.productService.listAll();
    }

}
