package DatabaseProcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Student;
import projectWithJDBC.connection.DatabaseConnection;

public class DatabaseStatement {
	private static Connection connection = DatabaseConnection.getConnection();
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void createTable() {// i create 'students'
		String query = "create table students(student_id int not null primary key,"
				+ "student_name varchar(20),student_surname varchar(20))";
		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.execute();
			DatabaseConnection.connectionClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertStudent() {
		String query = "insert into students(student_id,student_name,student_surname) values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "Zulfuqar");
			preparedStatement.setString(3, "Huseynov");

			preparedStatement.execute();
			DatabaseConnection.connectionClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertObjectOfStudent(Student student) {
		String query = "insert into students(student_id,student_name,student_surname) values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, student.getStudent_id());
			preparedStatement.setString(2, student.getStudent_name());
			preparedStatement.setString(3, student.getStudent_surname());
			preparedStatement.execute();
			DatabaseConnection.connectionClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateTableOfStudent(Student student, int studentId) {
		String query = "update students set student_name=?,student_surname=? where student_id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getStudent_name());
			preparedStatement.setString(2, student.getStudent_surname());
			preparedStatement.setInt(3, studentId);
			preparedStatement.executeUpdate();
			DatabaseConnection.connectionClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteStudentById(int studentId) {
		String query = "delete from students where student_id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			preparedStatement.executeUpdate();
			DatabaseConnection.connectionClose();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void findStudentById(int studentId) {
		String query = "select * from students where student_id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("student_id");
				String name = resultSet.getString("student_name");
				String surname = resultSet.getString("student_surname");

				System.out.println("id=" + id);
				System.out.println("name=" + name);
				System.out.println("surname=" + surname);

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
DatabaseConnection.connectionClose();
	}

	public static void getAllStudents() {
		String query = "select * from students";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("student_id");
				String name = resultSet.getString("student_name");
				String surname = resultSet.getString("student_surname");

				System.out.println("id=" + id);
				System.out.println("name=" + name);
				System.out.println("surname=" + surname);
			}
			DatabaseConnection.connectionClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
