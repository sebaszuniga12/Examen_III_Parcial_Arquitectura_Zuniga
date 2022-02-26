package ec.edu.espe.arqsoftware.examen.zuniga.kafka;

import ec.edu.espe.arqsoftware.examen.zuniga.model.PagoPrestamo;
import ec.edu.espe.arqsoftware.examen.zuniga.service.PagoPrestamoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaPrestamoConsumer {
    private final PagoPrestamoService pagoPrestamoService;

    public KafkaPrestamoConsumer(PagoPrestamoService pagoPrestamoService) {
        this.pagoPrestamoService = pagoPrestamoService;
    }

    @KafkaListener(
            topics = "prestamo",
            groupId = "groupId"
    )
    public void Listener(PagoPrestamo p){
        log.info("Datos guardados: {}",this.pagoPrestamoService.savePagoPrestamo(p));
    }
}