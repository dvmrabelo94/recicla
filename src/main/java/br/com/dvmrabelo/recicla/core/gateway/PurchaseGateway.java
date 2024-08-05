package br.com.dvmrabelo.recicla.core.gateway;

import br.com.dvmrabelo.recicla.dataprovider.purchase.entity.Purchase;

import java.util.List;

public interface PurchaseGateway {

    Purchase savePurchase(Purchase purchase);

    List<Purchase> saveAllPurchases(List<Purchase> purchases);

    List<Purchase> findAllPurchases();
}
