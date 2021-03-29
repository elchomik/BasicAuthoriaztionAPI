package basicauthorization.api.Service;

import basicauthorization.api.Model.Klient;
import basicauthorization.api.Repository.KlientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KlientService {

    private final KlientRepository klientRepository;

    public List<Klient> getAllKlients(){
        return klientRepository.findAll();
    }

    public Klient getSingleKlient(long id){
        return klientRepository.findById(id).orElseThrow();
    }

    public Klient addKlient(Klient klient) {
        return klientRepository.save(klient);
    }

    @Transactional
    public Klient editKlient(Klient klient) {
        Klient editedKlient=klientRepository.findById(klient.getId()).orElseThrow();
        editedKlient.setImie(klient.getImie());
        editedKlient.setNazwisko(klient.getNazwisko());
        editedKlient.setPesel(klient.getPesel());
        editedKlient.setWiek(klient.getWiek());
        return editedKlient;
    }

    public void deleteKlient(long id) {
        klientRepository.deleteById(id);
    }
}
