package com.surya.app;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.surya.entity.Employee;

public class Main {
	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
//		Employee m=new Employee();
//		m.setId(1);
//		m.setName("sury");
//		m.setId(2);
//		m.setName("surya");
//		session.save(m);
//		Employee e=session.find(com.surya.entity.Employee.class, 2);
		tx.commit();
		tx=session.beginTransaction();
		Employee m=new Employee();
//		m.setId(1222);
		m.setName("surya mid");
		int x=(int)session.save(m);
		
		tx.commit();
		
		System.out.println(configuration.getProperties()+"confgf");
		StandardServiceRegistryBuilder builder=configuration.getStandardServiceRegistryBuilder();
        builder=builder.applySettings(configuration.getProperties());
        ServiceRegistry registry=builder.build();
        factory=configuration.buildSessionFactory(registry);
        session=factory.openSession();
        tx=session.beginTransaction();
        
        Employee m1=new Employee();
//		m1.setId(12123);
		m1.setName("surya mid22");
		session.save(m1);
		tx.commit();
	
//		System.out.println(e.getName());
	
		//oracle
		
		Configuration configuration2=new Configuration();
		configuration2.configure("com/surya/resources/oracle.cfg.xml");
		SessionFactory factory2=configuration2.buildSessionFactory();
		Session session2=factory2.openSession();
		Transaction transaction=session2.beginTransaction();
		Employee oracleEmp=new Employee();
		oracleEmp.setName("oracle");
		session2.save(oracleEmp);
		transaction.commit();
		
	}

}
