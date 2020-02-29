package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.SponsorHall;

@Repository
public interface SponsorHallRepository extends CrudRepository<SponsorHall, Integer> {

}
