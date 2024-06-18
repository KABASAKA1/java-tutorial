package com.java_javafx_tutorial.database.course.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements IDataAccessObject<Course> {

    private MyDatabaseClass database = new MyDatabaseClass();

    @Override
    public Course getById(int id) {
        String query = "select * from course inner join teacher on course.teacher_id=teacher.teacher_id where course_id = ?";
        ResultSet resultSet = null;
        Course course = new Course();
        Teacher teacher = new Teacher();
        try {
            resultSet = database.executeQuery(query, id);
            if (resultSet.next()){
                course.setCourse_name(resultSet.getString("course_name"));
                course.setCourse_id(resultSet.getInt("course_id"));
                teacher.setTeacher_id(resultSet.getInt("teacher_id"));
                teacher.setTeacher_name(resultSet.getString("teacher_name"));
                teacher.setTeacher_age(resultSet.getInt("teacher_age"));
                course.setTeacher(teacher);
            }
            database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> getAll() {
        List<Course> courseList = new ArrayList<>();
        String query = "select * from course inner join teacher on course.teacher_id=teacher.teacher_id";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //preparedStatement = connection.prepareStatement("select * from course");
            resultSet = database.executeQuery(query);
            Course course;
            Teacher teacher;
            while (resultSet.next()){
                course = new Course();
                teacher = new Teacher();
                course.setCourse_id(resultSet.getInt("course_id"));
                course.setCourse_name(resultSet.getString("course_name"));
                teacher.setTeacher_id(resultSet.getInt("teacher_id"));
                teacher.setTeacher_name(resultSet.getString("teacher_name"));
                teacher.setTeacher_age(resultSet.getInt("teacher_age"));
                course.setTeacher(teacher);
                courseList.add(course);
            }
            database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public boolean add(Course course) {
        String query = "insert into course (course_name , teacher_id) vaues (? , ?)";
        int sonuc=-1;
        sonuc = database.executeUpdate(query , course.getCourse_name() ,course.teacherProperty().get().getTeacher_id());
        database.closeConnection();
        if (sonuc>0)
            return true;
        return false;
    }

    @Override
    public boolean delete(Course course) {
        String query = "delete from course where course_id=?";
        int sonuc=-1;
        sonuc = database.executeUpdate(query , course.getCourse_id());
        database.closeConnection();
        if (sonuc>0)
            return true;
        return false;
    }
}

