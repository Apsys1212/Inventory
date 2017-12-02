package one_two_many.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import one_two_many.bean.Collage;
import one_two_many.bean.Student;

public class StudentMain {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		/*Student student=new Student();
		student.setStudentName("Jarvis");
		
		Student student2=new Student();
		student2.setStudentName("Happy");
		
		Collage collage=new Collage();
		collage.setCollageName("MIT");
		
		student.setCollage(collage);
		student2.setCollage(collage);
		
		List<Student> list=new ArrayList<Student>();
		list.add(student);
		list.add(student2);
		
		collage.setStudents(list);
		
		session.save(collage);
		transaction.commit();*/
		
		Criteria criteria=session.createCriteria(Collage.class);
		SimpleExpression s= Restrictions.eq("id", 2);
		Object list= criteria.add(s).uniqueResult();
		//Iterator<Collage> iterator=list.iterator();
		//while (iterator.hasNext()) {
			//Collage collage = (Collage) iterator.next();
			//System.out.println("Collage Name : "+collage.getCollageName());
		
		    Collage collage=(Collage)list;
		    System.out.println("Collage Name : "+collage.getCollageName());
			List<Student> list2=collage.getStudents();
			Iterator<Student> iterator2=list2.iterator();
			while (iterator2.hasNext()) {
				Student student = (Student) iterator2.next();
				System.out.println("\tStudent Name : "+student.getStudentName());
			//}
		}
		
		
		System.out.println("Done");
		
	}

}
