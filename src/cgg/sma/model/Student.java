package cgg.sma.model;

public class Student {

	private int studentId;
	private String name;
	private String phone;
	private String city;
	
	public Student(int studentId, String name, String phone, String city) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.phone = phone;
		this.city = city;
	}

	public Student(String name, String phone, String city) {
		super();
		this.name = name;
		this.phone = phone;
		this.city = city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", phone=" + phone + ", city=" + city + "]";
	}
	
}
