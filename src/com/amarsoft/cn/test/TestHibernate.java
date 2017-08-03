package com.amarsoft.cn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amarsoft.cn.dao.Websites;

public class TestHibernate {

	public static void main(String[] args) {
		// ����session����
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//��session
		Session s=sf.openSession();
		s.beginTransaction();
//����һ������		
		Websites wb=new Websites();
		wb.setName("360");//��վ����
		wb.setUrl("www.360.com");//��ַ
		wb.setAlexa(45);
		wb.setCountry("CN");//����
		s.save(wb);//��������
		

		
		s.getTransaction().commit();//�ύ����
		s.close();
		sf.close();
	}

}
