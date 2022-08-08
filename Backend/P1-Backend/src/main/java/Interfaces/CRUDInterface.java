package Interfaces;

import java.util.List;

public interface CRUDInterface <T> {


    void create(T t);

    T read(int id);

    boolean validate(String userName);

    List<T> readAll();

    void update(T t);

    void delete(int id);


}
