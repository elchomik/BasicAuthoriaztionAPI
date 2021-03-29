package basicauthorization.api.Service;

import basicauthorization.api.Model.Klient;
import basicauthorization.api.Model.Samochod;
import basicauthorization.api.Model.Wypozyczalnia;
import basicauthorization.api.Repository.KlientRepository;
import basicauthorization.api.Repository.SamochodRepository;
import basicauthorization.api.Repository.WypozyczalniaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WypozyczalniaService {

    private static final int PAGE_SIZE = 5;
    private final WypozyczalniaRepository wypozyczalniaRepository;
    private final KlientRepository klientRepository;
    private final SamochodRepository samochodRepository;

    public List<Wypozyczalnia> getAllWypozyczalnie(int page, Sort.Direction sort){
        return wypozyczalniaRepository.findAllWypozyczalnia(PageRequest.of(page,PAGE_SIZE, Sort.by(sort,"id")));
    }

    public Wypozyczalnia getSingleWypozyczalnia(long id){
        return wypozyczalniaRepository.findById(id).orElseThrow();
    }

    public Wypozyczalnia addWypozyczalnia(Wypozyczalnia wypozyczalnia) {
        return wypozyczalniaRepository.save(wypozyczalnia);
    }

    @Transactional
    public Wypozyczalnia editWypozyczalnia(Wypozyczalnia wypozyczalnia) {
        Wypozyczalnia editedWypozyczalnia=wypozyczalniaRepository.findById(wypozyczalnia.getId()).orElseThrow();
        editedWypozyczalnia.setMiasto(wypozyczalnia.getMiasto());
        editedWypozyczalnia.setUlica(wypozyczalnia.getUlica());
        editedWypozyczalnia.setWlasciciel(wypozyczalnia.getWlasciciel());
        return editedWypozyczalnia;
    }

    public void deleteWypozyczalnia(long id) {
        wypozyczalniaRepository.deleteById(id);
    }
    
    public List<Wypozyczalnia> getAllInfoAboutWypozyczalnia(int page, Sort.Direction sort){

        List<Wypozyczalnia> allWypozyczalnia=wypozyczalniaRepository.findAllWypozyczalnia(PageRequest.of(page,PAGE_SIZE,Sort.by(sort,"id")));

        List<Long> klientids=allWypozyczalnia.stream()
           .map(klient->klient.getId())
                .collect(Collectors.toList());


        List<Long> samochodids=allWypozyczalnia.stream()
                .map(samochod->samochod.getId())
                .collect(Collectors.toList());

        List<Klient> allKlients=klientRepository.findAllByWypozyczalniaIdIn(klientids);
        List<Samochod> allSamochody=samochodRepository.findAllByWypozyczalniaIdIn(samochodids);

        allWypozyczalnia.forEach(wypozyczalnia -> wypozyczalnia.setKlient(extractKlient(allKlients,wypozyczalnia.getId())));
        allWypozyczalnia.forEach(wypozyczalnia -> wypozyczalnia.setSamochod(extractSamochod(allSamochody,wypozyczalnia.getId())));

        return  allWypozyczalnia;
    }

    private List<Samochod> extractSamochod(List<Samochod> allSamochody, long id) {
        return allSamochody.stream()
                .filter(samochod -> samochod.getId()==id)
                .collect(Collectors.toList());
    }

    private List<Klient> extractKlient(List<Klient> allKlients, long id) {
        return allKlients.stream()
                .filter(klient -> klient.getId()==id)
                .collect(Collectors.toList());
    }

}
