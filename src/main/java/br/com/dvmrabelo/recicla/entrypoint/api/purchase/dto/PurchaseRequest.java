package br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto;

import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseRequest(
        Long materialId,
        Double quantity,
        BigDecimal price
) {
}
