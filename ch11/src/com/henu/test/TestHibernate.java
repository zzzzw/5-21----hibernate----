package com.henu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.henu.domain.Person;
public class TestHibernate {
	public static void main(String args[])
	{
		//实例化一个Configuration对象
		Configuration cfg = new Configuration();
		/*Configuration对象加载Hibernate配置文件，并构建一个会话工厂SessionFactory*/
		SessionFactory sf = cfg.configure().buildSessionFactory();
		//由会话工厂打开一个会话
		Session session = sf.openSession();
		//由会话开启一个事务对象
		Transaction tx = session.beginTransaction();
		//实例化一个Person对象
		Person tom = new Person();
		tom.setName("Tom");
		tom.setAge(29);
		tom.setMajor("Computer Science");
		//持久化Person对象
		session.save(tom);
		tx.commit();
		session.close();	
}
}
