package com.app.poo;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    public T find(int Id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public void save(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(int Id) throws SQLException;
}
