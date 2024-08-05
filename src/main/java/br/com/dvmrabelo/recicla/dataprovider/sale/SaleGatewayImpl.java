package br.com.dvmrabelo.recicla.dataprovider.sale;

import br.com.dvmrabelo.recicla.core.gateway.SaleGateway;
import br.com.dvmrabelo.recicla.dataprovider.sale.entity.Sale;
import br.com.dvmrabelo.recicla.dataprovider.sale.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleGatewayImpl implements SaleGateway {

    private final SaleRepository saleRepository;

    public SaleGatewayImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> saveAllSales(List<Sale> sales) {
        return saleRepository.saveAll(sales);
    }

    @Override
    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }
}
