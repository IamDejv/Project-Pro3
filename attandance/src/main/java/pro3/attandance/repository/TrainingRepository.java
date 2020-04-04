package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {

    List<Training> getAllByUser_Userid(int id);
}
