package basicauthorization.api.Repository;

import basicauthorization.api.Model.Wypozyczalnia;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WypozyczalniaRepository extends JpaRepository<Wypozyczalnia,Long> {

    @Query("select w from Wypozyczalnia  w")
    List<Wypozyczalnia> findAllWypozyczalnia(Pageable page);
}
