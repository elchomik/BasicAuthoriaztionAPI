package basicauthorization.api.Repository;

import basicauthorization.api.Model.Samochod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SamochodRepository extends JpaRepository<Samochod,Long> {
    List<Samochod> findAllByWypozyczalniaIdIn(List<Long> samochodyids);
}
