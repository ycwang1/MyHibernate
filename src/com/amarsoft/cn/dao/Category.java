package com.amarsoft.cn.dao;

import java.util.Set;

public class Category {
	int id;
	String name;
//	Websites websites;
//	public Websites getWebsites() {
//		return websites;
//	}
//	public void setWebsites(Websites websites) {
//		this.websites = websites;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   Set<Product> products;
    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
