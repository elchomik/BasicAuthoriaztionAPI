package basicauthorization.api.Controller;

import basicauthorization.api.DTO.KlientDTO;
import basicauthorization.api.DTO.KlientDTOMapper;
import basicauthorization.api.DTO.SamochodDTO;
import basicauthorization.api.DTO.SamochodDTOMapper;
import basicauthorization.api.Model.Samochod;
import basicauthorization.api.Service.SamochodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SamochodController {

    private final SamochodService samochodService;

    @GetMapping("/samochody")
    public List<SamochodDTO> getAllSamochody(){
        return SamochodDTOMapper.mapToSamochodDTOs(samochodService.getAllSamochody());
    }

    @GetMapping("/samochody/{id}")
    public Samochod getSingleSamochod(@PathVariable long id){
        return samochodService.getSingleSamochod(id);
    }

    @PostMapping("/samochody")
    public Samochod addSamochod(@RequestBody Samochod samochod){
        return samochodService.addSamochod(samochod);
    }

    @PutMapping("/samochody")
    public Samochod editSamochod(@RequestBody Samochod samochod){
        return samochodService.editSamochod(samochod);
    }

    @DeleteMapping("/samochody/{id}")
    public void deleteSamochod(@PathVariable long id){
        samochodService.deleteSamochod(id);
    }
}
