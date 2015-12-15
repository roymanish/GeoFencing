package com.manh.lm.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

final public class SessionFactoryService {

	private SessionFactory sessionFactory; 


	private static SessionFactoryService singletonInstance;
	//make it a singleton class
	private SessionFactoryService() throws Exception {
		if(sessionFactory==null)
		{
			// This step will read hibernate.cfg.xml and prepare hibernate for use			
			try 
			{	

				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				
				
				//Config changes for openshift redhat server

				String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
				String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");	
				if(host!=null && host.length()>0 && port!=null && port.length()>0)
					configuration.setProperty("hibernate.connection.url", "jdbc:mysql://"+host+":"+port+"/bitsaa?autoReconnect=true&createDatabaseIfNotExists=true&useUnicode=true&characterEncoding=UTF-8");

				StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(ssrb.build());

			} 
			catch (Exception e)
			{
				e.printStackTrace();
				throw e;				
			}
		}
	}


	public static Session getSession() throws Exception
	{	
		if(singletonInstance==null)
			singletonInstance=new SessionFactoryService();
		Session session=null;
		try
		{
			session=singletonInstance.sessionFactory.openSession();

			if(!session.isConnected()){
				//retry the same by creating a new session factory
				singletonInstance=new SessionFactoryService();
				session=singletonInstance.sessionFactory.openSession();
			}
			if(session.isDirty())
			{
				//retry the same by creating a new session factory
				singletonInstance=new SessionFactoryService();
				session=singletonInstance.sessionFactory.openSession();
			}
		}
		catch(Exception e)
		{
			//retry the same by creating a new session factory
			singletonInstance=new SessionFactoryService();
			session=singletonInstance.sessionFactory.openSession();
		}
		
		return session;
	}



	public void finalize() 
	{

		if(sessionFactory!=null)
		{
			sessionFactory.close();		
			sessionFactory=null;
		}

		try 
		{
			super.finalize();
		} 
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

}
