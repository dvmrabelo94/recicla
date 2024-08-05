package br.com.dvmrabelo.recicla.entrypoint.api.sale.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SaleResponse(
        Long id,
        Long materialId,
        Double quantity,
        BigDecimal totalPrice,
        LocalDateTime saleDate
) {
}
