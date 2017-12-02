package imageUpload.dao;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;

import imageUpload.bean.ImageWrapper;

public class ImageMain {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		     
		File file = new File("C://Users//om//Downloads//download.jpg");
		byte[] imageData = new byte[(int) file.length()];
		 
		try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(imageData);
		    fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		 
		ImageWrapper image = new ImageWrapper();
		image.setImageName("test.jpeg");
		image.setData(imageData);
		 
		session.save(image);    //Save the data
		 
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
	}

}
