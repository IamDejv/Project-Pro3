package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.User;
import pro3.attandance.model.UserAction;

import java.util.List;

@Repository
public interface UserActionRepository extends CrudRepository<UserAction, Integer> {

    List<UserAction> findAllByActionActionsid(int id);

    List<UserAction> getUserActionsByUser_Userid(int id);
}
