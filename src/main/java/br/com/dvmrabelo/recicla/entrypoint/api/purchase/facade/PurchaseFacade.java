package br.com.dvmrabelo.recicla.entrypoint.api.purchase.facade;

import br.com.dvmrabelo.recicla.core.usecase.MaterialUseCase;
import br.com.dvmrabelo.recicla.core.usecase.PurchaseUseCase;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseFacade {

    private final PurchaseUseCase purchaseUseCase;
    private final PurchaseMapper purchaseMapper;
    private final MaterialUseCase materialUseCase;

    public PurchaseFacade(PurchaseUseCase purchaseUseCase, PurchaseMapper mapper, MaterialUseCase materialUseCase) {
        this.purchaseUseCase = purchaseUseCase;
        this.purchaseMapper = mapper;
        this.materialUseCase = materialUseCase;
    }

    public PurchaseResponse savePurchase(PurchaseRequest purchase) {
        var material = materialUseCase.findMaterialById(purchase.materialId());
        return purchaseMapper.toDTO(purchaseUseCase.savePurchase(purchaseMapper.toEntity(purchase, material)));
    }

    public List<PurchaseResponse> findAllPurchases() {
        return purchaseUseCase.findAllPurchases().stream().map(purchaseMapper::toDTO).toList();
    }
}
