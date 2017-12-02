package custemer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import custemer.bean.Custemer;
import database.dbConnection;

public class CustemerDAO {
	
	public int save(Custemer custemer) {
		
		Connection connection= dbConnection.getConn();
		int status=0;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO custemer VALUES (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, custemer.getFirstName());
			preparedStatement.setString(3, custemer.getLastName());
			preparedStatement.setString(4, custemer.getEmailId());
			preparedStatement.setString(5, custemer.getPhNumber());
			preparedStatement.setString(6, custemer.getGender());
			preparedStatement.setString(7, custemer.getAge());
			preparedStatement.setString(8, custemer.getAddress());
			preparedStatement.setString(9, custemer.getFax());
			status=preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public List<Custemer> getCustemer() {
		
		List<Custemer> arrayList=new ArrayList<Custemer>();
		
		
		try {
			Connection connection=dbConnection.getConn();
			PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM custemer");
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				Custemer custemer=new Custemer();
				custemer.setId(rs.getInt("id"));
				custemer.setFirstName(rs.getString("firstname"));
				custemer.setLastName(rs.getString("lastname"));
				custemer.setEmailId(rs.getString("emailId"));
				custemer.setPhNumber(rs.getString("phNumber"));
				custemer.setGender(rs.getString("gender"));
				custemer.setAge(rs.getString("age"));
				custemer.setAddress(rs.getString("address"));
				custemer.setFax(rs.getString("fax"));
				arrayList.add(custemer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrayList;
		
	}
	

}
