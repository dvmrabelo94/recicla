package br.com.dvmrabelo.recicla.core.gateway;

import br.com.dvmrabelo.recicla.dataprovider.sale.entity.Sale;

import java.util.List;

public interface SaleGateway {

    Sale saveSale(Sale sale);

    List<Sale> saveAllSales(List<Sale> sales);

    List<Sale> findAllSales();
}
