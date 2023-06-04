package entity;

public class Student {
	private int student_id;
	private String student_name;
	private String student_surname;
	public Student() {
		super();
	}
	public Student(int student_id, String student_name, String student_surname) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_surname = student_surname;
	}
	public int getStudent_id() {
		return student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public String getStudent_surname() {
		return student_surname;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public void setStudent_surname(String student_surname) {
		this.student_surname = student_surname;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_surname="
				+ student_surname + "]";
	}
	

}
