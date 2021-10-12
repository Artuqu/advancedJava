package pl.clockworkjava.advanced.threads.jpa;

import pl.clockworkjava.advanced.threads.jpa.domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        createTableForStudent();

        Student pawel = new Student ("Paweł","000");
        Student marek = new Student( "Marek", "7899");

        insertStudent(pawel);
        insertStudent(marek);

        List<Student> students = getStudents();
        students.forEach(System.out::println);
    }

    private static List<Student> getStudents()  throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        Connection conn = H2Configuration.getDBConnection();
        Statement statement = conn.createStatement();
        ResultSet resultStudent = statement.executeQuery("SELECT * FROM STUDENT");

        while(resultStudent.next()){

            int id = resultStudent.getInt("id");
            String name = resultStudent.getString("name");
            String phone = resultStudent.getString("phone");
            students.add(new Student(name,phone));
        }
        return students;
    }

    private static void createTableForStudent() throws SQLException, ClassNotFoundException {

        Connection conn = H2Configuration.getDBConnection();
        Statement statement = conn.createStatement();
        String createStudent = "CREATE TABLE STUDENT (id int primary key, name varchar(255))";
        statement.execute(createStudent);
        conn.commit();
    }

    private static void insertStudent (Student student) throws SQLException, ClassNotFoundException{
        Connection conn = H2Configuration.getDBConnection();
        Statement statement = conn.createStatement();
        String insertData = "INSERT INTO STUDENT VALUES ("+student.getId()+",\'"+student.getName()+"\')";
        statement.execute(insertData);
        conn.commit();

    }
}
