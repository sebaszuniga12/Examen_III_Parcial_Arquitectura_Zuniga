package ec.edu.espe.arqsoftware.examen.zuniga.service;

import com.github.javafaker.Faker;
import ec.edu.espe.arqsoftware.examen.zuniga.dao.PagoPrestamoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.kafka.KafkaPrestamoProducer;
import ec.edu.espe.arqsoftware.examen.zuniga.model.PagoPrestamo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PagoPrestamoService {
    private final PagoPrestamoRepository pagoPrestamoRepository;
    private final Faker faker = new Faker();
    private final KafkaPrestamoProducer<PagoPrestamo> kafkaPrestamoProducer;

    public PagoPrestamoService(PagoPrestamoRepository pagoPrestamoRepository, KafkaPrestamoProducer<PagoPrestamo> kafkaPrestamoProducer) {
        this.pagoPrestamoRepository = pagoPrestamoRepository;
        this.kafkaPrestamoProducer = kafkaPrestamoProducer;
    }

    public PagoPrestamo savePagoPrestamo(PagoPrestamo p){
        return this.pagoPrestamoRepository.save(p);
    }

    public void generateRandom(Integer numElementos){
        for(Integer i=0;i<numElementos;i++){
            PagoPrestamo prestamo = new PagoPrestamo();
            prestamo.setId(Long.parseLong(faker.numerify("#######")));
            prestamo.setValorPago(BigDecimal.valueOf(faker.number().randomDouble(2,10,5000)));
            prestamo.setFechaPago(java.time.LocalDate.now());
            prestamo.setHoraPago(java.time.LocalTime.now());
            prestamo.setNumeroCuota(faker.number().numberBetween(1,5));
            this.kafkaPrestamoProducer.runner(prestamo);
        }

    }
}

