package main;

import DatabaseProcess.DatabaseStatement;
import entity.Student;

public class Main {

	public static void main(String[] args) {
		DatabaseStatement.createTable();//'students' table was created
		DatabaseStatement.insertStudent();//write by hand
		
		Student student1=new Student(2,"Murad","Memmedzade");
		DatabaseStatement.insertObjectOfStudent(student1);
		
		Student student2=new Student(1,"Eltac","Esedullayev");
		
		DatabaseStatement.updateTableOfStudent(student2, student2.getStudent_id());
		
		DatabaseStatement.deleteStudentById(1);
		
		DatabaseStatement.findStudentById(2);
		
		DatabaseStatement.getAllStudents();

	}

}
