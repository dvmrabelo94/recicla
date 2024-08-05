package br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto;

import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseResponse(
        Long id,
        MaterialResponse material,
        Double quantity,
        BigDecimal price,
        LocalDateTime purchaseDate
) {
}
