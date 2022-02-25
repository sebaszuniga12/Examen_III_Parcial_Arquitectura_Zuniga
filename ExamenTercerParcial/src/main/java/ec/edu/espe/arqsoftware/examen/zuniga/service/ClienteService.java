package ec.edu.espe.arqsoftware.examen.zuniga.service;

import com.github.javafaker.Faker;
import ec.edu.espe.arqsoftware.examen.zuniga.dao.ClienteRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.kafka.KafkaTestProducer;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final Faker faker = new Faker();
    private final KafkaTestProducer<Cliente> kafkaTestProducer;

    public ClienteService(ClienteRepository clienteRepository, KafkaTestProducer<Cliente> kafkaTestProducer) {
        this.clienteRepository = clienteRepository;
        this.kafkaTestProducer = kafkaTestProducer;
    }

    public Cliente saveCliente(Cliente c){
        return this.clienteRepository.save(c);
    }

    public void generateRandom(Integer numElementos){
        for(Integer i=0;i<numElementos;i++){
            Cliente cliente = new Cliente();
            cliente.setNombres(faker.name().name());
            cliente.setApellidos(faker.name().lastName());
            cliente.setDireccion(faker.address().fullAddress());
            this.kafkaTestProducer.runner(cliente);
        }

    }
}

