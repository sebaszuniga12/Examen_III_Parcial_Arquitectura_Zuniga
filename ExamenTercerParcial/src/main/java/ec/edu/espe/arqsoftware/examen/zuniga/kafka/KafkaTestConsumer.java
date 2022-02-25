package ec.edu.espe.arqsoftware.examen.zuniga.kafka;

import ec.edu.espe.arqsoftware.examen.zuniga.model.Cliente;
import ec.edu.espe.arqsoftware.examen.zuniga.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaTestConsumer {
    private final ClienteService clienteService;

    public KafkaTestConsumer(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @KafkaListener(
            topics = "test",
            groupId = "groupId"
    )
    public void Listener(Cliente c){
        log.info("Datos guardados: {}",this.clienteService.saveCliente(c));
    }
}