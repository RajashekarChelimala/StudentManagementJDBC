package cgg.sma.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cgg.sma.dao.StudentDAO;
import cgg.sma.model.Student;

public class StudentManage {
	
	static StudentDAO studentDAO = new StudentDAO();

	public static void main(String[] args) {
		System.out.println("Welcome to student management application");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press\n 1. Add Student\n2. Update Student\n3. Delete Student\n4. Display All Students\n5. Exit");
			System.out.print("Enter your Choice: ");
			try {
				int ch = Integer.parseInt(br.readLine());
				if(ch==1) {
					//add Student
					System.out.println("Enter Student Name: ");
					String name = br.readLine();
					System.out.println("Enter Student Phone No: ");
					String phone = br.readLine();
					System.out.println("Enter Student City: ");
					String city = br.readLine();
					
					Student student = new Student(name,phone,city);
					boolean res = studentDAO.insertStudentToDB(student);
					
					if(res) {
						System.out.println("Student Details Added Successfully..");
					}
					else {
						System.out.println("Error while adding the student details..!");
					}
//					System.out.println(student);
				}
				else if(ch==2) {
					//update Student
					System.out.println("Enter the Details to be updated:\n Press 1. To update Name 2. To update Phone No 3. To update City");
					int update = Integer.parseInt(br.readLine());
					System.out.println(update);
					switch(update) {
						case 1:{
							System.out.println("Enter the StudentID: ");
							int id = Integer.parseInt(br.readLine());
							System.out.println("Enter the new Name : ");
							String name = br.readLine();
							boolean result = studentDAO.updateStudentName(id,name);
							if(result) {
								System.out.println("Student Name updated Successfully...");
							}
							else {
								System.out.println("Error While updating Student Name...!");
							}
							break;
						}
						case 2:{
							System.out.println("Enter the StudentID: ");
							int id = Integer.parseInt(br.readLine());
							System.out.println("Enter the new Phone No : ");
							String phone = br.readLine();
							boolean result = studentDAO.updateStudentPhone(id,phone);
							if(result) {
								System.out.println("Student Phone updated Successfully...");
							}
							else {
								System.out.println("Error While updating Student Phone...!");
							}
							break;
							
						}
						case 3:{
							
							System.out.println("Enter the StudentID: ");
							int id = Integer.parseInt(br.readLine());
							System.out.println("Enter the new Name : ");
							String city = br.readLine();
							boolean result = studentDAO.updateStudentCity(id,city);
							if(result) {
								System.out.println("Student City updated Successfully...");
							}
							else {
								System.out.println("Error While updating Student City...!");
							}
							break;
							
						}
						default:{
							System.out.println("Enter the valid option..!!");
						}
					}
				}
				else if(ch==3) {
					//delete Student
					System.out.println("Enter the student Id to delete:");
					int userId=Integer.parseInt(br.readLine());
					boolean answer = studentDAO.deleteStudent(userId);
					if(answer) {
						System.out.println("Student Details Deleted Successfully..");
					}
					else {
						System.out.println("Error while Deleting student details..!");
					}
				}
				else if(ch==4) {
					//display Students
					boolean answer = studentDAO.showAllStudents();
					if(answer) {
						System.out.println("Student Details Fetched Successfully..");
					}
					else {
						System.out.println("Error while fetching student details..!");
					}
				}
				else {
					//exit
					break;
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Thank you for using this app..\n See you soon.. bye bye");
		
	}

}
