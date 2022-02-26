package ec.edu.espe.arqsoftware.examen.zuniga.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.service.PagoPrestamoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PagoPrestamoController {

    private final PagoPrestamoService pagoPrestamoService;

    public PagoPrestamoController(PagoPrestamoService pagoPrestamoService) {
        this.pagoPrestamoService = pagoPrestamoService;
    }

    @GetMapping("/prestamo/{elementos}")
    public ResponseEntity crearPagoPrestamos(@PathVariable("elementos") Integer elementos){
        this.pagoPrestamoService.generateRandom(elementos);
        return ResponseEntity.ok().build();
    }
}