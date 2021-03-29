package basicauthorization.api.Service;

import basicauthorization.api.Model.Samochod;
import basicauthorization.api.Repository.SamochodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SamochodService {
    private final SamochodRepository samochodRepository;

    public List<Samochod> getAllSamochody(){
        return samochodRepository.findAll();
    }

    public Samochod getSingleSamochod(long id){
        return samochodRepository.findById(id).orElseThrow();
    }

    public Samochod addSamochod(Samochod samochod) {
        return samochodRepository.save(samochod);
    }

    @Transactional
    public Samochod editSamochod(Samochod samochod) {
        Samochod editedSamochod=samochodRepository.findById(samochod.getId()).orElseThrow();
        editedSamochod.setMarka(samochod.getMarka());
        editedSamochod.setModel(samochod.getModel());
        editedSamochod.setNazwa(samochod.getNazwa());
        editedSamochod.setPrzebieg(samochod.getPrzebieg());
        editedSamochod.setRok(samochod.getRok());
        return editedSamochod;
    }

    public void deleteSamochod(long id) {
        samochodRepository.deleteById(id);
    }
}
