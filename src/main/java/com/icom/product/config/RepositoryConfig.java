package com.icom.product.config;

import com.icom.product.model.Product;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import com.icom.product.model.Category;

/**
 * @author Khanh Luu
 *
 */

@Component
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Product.class,
				Category.class);
	}

	
}
