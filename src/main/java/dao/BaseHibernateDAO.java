package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateSessionFactory;

public class BaseHibernateDAO {
	
	public Session getSession(){
		try {
			return HibernateSessionFactory.getSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
