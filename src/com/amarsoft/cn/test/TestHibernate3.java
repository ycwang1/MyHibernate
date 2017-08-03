package com.amarsoft.cn.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amarsoft.cn.dao.Category;
import com.amarsoft.cn.dao.Product;

public class TestHibernate3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();//创建工厂
		Session s=sf.openSession();
		s.beginTransaction();

//		//测试many-to-one关系
//		Websites wb = new Websites();
//		wb.setName("iphone8");
//		wb.setAlexa(8);	
//		wb.setCountry("US");
//		wb.setUrl("www.apple.com");
//		s.save(wb);
//		Category cg=(Category) s.get(Category.class, 8);
//		cg.setWebsites(wb);
	
		//测试one-to-many关系
		Category c =(Category)s.get(Category.class, 1);
		Set<Product> ps=c.getProducts();
		for(Product p:ps){
			System.out.println(p.getName());
		}
		
		
		
		
		
		s.getTransaction().commit();
		s.close();
		//cg为脱管状态
		sf.close();
	}

}
