package service;

import entity.user;
import java.util.List;

/**
 *
 * @author benza
 * @param <T>
 */
public interface IService<T> {
    void insert(T t);
    void insert1(T t);
    void delete(T t);
    void update(T t);
    List<T> readAll();
   
    T readById(int id); 
   
}