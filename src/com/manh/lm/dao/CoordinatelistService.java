package com.manh.lm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manh.lm.domain.Coordinates;
import com.manh.lm.entity.CoordinatesEntity;
import com.manh.lm.service.SessionFactoryService;

public class CoordinatelistService {
	
	private static List<Coordinates> coordinateList = new ArrayList<Coordinates>();
	
	static
	{
		Coordinates coordinates = new Coordinates(null,12.56,77.98,12.58,77.99,"L1");
		coordinateList.add(coordinates);
		
		 coordinates = new Coordinates(null,12.00,74.00,12.10,74.99,"L1");
		coordinateList.add(coordinates);
		
		 coordinates = new Coordinates(null,12.11,77.00,12.20,77.30,"L2");
		coordinateList.add(coordinates);
		
		 coordinates = new Coordinates(null,12.21,77.40,12.30,77.45,"L3");
		coordinateList.add(coordinates);
		
		 coordinates = new Coordinates(null,12.31,77.46,12.40,77.50,"L4");
		coordinateList.add(coordinates);
		
		 coordinates = new Coordinates(null,12.41,77.51,12.50,77.60,"L5");
		coordinateList.add(coordinates);
		
		 coordinates = new Coordinates(null,12.51,77.61,13.99,80.00,"L6");
		coordinateList.add(coordinates);
	}
	
	public List<Coordinates> getcoordinates()
	{
		System.out.println("getcoordinatelist Called");
		return coordinateList;
	}
	
	
	public void saveCoordinates(Coordinates c) throws Exception{


		Session session = null;




		try{


			session =SessionFactoryService.getSession();
			Transaction tx=session.getTransaction();

			tx.begin();


			CoordinatesEntity e=new CoordinatesEntity(null,c.getLat1(), c.getLng1(), c.getLat2(), c.getLng2(), c.getName());

			session.save(e);

			tx.commit();


		}
		catch(Exception e){			
			e.printStackTrace();
			throw e;
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


	public List<Coordinates> getCoordinatesList(){


		Session session = null;
		List<Coordinates> list = new ArrayList<Coordinates>();



		try{


			session =SessionFactoryService.getSession();
			Transaction tx=session.getTransaction();

			tx.begin();
			Criteria criteria=session.createCriteria(CoordinatesEntity.class);
			List<CoordinatesEntity> l=criteria.list();

			for(CoordinatesEntity e:l){
				Coordinates c=new Coordinates(e.getId(),e.getLat1(), e.getLng1(), e.getLat2(), e.getLng2(), e.getName());

				list.add(c);
			}





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
		return list;

	}
	
	public Coordinates getFacilityCoordinatesList(String facilityName){


		Session session = null;
		List<Coordinates> list = new ArrayList<Coordinates>();
		Coordinates c = null;



		try{


			session =SessionFactoryService.getSession();
			Transaction tx=session.getTransaction();

			tx.begin();
			Criteria criteria=session.createCriteria(CoordinatesEntity.class);
			List<CoordinatesEntity> l=criteria.list();

			for(CoordinatesEntity e:l){
				
				
				if(facilityName.equalsIgnoreCase(e.getName()))
					c=new Coordinates(e.getId(),e.getLat1(), e.getLng1(), e.getLat2(), e.getLng2(), e.getName());

			}





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
		return c;

	}
	
	public static void main(String[] args) throws Exception {
		CoordinatelistService v = new CoordinatelistService();

		/*for(int i=0;i<6;i++)
			v.saveCoordinates(coordinateList.get(i));*/
		System.out.println(v.getFacilityCoordinatesList("Manh_Whse1").getName());
	}

}
