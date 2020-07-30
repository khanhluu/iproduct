package com.icom.product.cmdRunner;

import java.util.Arrays;

import com.icom.product.model.Product;
import com.icom.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.icom.product.model.Category;
import com.icom.product.repository.CategoryRepository;

/**
 * @author
 * Data samples for Dev profile
 */
@Component
@Order(1)
@Profile(value = {"dev", "local"})
public class DataSampleInitRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(DataSampleInitRunner.class);
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
    ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Init sample data");
		initCategory();
		initProduct();
	}

	@Transactional
	protected void initCategory() {
		Category computerCategory = new Category();
		computerCategory.setCategoryCode("COM");
		computerCategory.setCategoryName("Computer");
		
		Category foodCategory = new Category();
		foodCategory.setCategoryCode("FOO");
		foodCategory.setCategoryName("Food and Beverage");
		
		categoryRepository.save(computerCategory);
		categoryRepository.save(foodCategory);
	}
	
	@Transactional
	protected void initProduct() {
		Category comCate = categoryRepository.findByCategoryCode("COM");
		Category fooCate = categoryRepository.findByCategoryCode("FOO");
		
		Product dellLatitude = new Product();
		dellLatitude.setCategory(comCate);
		dellLatitude.setDescription("Dell Latitude");
		dellLatitude.setProductName("Dell Latitude");
		dellLatitude.setInStock(100);
		dellLatitude.setPrice(1000);
		
		Product asusRog = new Product();
		asusRog.setCategory(comCate);
		asusRog.setDescription("ASUS ROG");
		asusRog.setProductName("ASUS ROG");
		asusRog.setInStock(100);
		asusRog.setPrice(1000);
		
		Product banana = new Product();
		banana.setCategory(fooCate);
		banana.setDescription("Banana from La ba");
		banana.setProductName("Banana from La ba");
		banana.setInStock(1000);
		banana.setPrice(10);
		
		Product apple = new Product();
		apple.setCategory(fooCate);
		apple.setDescription("USA Apple");
		apple.setProductName("USA Apple");
		apple.setInStock(1000);
		apple.setPrice(10);
		
		productRepository.saveAll(Arrays.asList(dellLatitude, asusRog, banana, apple));
		
	}
}
