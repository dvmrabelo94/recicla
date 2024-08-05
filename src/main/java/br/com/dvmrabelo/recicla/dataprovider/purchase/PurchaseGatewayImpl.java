package br.com.dvmrabelo.recicla.dataprovider.purchase;

import br.com.dvmrabelo.recicla.core.gateway.PurchaseGateway;
import br.com.dvmrabelo.recicla.dataprovider.purchase.entity.Purchase;
import br.com.dvmrabelo.recicla.dataprovider.purchase.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseGatewayImpl implements PurchaseGateway {

    private final PurchaseRepository purchaseRepository;

    public PurchaseGatewayImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> saveAllPurchases(List<Purchase> purchases) {
        return purchaseRepository.saveAll(purchases);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }
}
