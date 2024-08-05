package br.com.dvmrabelo.recicla.entrypoint.api.purchase.impl;

import br.com.dvmrabelo.recicla.entrypoint.api.purchase.PurchaseController;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.facade.PurchaseFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/purchases")
public class PurchaseControllerImpl implements PurchaseController {

    private final PurchaseFacade purchaseFacade;

    public PurchaseControllerImpl(PurchaseFacade purchaseFacade) {
        this.purchaseFacade = purchaseFacade;
    }

    @Override
    @PostMapping
    public ResponseEntity<PurchaseResponse> effectPurchase(PurchaseRequest purchaseRequest) {
        return ResponseEntity.ok(purchaseFacade.savePurchase(purchaseRequest));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PurchaseResponse>> findAllPurchase() {
        return ResponseEntity.ok(purchaseFacade.findAllPurchases());
    }
}
