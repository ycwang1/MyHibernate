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
		SessionFactory sf = new Configuration().configure().buildSessionFactory();//��������
		Session s=sf.openSession();
		s.beginTransaction();
		//����һ��	
//		Category cg = new Category();  
//		cg.setName("aojfoiidsjfis");//cgΪ˲ʱ״̬
//		s.save(cg);
//cgΪ�־�״̬
	
		//ѭ������10��
//		for(int i=0;i<10;i++){
//			Category cg = new Category();
//			cg.setName("aojfoiidsjfis"+i);
//			s.save(cg);
//		}
		
		//����id����
//		Category category=(Category) s.get(Category.class, 2);
//		System.out.println("idΪ2�������ǣ�"+category.getName());
		
//		//ɾ��һ������
//		Category category=(Category) s.get(Category.class, 2);
//		s.delete(category);
		
//		//�޸�һ������
//		Category cg = (Category) s.get(Category.class, 3);
//		System.out.println("�޸�ǰidΪ3�������ǣ�"+cg.getName());
//		cg.setName("helloworld");
//		s.save(cg);
		
//		//ͨ��hql��ѯ���ݿ�
//		String name = "aojfoiidsjfis";
//		Query q=s.createQuery("from Category c where c.name like ?");
//		q.setString(0,"%"+ name+"%");
//		List<Category> list =q.list();
//		for(Category cg :list){
//			System.out.println(cg.getName());
//		}
		
		//ͨ��creteria��ѯ���ݿ�
		String name = "aojfoiidsjfis";
		Criteria c = s.createCriteria(Category.class);
		c.add(Restrictions.like("name", "%"+name+"%"));
		c.setFirstResult(2);//��ҳ���ӵ�2����ʼ��һ����ѯ5��category
		c.setMaxResults(5);
		List<Category>list = c.list();
		for(Category cg :list){
			System.out.println(cg.getName());
		}
//		
		
//		//ʹ�ñ�׼sql��ѯ
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
//		//����many-to-one��ϵ
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
		//cgΪ�ѹ�״̬
		sf.close();
	}

}
