package cz.uhk.fim.pro3.attendence.dao;

import cz.uhk.fim.pro3.attendence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByFirstname(String firstname);
}
