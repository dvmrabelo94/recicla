package br.com.dvmrabelo.recicla.core.usecase;

import br.com.dvmrabelo.recicla.core.gateway.PurchaseGateway;
import br.com.dvmrabelo.recicla.dataprovider.purchase.entity.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseUseCase {

    private final PurchaseGateway purchaseGateway;

    public PurchaseUseCase(PurchaseGateway purchaseGateway) {
        this.purchaseGateway = purchaseGateway;
    }

    public Purchase savePurchase(Purchase purchase) {
        return purchaseGateway.savePurchase(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseGateway.findAllPurchases();
    }
}
