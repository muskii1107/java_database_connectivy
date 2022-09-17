package controller;

import dao.StudentDao;
import model.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HomeController {

    public void showmenu() {
        System.out.println("Chose an option");
        System.out.println("1 - Show all students");
        System.out.println("2 - Show a student by id");
        System.out.println("3 - Show all students by batchID");
        System.out.println("4 - Insert a new students");
        System.out.println("5 - Update a student by ID");
        System.out.println("6 - Delete student by ID");
        System.out.println("7 - Exit");
    }

    public void handleChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1 -> {
                showAllStudents();
            }
            case 2 -> {
                showAStudentById();
            }
            case 3 -> {
                showAllStudentsByBatch();
            }
            case 4 -> {
                InsertStudents();
            }
            case 5 -> {
                UpdateStudents();
            }
            case 6 -> {
                DeleteStudents();
            }
            case 7 -> {
                System.exit(0);
            }
        }
    }

    private void UpdateStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id ");
        int id = sc.nextInt();
        sc.nextLine();


        System.out.println("Enter name ");
        String name = sc.nextLine();
        System.out.println("Enter mobile ");
        String mobile = sc.nextLine();
        System.out.println("Enter batch ");
        String batch = sc.nextLine();
        System.out.println("Enter date in format dd/MM/yyyy");
        Date date = null;

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Student s = new Student(name, mobile, batch, date);

        try {
            StudentDao.updateStudentById(id, s);
            showAllStudents();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void InsertStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name ");
        String name = sc.nextLine();
        System.out.println("Enter mobile ");
        String mobile = sc.nextLine();
        System.out.println("Enter batch ");
        String batch = sc.nextLine();
        System.out.println("Enter date in format dd/mm/yyyy");
        Date date = null;

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Student s = new Student(name, mobile, batch, date);

        try {
            StudentDao.insertStudent(s);
            showAllStudents();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAllStudentsByBatch() {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER Batch = ");
            String batch = sc.nextLine();
            List<Student> students = StudentDao.getStudentByBatch(batch);

            if (students.size() == 0)
                System.out.println("No Record Found !!");
            else
                students.forEach(st -> System.out.println(st));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void DeleteStudents() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER ID = ");
            int id = sc.nextInt();
            Student s = StudentDao.getStudentByID(id);

            if (s != null) {
                StudentDao.deleteStudentByID(id);
                showAllStudents();
            } else System.out.println("ID Not Found !!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void showAStudentById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER ID = ");
            int id = sc.nextInt();
            Student s = StudentDao.getStudentByID(id);
            if (s != null) {
                System.out.println(s);
            } else System.out.println("Unknown ID");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAllStudents() {
        try {
            List<Student> students = StudentDao.getAllStudents();

            if (students.size() == 0)
                System.out.println("No Record Found !!");
            else
                students.forEach(s -> System.out.println(s));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
