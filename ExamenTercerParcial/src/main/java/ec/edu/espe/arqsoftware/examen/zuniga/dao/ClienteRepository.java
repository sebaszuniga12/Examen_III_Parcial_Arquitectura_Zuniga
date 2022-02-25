package ec.edu.espe.arqsoftware.examen.zuniga.dao;

import ec.edu.espe.arqsoftware.examen.zuniga.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
