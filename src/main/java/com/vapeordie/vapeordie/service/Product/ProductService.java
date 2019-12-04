package com.vapeordie.vapeordie.service.Product;

import com.vapeordie.vapeordie.model.Category;
import com.vapeordie.vapeordie.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducst();
    public void updateProduct(Product product, Long idProduct,Long idCategory);
    public void deleteProduct(Long id);
    public Product addProduct(Product product, Long idCategory);
    public Product getProductById(Long id);
    public List<Category> getAllCategories();
    public List<Product> findByCategorie(Long idCategory);
}
