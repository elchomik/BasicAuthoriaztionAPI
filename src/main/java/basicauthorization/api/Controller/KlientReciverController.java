package basicauthorization.api.Controller;

import basicauthorization.api.Config.Config;
import basicauthorization.api.Model.Klient;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class KlientReciverController {


    private final RabbitTemplate rabbitTemplate;
    private final Logger logger= LoggerFactory.getLogger(Klient.class);

    private final Config config;

    @GetMapping("/reciveAddedKlient")
    public Klient getKlient(){
    Object message=rabbitTemplate.receiveAndConvert("klientQueue");
    logger.info("Odebrano informacje o dodaniu klienta "+ message.toString());
    return (Klient) message;

}

    @RabbitListener(queues = "klientQueue")
    public void showMessages(Klient klient){

        logger.info("Utworzono nowego klienta "+ klient.toString());

    }
}
