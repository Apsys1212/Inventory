package one_to_one.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import one_to_one.bean.Person;
import one_to_one.bean.PersonalDetails;

public class PersonMain {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try {
			Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			//Transaction transaction=session.beginTransaction();
			//PersonalDetails personalDetails=new PersonalDetails("Bengaluru", 85266.02);
			//PersonalDetails personalDetails2=new PersonalDetails("NYC", 56325.02);
			//Person person=new Person("Ajay", personalDetails);
			//Person person2=new Person("Stark",personalDetails2);
			//session.save(person);
			//session.save(person2);
			Criteria criteria= session.createCriteria(PersonalDetails.class);
			//SimpleExpression rs= Restrictions.eq("salary", 52366.02);
			//criteria.add(rs);
			ProjectionList projectionList= Projections.projectionList();
			PropertyProjection propertyProjection= Projections.property("address");
			PropertyProjection propertyProjection2=Projections.property("salary");
			projectionList.add(propertyProjection);
			projectionList.add(propertyProjection2);
			criteria.setProjection(projectionList);
			//PersonalDetails personalDetails=(PersonalDetails) criteria.uniqueResult();
			List<Object[]> list =criteria.list(); //session.createQuery("from PersonalDetails").list();
			//Iterator<PersonalDetails> iterator=list.iterator();
			//while (iterator.hasNext()) {
				//PersonalDetails personalDetails = (PersonalDetails) iterator.next();
			for (Object[] string : list) {
				System.out.println("Address : "+string[0]+" Salary : "+string[1]);
			}
				//Person person=personalDetails.getPerson();
				//System.out.println("-----------------------------------------------------------------");
				//System.out.println("Person Name : "+person.getName()+"\nAddress : "+personalDetails.getAddress()+"\nIncome : "+personalDetails.getSalary());
				//System.out.println("-----------------------------------------------------------------");
			//}
			//transaction.commit();
			//System.out.println("Stored...");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
