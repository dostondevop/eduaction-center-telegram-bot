package uz.AlpinistEdu_Service.service;


import java.util.List;
import java.util.UUID;


public interface BaseService<T> {
     T add(T t);
     T get(UUID id);
     boolean has(T t, List<T> list);
     T getById(UUID id);
     List<T> getList();
     List<T> read();
     void write(List<T> tList);
}
