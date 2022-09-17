package dao;

import db.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao {
    public static List<Student> getAllStudents() throws SQLException { //List-multiple students , throws SQLException so that it handled by who called it
        List<Student> students = new ArrayList<>();
        Connection connection = DBConnection.getConnection(); //we get connection from mysql
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM STUDENTS"); // throw SQLException we get prepared sta(bani hui query|| build query)
        ResultSet rs = ps.executeQuery(); //here we fire means execute, ps.executeQuery() return resultSet or table
        while (rs.next()) { //we get data row wise
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String mobile = rs.getString(3);
            String batch = rs.getString(4);
            Date regDate = rs.getDate(5);
            Student s = new Student(id, name, mobile, batch, regDate); //object
            students.add(s);// add users in list
        }
        return students;
    }
    public static Student getStudentByID(Integer id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM STUDENTS WHERE ID = ?"); //? placeholder type we set in nextLine
        ps.setInt(1, id); // set 1st index as id
        ResultSet rs = ps.executeQuery();
        Student s = null;
        while (rs.next()) {
            int id1 = rs.getInt(1);
            String name = rs.getString(2);
            String mobile = rs.getString(3);
            String batch = rs.getString(4);
            Date regDate = rs.getDate(5);
            s = new Student(id1, name, mobile, batch, regDate);
        }
        return s;
    }

    public static void deleteStudentByID(Integer id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("DELETE FROM STUDENTS WHERE ID = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static List<Student> getStudentByBatch(String batch) throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM STUDENTS where batch = ?");
        ps.setString(1, batch);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String mobile = rs.getString(3);
            String batch1 = rs.getString(4);
            Date regDate = rs.getDate(5);
            Student s = new Student(id, name, mobile, batch1, regDate);
            students.add(s);
        }
        return students;
    }


    public static void insertStudent(Student s) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students values(default,?,?,?,?)");
        ps.setString(1, s.getName());
        ps.setString(2, s.getMobile());
        ps.setString(3, s.getBatch());
        ps.setDate(4, new java.sql.Date(s.getDate().getTime()));

        ps.executeUpdate();
    }

    public static void updateStudentById(Integer id, Student s) throws  SQLException{
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE students SET name = ? , mobile = ? , batch = ? , reg_date = ? where id = ?");
        ps.setString(1, s.getName());
        ps.setString(2, s.getMobile());
        ps.setString(3, s.getBatch());
        ps.setDate(4, new java.sql.Date(s.getDate().getTime()));
        ps.setInt(5, id);

        ps.executeUpdate();
    }


}