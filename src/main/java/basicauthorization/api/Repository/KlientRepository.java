package basicauthorization.api.Repository;

import basicauthorization.api.Model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlientRepository extends JpaRepository<Klient,Long> {

    List<Klient> findAllByWypozyczalniaIdIn(List<Long> klientids);
}
