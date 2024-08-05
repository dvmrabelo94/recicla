package br.com.dvmrabelo.recicla.entrypoint.api.sale.facade;

import br.com.dvmrabelo.recicla.core.usecase.MaterialUseCase;
import br.com.dvmrabelo.recicla.core.usecase.SaleUseCase;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.dto.SaleRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.dto.SaleResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.mapper.SaleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleFacade {

    private final SaleUseCase saleUseCase;
    private final SaleMapper saleMapper;
    private final MaterialUseCase materialUseCase;

    public SaleFacade(SaleUseCase saleUseCase, SaleMapper saleMapper, MaterialUseCase materialUseCase) {
        this.saleUseCase = saleUseCase;
        this.saleMapper = saleMapper;
        this.materialUseCase = materialUseCase;
    }

    public SaleResponse saveSale(SaleRequest sale) {
        var material = materialUseCase.findMaterialById(sale.materialId());
        return saleMapper.toDTO(saleUseCase.saveSale(saleMapper.toEntity(sale, material)));
    }

    public List<SaleResponse> findAllSales() {
        return saleUseCase.findAllSales().stream().map(saleMapper::toDTO).toList();
    }

    public List<SaleResponse> saveAllSales(List<SaleRequest> sales) {
        return saleUseCase.saveAllSales(sales.stream().map(sale -> saleMapper.toEntity(sale, materialUseCase.findMaterialById(sale.materialId()))).toList()).stream().map(saleMapper::toDTO).toList();
    }
}
