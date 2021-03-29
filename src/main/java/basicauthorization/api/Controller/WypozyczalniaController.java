package basicauthorization.api.Controller;

import basicauthorization.api.DTO.WypozyczalniaDTO;
import basicauthorization.api.DTO.WypozyczalniaDTOMapper;
import basicauthorization.api.Model.Wypozyczalnia;
import basicauthorization.api.Service.WypozyczalniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WypozyczalniaController {
    private final WypozyczalniaService wypozyczalniaService;


    @GetMapping("/wypozyczalnia")
    public List<WypozyczalniaDTO> getAllWypozyczalnie(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber=page!=null && page>=0 ? page :0;
        Sort.Direction sortOrder=sort!=null ? sort : Sort.Direction.ASC;
        return WypozyczalniaDTOMapper.mapToWypozyczalniaDTOs(wypozyczalniaService.getAllWypozyczalnie(pageNumber, sortOrder));
    }

    @GetMapping("/wypozyczalnia/informacje")
    public List<Wypozyczalnia> getAllWypozyczalniaInfo(@RequestParam(required = false) Integer page, Sort.Direction sort){

        int pageNumber=page!=null && page>=0 ? page : 0;
        Sort.Direction sortOrder=sort!=null ? sort : Sort.Direction.ASC;
        return wypozyczalniaService.getAllInfoAboutWypozyczalnia(pageNumber,sortOrder);
    }

    @GetMapping("/wypozyczalnia/{id}")
    public Wypozyczalnia getSingleWypozyczalnia(@PathVariable("id") long id){
        return wypozyczalniaService.getSingleWypozyczalnia(id);
    }

    @PostMapping("/wypozyczalnia")
    public Wypozyczalnia addWypozyczalnia(@RequestBody Wypozyczalnia wypozyczalnia){
        return wypozyczalniaService.addWypozyczalnia(wypozyczalnia);
    }

    @PutMapping("/wypozyczalnia")
    public Wypozyczalnia editWypozyczalnia(@RequestBody Wypozyczalnia wypozyczalnia){
        return wypozyczalniaService.editWypozyczalnia(wypozyczalnia);
    }

    @DeleteMapping("/wypozyczalnia/{id}")
    public void deleteWypozyczalnia(@PathVariable("id") long id){
        wypozyczalniaService.deleteWypozyczalnia(id);
    }
}
