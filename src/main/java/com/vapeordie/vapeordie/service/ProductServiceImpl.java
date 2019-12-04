package com.vapeordie.vapeordie.service;

import com.vapeordie.vapeordie.model.Category;
import com.vapeordie.vapeordie.model.Product;
import com.vapeordie.vapeordie.repository.CategoryRepository;
import com.vapeordie.vapeordie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducst() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product productDetails, Long idProduct, Long idCategory) {
        Product product = productRepository.findById(idProduct).get();
        Category category = categoryRepository.findById(idCategory).get();
        product.setCategory(category);
        product.setDescription(productDetails.getDescription());
        product.setImage(productDetails.getImage());
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        Category category = categoryRepository.findById(product.getCategory().getIdCategory()).get();
        product.setCategory(category);
        productRepository.delete(product);
    }

    @Override
    public Product addProduct(Product product, Long idCategory) {
        Category category = categoryRepository.findById(idCategory).get();
        product.setCategory(category);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

	@Override
	public List<Product> findByCategorie(Long idCategory) {
		// TODO Auto-generated method stub
		return productRepository.findByCategorie(idCategory);
	}
}
