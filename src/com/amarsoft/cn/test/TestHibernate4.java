package com.amarsoft.cn.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amarsoft.cn.dao.Product;
import com.amarsoft.cn.dao.User;

public class TestHibernate4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s =sf.openSession();
		s.beginTransaction();
		//测试多对多关系
		 //增加3个用户
        Set<User> users = new HashSet();
        for (int i = 0; i < 3; i++) {
            User u =new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }
        
        //产品1被用户1,2,3购买
        Product p1 =(Product) s.get(Product.class, 1);
		p1.setUsers(users);
		s.save(p1);
        
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}
