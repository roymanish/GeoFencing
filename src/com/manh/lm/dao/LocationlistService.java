package com.manh.lm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manh.lm.domain.Location;
import com.manh.lm.entity.LocationEntity;
import com.manh.lm.service.SessionFactoryService;

public class LocationlistService {

	private static List<Location> locationList = new ArrayList<Location>();
	static

	{
		Location location = new Location(12.971599,77.594561,150.77,100.00,"VH1");
		locationList.add(location);

		location = new Location(12.971599,77.584562,150.77,100.00,"VH2");
		locationList.add(location);

		location = new Location(12.971599,77.564563,150.77,100.00,"VH3");
		locationList.add(location);

		location = new Location(12.971599,77.594664,150.77,100.00,"VH1");
		locationList.add(location);

		location = new Location(12.971299,77.594565,150.77,100.00,"VH2");
		locationList.add(location);

		location = new Location(12.971599,77.594266,150.77,100.00,"VH3");
		locationList.add(location);

		location = new Location(12.971599,77.594167,150.77,100.00,"VH1");
		locationList.add(location);

		location = new Location(12.979599,77.594568,150.77,100.00,"VH2");
		locationList.add(location);

		location = new Location(12.961599,77.594569,150.77,100.00,"VH3");
		locationList.add(location);

		location = new Location(12.951599,77.594571,150.77,100.00,"VH1");
		locationList.add(location);

		location = new Location(12.971599,77.545572,150.77,100.00,"VH2");
		locationList.add(location);

		location = new Location(12.981599,77.504574,150.77,100.00,"VH3");
		locationList.add(location);
	}

	public List<Location> getlocations()
	{
		System.out.println("getLocationlist Called");
		return locationList;
	}

	public void saveLocation(Location location) throws Exception{


		Session session = null;




		try{


			session =SessionFactoryService.getSession();
			Transaction tx=session.getTransaction();

			tx.begin();


			LocationEntity e=new LocationEntity(null, location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getSpeed(), location.getVehicle());

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


	public List<Location> getLocationList() throws Exception{


		Session session = null;
		List<Location> locationList = new ArrayList<Location>();



		try{


			session =SessionFactoryService.getSession();
			Transaction tx=session.getTransaction();

			tx.begin();
			Criteria criteria=session.createCriteria(LocationEntity.class);
			List<LocationEntity> l=criteria.list();

			for(LocationEntity e:l){
				Location loc=new Location(e.getId(), e.getLatitude(), e.getLongitude(), e.getAltitude(), e.getSpeed(), e.getVehicle());
				locationList.add(loc);
			}





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
		return locationList;

	}

	public static void main(String[] args) throws Exception {
		LocationlistService v = new LocationlistService();

		for(int i=0;i<12;i++)
			v.saveLocation(v.getlocations().get(i));
		//System.out.println(v.getLocationList().get(0).getLatitude());
	}

}
