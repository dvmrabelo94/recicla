package br.com.dvmrabelo.recicla.entrypoint.api.material.facade;

import br.com.dvmrabelo.recicla.core.usecase.MaterialUseCase;
import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.material.mapper.MaterialMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaterialFacade {

    private final MaterialUseCase materialUseCase;
    private final MaterialMapper materialMapper;

    public MaterialFacade(MaterialUseCase materialUseCase, MaterialMapper mapper) {
        this.materialUseCase = materialUseCase;
        this.materialMapper = mapper;
    }

    public MaterialResponse saveMaterial(MaterialRequest material) {
        var materialEntity = materialMapper.toEntity(material);
        materialEntity.setDateCreated(LocalDateTime.now());
        materialEntity.setLastUpdated(LocalDateTime.now());
        return materialMapper.toDTO(materialUseCase.saveMaterial(materialEntity));
    }

    public List<MaterialResponse> findAllMaterials() {
        return materialUseCase.findAllMaterials().stream().map(materialMapper::toDTO).toList();
    }

    public MaterialResponse findMaterialById(Long id) {
        return materialMapper.toDTO(materialUseCase.findMaterialById(id));
    }

    public MaterialResponse findMaterialByName(String name) {
        return materialMapper.toDTO(materialUseCase.findMaterialByName(name));
    }

    public MaterialResponse updateMaterial(Long id, MaterialRequest materialRequest) {
        var material = materialUseCase.findMaterialById(id);
        updateMaterial(materialRequest, material);
        return materialMapper.toDTO(materialUseCase.updateMaterial(material));
    }

    private void updateMaterial(MaterialRequest materialRequest, Material material) {
        material.setName(materialRequest.name());
        material.setDescription(materialRequest.description());
        material.setCategory(materialRequest.category());
        material.setLastUpdated(LocalDateTime.now());
    }
}
