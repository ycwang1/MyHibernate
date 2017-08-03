package com.amarsoft.cn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amarsoft.cn.dao.Websites;

public class TestHibernate {

	public static void main(String[] args) {
		// 建立session工厂
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//打开session
		Session s=sf.openSession();
		s.beginTransaction();
//插入一条数据		
		Websites wb=new Websites();
		wb.setName("360");//网站名称
		wb.setUrl("www.360.com");//网址
		wb.setAlexa(45);
		wb.setCountry("CN");//国家
		s.save(wb);//插入数据
		

		
		s.getTransaction().commit();//提交事物
		s.close();
		sf.close();
	}

}
