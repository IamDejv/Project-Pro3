package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.Sponsor;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Integer> {

}
