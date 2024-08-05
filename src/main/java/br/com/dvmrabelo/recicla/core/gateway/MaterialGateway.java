package br.com.dvmrabelo.recicla.core.gateway;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;

import java.util.List;

public interface MaterialGateway {

    Material findMaterialById(Long id);

    Material findMaterialByName(String name);

    Material saveMaterial(Material material);

    Material updateMaterial(Material material);

    List<Material> findAllMaterials();

}
