package ec.edu.espe.arqsoftware.examen.zuniga.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "pago_prestamo")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PagoPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "codigo_prestamo", nullable = false)
    private Long codigoPrestamo;

    @Column(name = "valor_pago", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "hora_pago", nullable = false)
    private LocalTime horaPago;

    @Column(name = "numero_cuota", nullable = false)
    private Integer numeroCuota;
}