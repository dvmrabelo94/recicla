package br.com.dvmrabelo.recicla.entrypoint.api.sale.impl;

import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.SaleController;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.dto.SaleRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.dto.SaleResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.sale.facade.SaleFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/sales")
public class SaleControllerImpl implements SaleController {

    private final SaleFacade saleFacade;

    public SaleControllerImpl(SaleFacade saleFacade) {
        this.saleFacade = saleFacade;
    }

    @Override
    @PostMapping
    public ResponseEntity<List<SaleResponse>> effectSale(List<SaleRequest> saleRequestList) {
        return ResponseEntity.ok(saleFacade.saveAllSales(saleRequestList));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SaleResponse>> findAllSale() {
        return ResponseEntity.ok(saleFacade.findAllSales());
    }
}
