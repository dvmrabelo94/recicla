package br.com.dvmrabelo.recicla.dataprovider.sale.repository;

import br.com.dvmrabelo.recicla.dataprovider.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
