package br.com.dvmrabelo.recicla.core.usecase;

import br.com.dvmrabelo.recicla.core.gateway.MaterialGateway;
import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialUseCase {

    private final MaterialGateway materialGateway;

    public MaterialUseCase(MaterialGateway materialGateway) {
        this.materialGateway = materialGateway;
    }

    public Material findMaterialById(Long id) {
        return materialGateway.findMaterialById(id);
    }

    public Material findMaterialByName(String name) {
        return materialGateway.findMaterialByName(name);
    }

    public List<Material> findAllMaterials() {
        return materialGateway.findAllMaterials();
    }

    public Material saveMaterial(Material material) {
        return materialGateway.saveMaterial(material);
    }

    public Material updateMaterial(Material material) {
        return materialGateway.updateMaterial(material);
    }
}
