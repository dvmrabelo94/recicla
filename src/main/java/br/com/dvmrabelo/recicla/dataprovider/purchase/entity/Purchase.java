package br.com.dvmrabelo.recicla.dataprovider.purchase.entity;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private Double quantity;
    private BigDecimal price;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
}
