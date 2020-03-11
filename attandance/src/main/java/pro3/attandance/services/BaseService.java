package pro3.attandance.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaseService<T> {

    List <T> getAll();
    Optional<T> getById(int id);
    T add(T t);
    void deleteById(int id);
    T update(int id, T t);

}
