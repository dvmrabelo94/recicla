package br.com.dvmrabelo.recicla.dataprovider.sale.entity;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private Double quantity;
    private BigDecimal totalPrice;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;
}
