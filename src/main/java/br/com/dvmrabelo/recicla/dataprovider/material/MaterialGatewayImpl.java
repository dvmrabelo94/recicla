package br.com.dvmrabelo.recicla.dataprovider.material;

import br.com.dvmrabelo.recicla.core.gateway.MaterialGateway;
import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import br.com.dvmrabelo.recicla.dataprovider.material.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialGatewayImpl implements MaterialGateway {

    private final MaterialRepository materialRepository;

    public MaterialGatewayImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material findMaterialById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }

    @Override
    public Material findMaterialByName(String name) {
        return materialRepository.findByName(name).orElse(null);
    }

    @Override
    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material updateMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }
}
