package com.manh.lm.dao;




import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manh.lm.service.SessionFactoryService;

public class UserService {

	public static final String colors[]={"#4668C5","#55D455","#FF892A","#E81123","#00BCEF","#FFB900"};
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	


	public void defaultFunction(){
		

		Session session = null;




		try{


			session =SessionFactoryService.getSession();
			Transaction tx=session.getTransaction();

			tx.begin();
			

			tx.commit();


		}
		catch(Exception e){			
			e.printStackTrace();
		}
		finally{
			// Actual content insertion will happen at this step
			if(session!=null)
			{
				session.flush();				
				session.close();
			}
		}

	}



	
}
