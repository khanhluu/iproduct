package com.icom.product.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Khanh Luu
 * Product Entity
 */
@Entity
@Table
public class Product {

	@Id
	@Column(name = "PROD_ID")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID productId;
	
	@Column(name = "PROD_NAME")
	private String productName;
	
	@Column(name = "PROD_DESC")
	private String description;
	
	@Column(name = "PRICE")
	private double price;
	
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name = "categoryId")
	@RestResource(path = "categroy", rel = "category")
	private Category category;
	
	@Column(name = "IN_STOCK")
	private int inStock;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public UUID getProductId() {
		return productId;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
}
