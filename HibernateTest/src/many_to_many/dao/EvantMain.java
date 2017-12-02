package many_to_many.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import many_to_many.bean.Delegate;
import many_to_many.bean.Event;

public class EvantMain {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		//Transaction transaction=session.beginTransaction();
		
		/*Event event=new Event();
		event.setName("Anual Day");
		
		Event event2=new Event();
		event2.setName("Sports Day");
		
		Delegate delegate=new Delegate();
		delegate.setName("Tony");
		
		Delegate delegate2=new Delegate();
		delegate2.setName("Stark");
		
		Delegate delegate3=new Delegate();
		delegate3.setName("Jarvis");
		
		Delegate delegate4=new Delegate();
		delegate4.setName("Happy");
		
		List<Event> listE=new ArrayList<Event>();
		listE.add(event);
		
		List<Event> listE2=new ArrayList<Event>();
		listE2.add(event2);
		
		List<Delegate> listD=new ArrayList<Delegate>();
		listD.add(delegate);
		listD.add(delegate2);
		
		List<Delegate> listD2=new ArrayList<Delegate>();
		listD2.add(delegate3);
		listD2.add(delegate4);
		
		event.setDelegates(listD);
		event2.setDelegates(listD2);
		delegate.setEvents(listE);
		delegate2.setEvents(listE2);
		
		session.save(event);
		session.save(event2);
		
		transaction.commit();
*/		

		String query="FROM Delegate";
		Query q=session.createQuery(query);
		List<Delegate> list=q.list();
		Iterator<Delegate> iterator=list.iterator();
		while (iterator.hasNext()) {
			Delegate delegate = (Delegate) iterator.next();
			System.out.println("Delegate Name : "+delegate.getName());
			List<Event> listD=delegate.getEvents();
			Iterator<Event> iterator2=listD.iterator();
			while (iterator2.hasNext()) {
				Event event = (Event) iterator2.next();
				System.out.println("\tEvent Name : "+event.getName());
			}
		}
		
		
	}

}
