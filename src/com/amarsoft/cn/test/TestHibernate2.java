package com.amarsoft.cn.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.amarsoft.cn.dao.Category;
import com.amarsoft.cn.dao.Websites;

public class TestHibernate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();//创建工厂
		Session s=sf.openSession();
		s.beginTransaction();
		//插入一条	
//		Category cg = new Category();  
//		cg.setName("aojfoiidsjfis");//cg为瞬时状态
//		s.save(cg);
//cg为持久状态
	
		//循环插入10条
//		for(int i=0;i<10;i++){
//			Category cg = new Category();
//			cg.setName("aojfoiidsjfis"+i);
//			s.save(cg);
//		}
		
		//根据id查找
//		Category category=(Category) s.get(Category.class, 2);
//		System.out.println("id为2的名称是："+category.getName());
		
//		//删除一条数据
//		Category category=(Category) s.get(Category.class, 2);
//		s.delete(category);
		
//		//修改一条数据
//		Category cg = (Category) s.get(Category.class, 3);
//		System.out.println("修改前id为3的名字是："+cg.getName());
//		cg.setName("helloworld");
//		s.save(cg);
		
//		//通过hql查询数据库
//		String name = "aojfoiidsjfis";
//		Query q=s.createQuery("from Category c where c.name like ?");
//		q.setString(0,"%"+ name+"%");
//		List<Category> list =q.list();
//		for(Category cg :list){
//			System.out.println(cg.getName());
//		}
		
		//通过creteria查询数据库
		String name = "aojfoiidsjfis";
		Criteria c = s.createCriteria(Category.class);
		c.add(Restrictions.like("name", "%"+name+"%"));
		c.setFirstResult(2);//分页，从第2个开始，一共查询5个category
		c.setMaxResults(5);
		List<Category>list = c.list();
		for(Category cg :list){
			System.out.println(cg.getName());
		}
//		
		
//		//使用标准sql查询
//		String name = "aojfoiidsjfis";
//		String sql = "select * from category where name like '%"+name+"%'";
//		Query q = s.createSQLQuery(sql);
//		List<Object[]>list = q.list();
//		for(Object[] o:list){
//			for(Object field:o){
//				System.out.println(field+"\t");
//			}
//			System.out.println();
//		}
//		
//		//测试many-to-one关系
//		Websites wb = new Websites();
//		wb.setName("iphone8");
//		wb.setAlexa(8);	
//		wb.setCountry("US");
//		wb.setUrl("www.apple.com");
//		s.save(wb);
//		
//		Category cg=(Category) s.get(Category.class, 8);
//		cg.setWebsites(wb);
		
		
		
		s.getTransaction().commit();
		s.close();
		//cg为脱管状态
		sf.close();
	}

}
