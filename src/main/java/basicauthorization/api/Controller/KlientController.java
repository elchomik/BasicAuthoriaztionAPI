package basicauthorization.api.Controller;


import basicauthorization.api.DTO.KlientDTO;
import basicauthorization.api.DTO.KlientDTOMapper;
import basicauthorization.api.Model.Klient;
import basicauthorization.api.Service.KlientService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KlientController {

    private final KlientService klientService;


    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/klienci")
    public List<KlientDTO> getAllKlients(){

        return KlientDTOMapper.mapToKlientDTOs(klientService.getAllKlients());
    }

    @GetMapping("/klienci/{id}")
    public Klient getSingleKlient(@PathVariable long id){
        return klientService.getSingleKlient(id);
    }

    @PostMapping("/klienci")
    public Klient addKlient(@RequestBody Klient klient){
        rabbitTemplate.convertAndSend("klientQueue",klient);

        return klientService.addKlient(klient);
    }

    @PutMapping("/klienci")
    public Klient editKlient(@RequestBody Klient klient){
        return klientService.editKlient(klient);
    }

    @DeleteMapping("/klienci/{id}")
    public void deleteKlient(@PathVariable long id){
        klientService.deleteKlient(id);
    }


}
