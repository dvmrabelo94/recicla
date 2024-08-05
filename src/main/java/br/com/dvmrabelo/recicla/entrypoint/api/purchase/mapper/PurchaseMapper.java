package br.com.dvmrabelo.recicla.entrypoint.api.purchase.mapper;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import br.com.dvmrabelo.recicla.dataprovider.purchase.entity.Purchase;
import br.com.dvmrabelo.recicla.entrypoint.api.material.mapper.MaterialMapper;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PurchaseMapper {

    private final MaterialMapper materialMapper;

    public PurchaseMapper(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

    public PurchaseResponse toDTO(Purchase purchase) {
        return new PurchaseResponse(
                purchase.getId(),
                materialMapper.toDTO(purchase.getMaterial()),
                purchase.getQuantity(),
                purchase.getPrice(),
                purchase.getPurchaseDate()
        );
    }

    public Purchase toEntity(PurchaseRequest dto, Material material) {
        Purchase purchase = new Purchase();
        purchase.setMaterial(material);
        purchase.setQuantity(dto.quantity());
        purchase.setPrice(dto.price());
        purchase.setPurchaseDate(LocalDateTime.now());
        return purchase;
    }
}
