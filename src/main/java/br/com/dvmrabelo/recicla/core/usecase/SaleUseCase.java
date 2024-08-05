package br.com.dvmrabelo.recicla.core.usecase;

import br.com.dvmrabelo.recicla.core.gateway.SaleGateway;
import br.com.dvmrabelo.recicla.dataprovider.sale.entity.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleUseCase {

    private final SaleGateway saleGateway;

    public SaleUseCase(SaleGateway saleGateway) {
        this.saleGateway = saleGateway;
    }

    public Sale saveSale(Sale sale) {
        return saleGateway.saveSale(sale);
    }

    public List<Sale> findAllSales() {
        return saleGateway.findAllSales();
    }

    public List<Sale> saveAllSales(List<Sale> sales) {
        return saleGateway.saveAllSales(sales);
    }
}
