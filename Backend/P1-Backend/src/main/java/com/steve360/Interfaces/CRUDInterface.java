package com.steve360.Interfaces;

import java.util.List;

public interface CRUDInterface <T> {


    void create(T t);

    T read(int id);

    T validate(String userName, String password);

    List<T> readAll();

    void update(T t);

    void delete(int id);


}
