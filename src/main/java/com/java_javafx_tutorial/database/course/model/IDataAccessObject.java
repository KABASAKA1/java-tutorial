package com.java_javafx_tutorial.database.course.model;

import java.util.List;

public interface IDataAccessObject<T> {
    public T getById(int id);
    public List<T> getAll();
    public boolean add(T t);
    public boolean delete(T t);
}
