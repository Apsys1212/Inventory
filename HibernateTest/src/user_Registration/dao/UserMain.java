package user_Registration.dao;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

public class UserMain {
	
	public static Session getSession() {
		
		Session session=null;
		try {
			 session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return session;
		
		
	}

}
