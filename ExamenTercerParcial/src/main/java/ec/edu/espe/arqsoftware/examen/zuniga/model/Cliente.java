package ec.edu.espe.arqsoftware.examen.zuniga.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "clientes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Integer id;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
}