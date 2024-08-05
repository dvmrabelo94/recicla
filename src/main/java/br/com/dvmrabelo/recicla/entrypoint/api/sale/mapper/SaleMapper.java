package br.com.dvmrabelo.recicla.entrypoint.api.sale.mapper;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import br.com.dvmrabelo.recicla.dataprovider.sale.entity.Sale;
import br.com.dvmrabelo.recicla.entrypoint.api.material.mapper.MaterialMapper;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.dto.SaleRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.dto.SaleResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaleMapper {

    private final MaterialMapper materialMapper;

    public SaleMapper(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

    public SaleResponse toDTO(Sale sale) {
        return new SaleResponse(
                sale.getId(),
                sale.getMaterial().getId(),
                sale.getQuantity(),
                sale.getTotalPrice(),
                sale.getSaleDate()
        );
    }

    public Sale toEntity(SaleRequest dto, Material material) {
        Sale sale = new Sale();
        sale.setMaterial(material);
        sale.setQuantity(dto.quantity());
        sale.setTotalPrice(dto.totalPrice());
        sale.setSaleDate(LocalDateTime.now());
        return sale;
    }
}
