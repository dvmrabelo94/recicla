package br.com.dvmrabelo.recicla.dataprovider.material.repository;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    Optional<Material> findByName(String name);
}
