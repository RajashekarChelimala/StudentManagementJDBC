package cgg.sma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import cgg.sma.manage.ConnectionProvider;
import cgg.sma.model.Student;

public class StudentDAO {
	
	Connection conn;
	
	public StudentDAO() {
		super();
		conn=ConnectionProvider.createConnection();
	}
	
	public boolean insertStudentToDB(Student st) {
		boolean f = false;
		
		String q = "insert into students(student_name,student_phone,student_city) values(?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(q);
			
			ps.setString(1, st.getName());
			ps.setString(2, st.getPhone());
			ps.setString(3, st.getCity());
			
			ps.executeUpdate();
			f=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public boolean deleteStudent(int id) {
		boolean f = false;
		
		String q = "delete from students where student_id=?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(q);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			f=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean showAllStudents() {
		boolean f = false;
		
		String q = "select * from students";
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(q);
			
			ResultSetMetaData rm = rs.getMetaData();
			
			int cc = rm.getColumnCount();
			
			for(int i=1;i<=cc;i++) {
				System.out.print(rm.getColumnName(i)+"  ");
			}
			System.out.println();
			
			while(rs.next()) {
				System.out.print("\t");
				for(int i=1;i<=cc;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
			f=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateStudentName(int id, String name) {
		
		boolean f = false;
		
		String q = "update students set student_name=? where student_id=?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(q);
			
			ps.setString(1, name);
			ps.setInt(2,id);
			ps.executeUpdate();
			
			f=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public boolean updateStudentPhone(int id, String phone) {
		
		boolean f = false;
		
		String q = "update students set student_phone=? where student_id=?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(q);
			
			ps.setString(1, phone);
			ps.setInt(2,id);
			ps.executeUpdate();
			
			f=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public boolean updateStudentCity(int id, String city) {
		boolean f = false;
		
		String q = "update students set student_city=? where student_id=?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(q);
			
			ps.setString(1, city);
			ps.setInt(2,id);
			ps.executeUpdate();
			
			f=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
		
	}

}
