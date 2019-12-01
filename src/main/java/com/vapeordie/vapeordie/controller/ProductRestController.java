package com.vapeordie.vapeordie.controller;

import com.vapeordie.vapeordie.model.Category;
import com.vapeordie.vapeordie.model.Product;
import com.vapeordie.vapeordie.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducst();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id")long idProduct){
        return productService.getProductById(idProduct);
    }
    @PostMapping("/products/{idCategory}")
    public Product addProduct(@RequestBody Product product,@PathVariable("idCategory") long idCategory){
        return productService.addProduct(product,idCategory);
    }
    @PutMapping("/products/{idCategory}/{idProduct}")
    public void updateProduct(@RequestBody Product product,@PathVariable("idProduct") long idProduct,@PathVariable("idCategory") long idCategory){
        productService.updateProduct(product,idProduct,idCategory);
    }
    @DeleteMapping("/products/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/products/categoriesList")
    public List<Category> getAllCategories(){
        return productService.getAllCategories();
    }
}
