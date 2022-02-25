package ec.edu.espe.arqsoftware.examen.zuniga.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    private final ClienteService clienteService;

    public TestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/{elementos}")
    public ResponseEntity enviarMensaje(@PathVariable("elementos") Integer elementos){
        this.clienteService.generateRandom(elementos);
        return ResponseEntity.ok().build();
    }
}